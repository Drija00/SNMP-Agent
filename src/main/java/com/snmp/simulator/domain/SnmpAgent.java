package com.snmp.simulator.domain;

import com.snmp.simulator.model.Device;
import com.snmp.simulator.model.DeviceOID;
import com.snmp.simulator.service.DeviceOIDService;
import com.snmp.simulator.service.OIDService;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.agent.*;
import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.agent.mo.MOScalar;
import org.snmp4j.agent.mo.MOTableRow;
import org.snmp4j.agent.mo.snmp.*;
import org.snmp4j.agent.security.MutableVACM;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.security.SecurityLevel;
import org.snmp4j.security.SecurityModel;
import org.snmp4j.security.USM;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.util.ResourceUtils;

import javax.persistence.Convert;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * A very simple SNMP Agent implementation utilizing SNMP4J, which will send
 * a trap to the NMS and respond to System Description GET with a hard-coded value.
 *
 * @author Petri Tilli
 */
public class SnmpAgent extends BaseAgent {
    private String address;
    private String agentId;
    private String trapSendingAddress;

    private Long deviceID;

    private OIDService oidService;

    private DeviceOIDService deviceOIDService;

    List<DeviceOID> deviceOIDS = new ArrayList<>();

    public SnmpAgent(Device device, OIDService oidService, DeviceOIDService deviceOIDService) throws Exception {
        super(ResourceUtils.getFile("/conf.agent"), ResourceUtils.getFile("/bootCounter.agent"), new CommandProcessor(new OctetString("simplest")));
        this.address = device.getIpAdress() + "/" + device.getPortRead();
        this.agentId = device.getName();
        this.deviceOIDService = deviceOIDService;
        this.trapSendingAddress = "10.0.1.1/1620";
        this.oidService = oidService;
        this.deviceID = device.getId();

        //Some SNMP4J stuff:
        init();
        addShutdownHook();
        getServer().addContext(new OctetString("public"));
        finishInit();
        run();
        sendColdStartNotification();
        System.out.printf("SNMP agent %s listening on port %s%n", device.getIpAdress(), device.getPortRead());

        //Unregistering the SNMPv2MIB, because we are overriding it:
        this.unregisterManagedObject(this.getSnmpv2MIB());

        List<com.snmp.simulator.model.OID> oids = oidService.getAll();
        deviceOIDS = deviceOIDService.getAll();

        for (MOScalar s : getMoScalar(oids)) {
                registerManagedObject(s);
        }
    }
//    @PostConstruct

    public List<MOScalar> getMoScalar(List<com.snmp.simulator.model.OID> mo) {
        List<MOScalar> moScalars = new ArrayList<>();
        MOScalar moScalar;
        for (com.snmp.simulator.model.OID o : mo) {
            o = checkForSpecValue(o);
            if (o.getAccess().equals(Access.READ_ONLY)) {
                moScalar = checkType(o, (MOAccessImpl) MOAccessImpl.ACCESS_READ_ONLY);
                if(moScalar!=null){
                    moScalars.add(moScalar);
                }

            } else {
                moScalar = checkType(o, (MOAccessImpl) MOAccessImpl.ACCESS_READ_WRITE);
                if(moScalar!=null){
                    moScalars.add(moScalar);
                }
            }
        }
        return moScalars;
    }

    /**
     * Unregisters a managed object
     *
     * @param moGroup
     */
    public void unregisterManagedObject(MOGroup moGroup) {
        moGroup.unregisterMOs(server, getContext(moGroup));
    }

    public com.snmp.simulator.model.OID checkForSpecValue(com.snmp.simulator.model.OID oid){
        for (DeviceOID deviceOID : deviceOIDS){
            if(oid.getId().equals(deviceOID.getOidId()) && deviceID.equals(deviceOID.getDeviceId())){
                oid.setSpecValue(deviceOID.getValue());
                return  oid;
            }
        }
        return oid;
    }
    public MOScalar checkType(com.snmp.simulator.model.OID oid, MOAccessImpl moAccess){
        switch (oid.getType()) {
            case "OctetString":
                return new MOScalar(new OID(oid.getOID()),
                        moAccess,
                        new OctetString((oid.getSpecValue()==null)? oid.getDefaultValue() : oid.getSpecValue()));
            case "Integer":
                return new MOScalar(new OID(oid.getOID()),
                        moAccess,
                        new Integer32(Integer.parseInt((oid.getSpecValue()==null)? oid.getDefaultValue() : oid.getSpecValue())));
            case "Counter":
                return new MOScalar(new OID(oid.getOID()),
                        moAccess,
                        new Counter32(Integer.parseInt((oid.getSpecValue()==null)? oid.getDefaultValue() : oid.getSpecValue())));
            case "Gauge":
                return new MOScalar(new OID(oid.getOID()),
                        moAccess,
                        new Gauge32(Integer.parseInt((oid.getSpecValue()==null)? oid.getDefaultValue() : oid.getSpecValue())));
            case "TimeTicks":
                return new MOScalar(new OID(oid.getOID()),
                        moAccess,
                        new TimeTicks(Integer.parseInt((oid.getSpecValue()==null)? oid.getDefaultValue() : oid.getSpecValue())));
            case "OID":
                return new MOScalar(new OID(oid.getOID()),
                        moAccess,
                        new OID(".1.3.6.1.2.1.1.2.0"));
            default:
        }
        return null;
    }
    /**
     * Registers a managed object
     *
     * @param mo
     */
    public void registerManagedObject(ManagedObject mo) {
        try {
            server.register(mo, null);
        } catch (DuplicateRegistrationException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Sends a trap with OID 1.2.3.4.5 Contains alarm code, alarm text, agent ID and agent's address
     */
    public void sendTrap() {
        // Create PDU
        PDU trap = createTrap();

        // Specify receiver
        Address targetaddress = new UdpAddress(trapSendingAddress);
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString("public"));
        target.setVersion(SnmpConstants.version2c);
        target.setAddress(targetaddress);

        try {
            // Send
            Snmp snmp = new Snmp(new DefaultUdpTransportMapping());
            snmp.send(trap, target, null, null);
            String date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS").format(new Date());
            System.out.println(date + " a trap sent to " + this.trapSendingAddress);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates the trap and its payload.
     *
     * @return Complete trap ready to send
     */
    public PDU createTrap() {
        PDU trap = new PDU();
        trap.setType(PDU.TRAP);

        OID oid = new OID("1.2.3.4.5");
        trap.add(new VariableBinding(SnmpConstants.snmpTrapOID, oid));
        trap.add(new VariableBinding(SnmpConstants.sysUpTime, new TimeTicks(5000))); // put your uptime here
        trap.add(new VariableBinding(SnmpConstants.sysDescr, new OctetString("System Description")));

        Variable alarmCode = new OctetString("666");
        Variable agentId = new OctetString(this.agentId);
        Variable alarmText = new OctetString("elevator jammed!");
        Variable agentAddress = new OctetString(this.address);
        trap.add(new VariableBinding(new OID("1.2.3.4.5.1"), alarmCode));
        trap.add(new VariableBinding(new OID("1.2.3.4.5.2"), agentId));
        trap.add(new VariableBinding(new OID("1.2.3.4.5.3"), alarmText));
        trap.add(new VariableBinding(new OID("1.2.3.4.5.4"), agentAddress));

        return trap;
    }

    @Override
    protected void registerManagedObjects() {
    }

    @Override
    protected void unregisterManagedObjects() {
    }

    @Override
    protected void addUsmUser(USM usm) {
    }

    @Override
    protected void addNotificationTargets(SnmpTargetMIB targetMIB, SnmpNotificationMIB notificationMIB) {
    }

    /**
     * Init Transport mappings, SNMP4J stuff
     */
    @Override
    protected void initTransportMappings() throws IOException {
        transportMappings = new TransportMapping[1];
        UdpAddress udpAddress = new UdpAddress(address);
        DefaultUdpTransportMapping transport = new DefaultUdpTransportMapping(udpAddress);
        transportMappings[0] = transport;
    }

    /**
     * Add views, SNMP4J stuff
     */
    @Override
    protected void addViews(VacmMIB vacm) {
        vacm.addGroup(SecurityModel.SECURITY_MODEL_SNMPv2c, new OctetString(
                        "cpublic"), new OctetString("v1v2group"),
                StorageType.nonVolatile);

        vacm.addAccess(new OctetString("v1v2group"), new OctetString("public"),
                SecurityModel.SECURITY_MODEL_SNMPv2c, SecurityLevel.NOAUTH_NOPRIV,
                MutableVACM.VACM_MATCH_EXACT, new OctetString("fullReadView"),
                new OctetString("fullWriteView"), new OctetString(
                        "fullNotifyView"), StorageType.nonVolatile);

        vacm.addViewTreeFamily(new OctetString("fullReadView"), new OID("1.3"),
                new OctetString(), VacmMIB.vacmViewIncluded,
                StorageType.nonVolatile);

        vacm.addViewTreeFamily(new
                OctetString("fullWriteView"), new OID("1.3.6.1.2.1.1.4.0"), new
                OctetString(), VacmMIB.vacmViewIncluded, StorageType.nonVolatile);
        vacm.addViewTreeFamily(new
                OctetString("fullWriteView"), new OID("1.3.6.1.2.1.1.5.0"), new
                OctetString(), VacmMIB.vacmViewIncluded, StorageType.nonVolatile);
        vacm.addViewTreeFamily(new
                OctetString("fullWriteView"), new OID("1.3.6.1.2.1.1.6.0"), new
                OctetString(), VacmMIB.vacmViewIncluded, StorageType.nonVolatile);
        vacm.addViewTreeFamily(new
                OctetString("fullWriteView"), new OID("1.3.6.1.2.1.4.1.0"), new
                OctetString(), VacmMIB.vacmViewIncluded, StorageType.nonVolatile);
        vacm.addViewTreeFamily(new
                OctetString("fullWriteView"), new OID("1.3.6.1.2.1.4.2.0"), new
                OctetString(), VacmMIB.vacmViewIncluded, StorageType.nonVolatile);
        vacm.addViewTreeFamily(new
                OctetString("fullWriteView"), new OID("1.3.6.1.2.1.11.30.0"), new
                OctetString(), VacmMIB.vacmViewIncluded, StorageType.nonVolatile);
        vacm.addViewTreeFamily(new
                OctetString("fullWriteView"), new OID("1.3.6.1.2.1.25.1.2.0"), new
                OctetString(), VacmMIB.vacmViewIncluded, StorageType.nonVolatile);
        vacm.addViewTreeFamily(new
                OctetString("fullWriteView"), new OID("1.3.6.1.2.1.25.1.3.0"), new
                OctetString(), VacmMIB.vacmViewIncluded, StorageType.nonVolatile);
        vacm.addViewTreeFamily(new
                OctetString("fullWriteView"), new OID("1.3.6.1.2.1.25.1.4.0"), new
                OctetString(), VacmMIB.vacmViewIncluded, StorageType.nonVolatile);
    }

    /**
     * Add communities, SNMP4J stuff
     */
    @Override
    protected void addCommunities(SnmpCommunityMIB communityMIB) {
        Variable[] com2sec = new Variable[]{
                new OctetString("public"), // community name
                new OctetString("cpublic"), // security name
                getAgent().getContextEngineID(), // local engine ID
                new OctetString("public"), // default context name
                new OctetString(), // transport tag
                new Integer32(StorageType.nonVolatile), // storage type
                new Integer32(RowStatus.active) // row status
        };
        MOTableRow row = communityMIB.getSnmpCommunityEntry().createRow(
                new OctetString("public2public").toSubIndex(true), com2sec);
        communityMIB.getSnmpCommunityEntry().addRow((SnmpCommunityMIB.SnmpCommunityEntryRow) row);
    }

    public String getAddress() {
        return address;
    }

    public String getAgentId() {
        return agentId;
    }

}

