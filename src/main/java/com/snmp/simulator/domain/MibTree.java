package com.snmp.simulator.domain;

import org.ietf.jgss.Oid;

import java.util.ArrayList;
import java.util.HashMap;

public class MibTree {
    private ArrayList<MyOid> folder_oids;
    private ArrayList<MyOid> simple_oids;
    private ArrayList<MyOid> tables_oids;
    private ArrayList<MyOid> editable_oids;
    private ArrayList<MyOid> tableobj_oids;

    public MibTree() {
        folder_oids = new ArrayList<MyOid>();
        simple_oids = new ArrayList<MyOid>();
        tables_oids = new ArrayList<MyOid>();
        editable_oids = new ArrayList<MyOid>();
        tableobj_oids = new ArrayList<MyOid>();

        //addFolderOids();
        //addTableOids();
        addSimpleOids();
        //addEditableOids();
    }

    // Preenchimento da árvore MIB2 e subpastas
    private void addFolderOids() {
        this.folder_oids.add(new MyOid("system", ".1.3.6.1.2.1.1.0"));
        this.folder_oids.add(new MyOid("interfaces", ".1.3.6.1.2.1.2.0"));
        this.folder_oids.add(new MyOid("at", ".1.3.6.1.2.1.3.0"));
        this.folder_oids.add(new MyOid("ip", ".1.3.6.1.2.1.4.0"));
        this.folder_oids.add(new MyOid("icmp", ".1.3.6.1.2.1.5.0"));
        this.folder_oids.add(new MyOid("tcp", ".1.3.6.1.2.1.6.0"));
        this.folder_oids.add(new MyOid("udp", ".1.3.6.1.2.1.7.0"));
        this.folder_oids.add(new MyOid("egp", ".1.3.6.1.2.1.8.0"));
        this.folder_oids.add(new MyOid("snmp", ".1.3.6.1.2.1.11.0"));
        this.folder_oids.add(new MyOid("host", ".1.3.6.1.2.1.25.0"));
    }

    private void addSimpleOids() {
        this.simple_oids.add(new MyOid("sysDescr", ".1.3.6.1.2.1.1.1.0"));
        this.simple_oids.add(new MyOid("sysObjectID", ".1.3.6.1.2.1.1.2.0"));
        this.simple_oids.add(new MyOid("sysUpTime", ".1.3.6.1.2.1.1.3.0"));
        this.simple_oids.add(new MyOid("sysContact", ".1.3.6.1.2.1.1.4.0"));
        this.simple_oids.add(new MyOid("sysName", ".1.3.6.1.2.1.1.5.0"));
        this.simple_oids.add(new MyOid("sysLocation", ".1.3.6.1.2.1.1.6.0"));
        this.simple_oids.add(new MyOid("sysServices", ".1.3.6.1.2.1.1.7.0"));

        this.simple_oids.add(new MyOid("ifNumber", ".1.3.6.1.2.1.2.1.0"));

        this.simple_oids.add(new MyOid("ipForwarding", ".1.3.6.1.2.1.4.1.0"));
        this.simple_oids.add(new MyOid("ipDefaultTTL", ".1.3.6.1.2.1.4.2.0"));
        this.simple_oids.add(new MyOid("ipInReceives", ".1.3.6.1.2.1.4.3.0"));
        this.simple_oids.add(new MyOid("ipInHdrErrors", ".1.3.6.1.2.1.4.4.0"));
        this.simple_oids.add(new MyOid("ipInAddrErrors", ".1.3.6.1.2.1.4.5.0"));
        this.simple_oids.add(new MyOid("ipForwDatagrams", ".1.3.6.1.2.1.4.6.0"));
        this.simple_oids.add(new MyOid("ipInUnknownProtos", ".1.3.6.1.2.1.4.7.0"));
        this.simple_oids.add(new MyOid("ipInDiscards", ".1.3.6.1.2.1.4.8.0"));
        this.simple_oids.add(new MyOid("ipInDelivers", ".1.3.6.1.2.1.4.9.0"));
        this.simple_oids.add(new MyOid("ipOutRequests", ".1.3.6.1.2.1.4.10.0"));
        this.simple_oids.add(new MyOid("ipOutDiscards", ".1.3.6.1.2.1.4.11.0"));
        this.simple_oids.add(new MyOid("ipOutNoRoutes", ".1.3.6.1.2.1.4.12.0"));
        this.simple_oids.add(new MyOid("ipReasmTimeout", ".1.3.6.1.2.1.4.13.0"));
        this.simple_oids.add(new MyOid("ipReasmReqds", ".1.3.6.1.2.1.4.14.0"));
        this.simple_oids.add(new MyOid("ipReasmOKs", ".1.3.6.1.2.1.4.15.0"));
        this.simple_oids.add(new MyOid("ipReasmFails", ".1.3.6.1.2.1.4.16.0"));
        this.simple_oids.add(new MyOid("ipFragOKs", ".1.3.6.1.2.1.4.17.0"));
        this.simple_oids.add(new MyOid("ipFragFails", ".1.3.6.1.2.1.4.18.0"));
        this.simple_oids.add(new MyOid("ipFragCreates", ".1.3.6.1.2.1.4.19.0"));
        this.simple_oids.add(new MyOid("ipRoutingDiscards", ".1.3.6.1.2.1.4.23.0"));

        this.simple_oids.add(new MyOid("icmpInMsgs", ".1.3.6.1.2.1.5.1.0"));
        this.simple_oids.add(new MyOid("icmpInErrors", ".1.3.6.1.2.1.5.2.0"));
        this.simple_oids.add(new MyOid("icmpInDestUnreachs", ".1.3.6.1.2.1.5.3.0"));
        this.simple_oids.add(new MyOid("icmpInTimeExcds", ".1.3.6.1.2.1.5.4.0"));
        this.simple_oids.add(new MyOid("icmpInParmProbs", ".1.3.6.1.2.1.5.5.0"));
        this.simple_oids.add(new MyOid("icmpInSrcQuenchs", ".1.3.6.1.2.1.5.6.0"));
        this.simple_oids.add(new MyOid("icmpInRedirects", ".1.3.6.1.2.1.5.7.0"));
        this.simple_oids.add(new MyOid("icmpInEchos", ".1.3.6.1.2.1.5.8.0"));
        this.simple_oids.add(new MyOid("icmpInEchoReps", ".1.3.6.1.2.1.5.9.0"));
        this.simple_oids.add(new MyOid("icmpInTimestamps", ".1.3.6.1.2.1.5.10.0"));
        this.simple_oids.add(new MyOid("icmpInTimestampReps", ".1.3.6.1.2.1.5.11.0"));
        this.simple_oids.add(new MyOid("icmpInAddrMasks", ".1.3.6.1.2.1.5.12.0"));
        this.simple_oids.add(new MyOid("icmpInAddrMaskReps", ".1.3.6.1.2.1.5.13.0"));
        this.simple_oids.add(new MyOid("icmpOutMsgs", ".1.3.6.1.2.1.5.14.0"));
        this.simple_oids.add(new MyOid("icmpOutErrors", ".1.3.6.1.2.1.5.15.0"));
        this.simple_oids.add(new MyOid("icmpOutDestUnreachs", ".1.3.6.1.2.1.5.16.0"));
        this.simple_oids.add(new MyOid("icmpOutTimeExcds", ".1.3.6.1.2.1.5.17.0"));
        this.simple_oids.add(new MyOid("icmpOutParmProbs", ".1.3.6.1.2.1.5.18.0"));
        this.simple_oids.add(new MyOid("icmpOutSrcQuenchs", ".1.3.6.1.2.1.5.19.0"));
        this.simple_oids.add(new MyOid("icmpOutRedirects", ".1.3.6.1.2.1.5.20.0"));
        this.simple_oids.add(new MyOid("icmpOutEchos", ".1.3.6.1.2.1.5.21.0"));
        this.simple_oids.add(new MyOid("icmpOutEchoReps", ".1.3.6.1.2.1.5.22.0"));
        this.simple_oids.add(new MyOid("icmpOutTimestamps", ".1.3.6.1.2.1.5.23.0"));
        this.simple_oids.add(new MyOid("icmpOutTimestampReps", ".1.3.6.1.2.1.5.24.0"));
        this.simple_oids.add(new MyOid("icmpOutAddrMaskReps", ".1.3.6.1.2.1.5.25.0"));

        this.simple_oids.add(new MyOid("tcpRtoAlgorithm", ".1.3.6.1.2.1.6.1.0"));
        this.simple_oids.add(new MyOid("tcpRtoMin", ".1.3.6.1.2.1.6.2.0"));
        this.simple_oids.add(new MyOid("tcpRtoMax", ".1.3.6.1.2.1.6.3.0"));
        this.simple_oids.add(new MyOid("tcpRtoMaxConn", ".1.3.6.1.2.1.6.4.0"));
        this.simple_oids.add(new MyOid("tcpActiveOpens", ".1.3.6.1.2.1.6.5.0"));
        this.simple_oids.add(new MyOid("tcpPassiveOpens", ".1.3.6.1.2.1.6.6.0"));
        this.simple_oids.add(new MyOid("tcpAttemptFails", ".1.3.6.1.2.1.6.7.0"));
        this.simple_oids.add(new MyOid("tcpEstabResets", ".1.3.6.1.2.1.6.8.0"));
        this.simple_oids.add(new MyOid("tcpCurrEstab", ".1.3.6.1.2.1.6.9.0"));
        this.simple_oids.add(new MyOid("tcpInSegs", ".1.3.6.1.2.1.6.10.0"));
        this.simple_oids.add(new MyOid("tcpOutSegs", ".1.3.6.1.2.1.6.11.0"));
        this.simple_oids.add(new MyOid("tcpRetransSegs", ".1.3.6.1.2.1.6.12.0"));
        this.simple_oids.add(new MyOid("tcpInErrs", ".1.3.6.1.2.1.6.14.0"));
        this.simple_oids.add(new MyOid("tcpOutRsts", ".1.3.6.1.2.1.6.15.0"));

        this.simple_oids.add(new MyOid("udpInDatagrams", ".1.3.6.1.2.1.7.1.0"));
        this.simple_oids.add(new MyOid("udpNoPorts", ".1.3.6.1.2.1.7.2.0"));
        this.simple_oids.add(new MyOid("udpInErrors", ".1.3.6.1.2.1.7.3.0"));
        this.simple_oids.add(new MyOid("udpNoPorts", ".1.3.6.1.2.1.7.4.0"));

        this.simple_oids.add(new MyOid("egpInMsgs", ".1.3.6.1.2.1.8.1.0"));
        this.simple_oids.add(new MyOid("egpInErrors", ".1.3.6.1.2.1.8.2.0"));
        this.simple_oids.add(new MyOid("egpOutMsgs", ".1.3.6.1.2.1.8.3.0"));
        this.simple_oids.add(new MyOid("egpOutErrors", ".1.3.6.1.2.1.8.4.0"));
        this.simple_oids.add(new MyOid("egpAs", ".1.3.6.1.2.1.8.6.0"));

        this.simple_oids.add(new MyOid("transmission", ".1.3.6.1.2.1.10.0"));

        this.simple_oids.add(new MyOid("snmpInPkts", ".1.3.6.1.2.1.11.1.0"));
        this.simple_oids.add(new MyOid("snmpOutPkts", ".1.3.6.1.2.1.11.2.0"));
        this.simple_oids.add(new MyOid("snmpInBadVersions", ".1.3.6.1.2.1.11.3.0"));
        this.simple_oids.add(new MyOid("snmpInBadComunityNames", ".1.3.6.1.2.1.11.4.0"));
        this.simple_oids.add(new MyOid("snmpInBadComunityUses", ".1.3.6.1.2.1.11.5.0"));
        this.simple_oids.add(new MyOid("snmpInASNParseErrs", ".1.3.6.1.2.1.11.6.0"));
        this.simple_oids.add(new MyOid("snmpInTooBigs", ".1.3.6.1.2.1.11.8.0"));
        this.simple_oids.add(new MyOid("snmpInNoSuchNames", ".1.3.6.1.2.1.11.9.0"));
        this.simple_oids.add(new MyOid("snmpInBadValues", ".1.3.6.1.2.1.11.10.0"));
        this.simple_oids.add(new MyOid("snmpInReadOnlys", ".1.3.6.1.2.1.11.11.0"));
        this.simple_oids.add(new MyOid("snmpInGenErrs", ".1.3.6.1.2.1.11.12.0"));
        this.simple_oids.add(new MyOid("snmpInTotalReqVars", ".1.3.6.1.2.1.11.13.0"));
        this.simple_oids.add(new MyOid("snmpInTotalSetVars", ".1.3.6.1.2.1.11.14.0"));
        this.simple_oids.add(new MyOid("snmpInGetRequests", ".1.3.6.1.2.1.11.15.0"));
        this.simple_oids.add(new MyOid("snmpInGetNexts", ".1.3.6.1.2.1.11.16.0"));
        this.simple_oids.add(new MyOid("snmpInSetRequests", ".1.3.6.1.2.1.11.17.0"));
        this.simple_oids.add(new MyOid("snmpInGetResponses", ".1.3.6.1.2.1.11.18.0"));
        this.simple_oids.add(new MyOid("snmpInTraps", ".1.3.6.1.2.1.11.19.0"));
        //this.simple_oids.add(new Oid("snmpEnableAuthenTraps", ".1.3.6.1.2.1.11.30.0"));
        this.simple_oids.add(new MyOid("snmpOutTooBigs", ".1.3.6.1.2.1.11.20.0"));
        this.simple_oids.add(new MyOid("snmpOutNoSuchNames", ".1.3.6.1.2.1.11.21.0"));
        this.simple_oids.add(new MyOid("snmpOutBadValues", ".1.3.6.1.2.1.11.22.0"));
        this.simple_oids.add(new MyOid("snmpOutGenErrs", ".1.3.6.1.2.1.11.24.0"));
        this.simple_oids.add(new MyOid("snmpOutGetRequests", ".1.3.6.1.2.1.11.25.0"));
        this.simple_oids.add(new MyOid("snmpOutGetNexts", ".1.3.6.1.2.1.11.26.0"));
        this.simple_oids.add(new MyOid("snmpOutSetRequests", ".1.3.6.1.2.1.11.27.0"));
        this.simple_oids.add(new MyOid("snmpOutGetResponses", ".1.3.6.1.2.1.11.28.0"));
        this.simple_oids.add(new MyOid("snmpOutTraps", ".1.3.6.1.2.1.11.29.0"));

        this.simple_oids.add(new MyOid("hrSystemUpTime", ".1.3.6.1.2.1.25.1.1.0"));
        //this.simple_oids.add(new Oid("hrSystemDate", ".1.3.6.1.2.1.25.1.2.0"));
        //this.simple_oids.add(new Oid("hrSystemInitialLoadDevice", ".1.3.6.1.2.1.25.1.3.0"));
        //this.simple_oids.add(new Oid("hrSystemInitialLoadParameters", ".1.3.6.1.2.1.25.1.4.0"));
        this.simple_oids.add(new MyOid("hrSystemNumUsers", ".1.3.6.1.2.1.25.1.5.0"));
        this.simple_oids.add(new MyOid("hrSystemProcesses", ".1.3.6.1.2.1.25.1.6.0"));
        this.simple_oids.add(new MyOid("hrSystemMaxProcesses", ".1.3.6.1.2.1.25.1.7.0"));
        this.simple_oids.add(new MyOid("hrStorageTypes", ".1.3.6.1.2.1.25.2.1.0"));
        this.simple_oids.add(new MyOid("hrDeviceTypes", ".1.3.6.1.2.1.25.3.1.0"));
        this.simple_oids.add(new MyOid("hrFSTypes", ".1.3.6.1.2.1.25.3.9.0"));
        this.simple_oids.add(new MyOid("hrSWOSIndex", ".1.3.6.1.2.1.25.4.1.0"));
        this.simple_oids.add(new MyOid("hrSWInstalledLastChange", ".1.3.6.1.2.1.25.6.1.0"));
        this.simple_oids.add(new MyOid("hrSWInstalledLastUpdateTime", ".1.3.6.1.2.1.25.6.2.0"));

        this.simple_oids.add(new MyOid("hostResourcesMibModule", ".1.3.6.1.2.1.25.7.1.0"));

        this.simple_oids.add(new MyOid("hrMIBCompliance", ".1.3.6.1.2.1.25.7.2.1.0"));
        this.simple_oids.add(new MyOid("hrSystemGroup", ".1.3.6.1.2.1.25.7.3.1.0"));
        this.simple_oids.add(new MyOid("hrStorageGroup", ".1.3.6.1.2.1.25.7.3.2.0"));
        this.simple_oids.add(new MyOid("hrDeviceGroup", ".1.3.6.1.2.1.25.7.3.3.0"));
        this.simple_oids.add(new MyOid("hrSWRunGroup", ".1.3.6.1.2.1.25.7.3.4.0"));
        this.simple_oids.add(new MyOid("hrSWRunPerfGroup", ".1.3.6.1.2.1.25.7.3.5.0"));
        this.simple_oids.add(new MyOid("hrSWInstalledGroup", ".1.3.6.1.2.1.25.7.3.6.0"));
    }

    private void addTableOids() {
        //this.tables_oids.add(new MyOid("ifTable", ".1.3.6.1.2.1.2.2"));
        /*this.tables_oids.add(new MyOid("atTable", ".1.3.6.1.2.1.3.1"));
        this.tables_oids.add(new MyOid("ipAddrTable", ".1.3.6.1.2.1.4.20"));
        this.tables_oids.add(new MyOid("ipRouteTable", ".1.3.6.1.2.1.4.21"));
        this.tables_oids.add(new MyOid("ipNetToMediaTable", ".1.3.6.1.2.1.4.22"));
        this.tables_oids.add(new MyOid("tcpConnTable", ".1.3.6.1.2.1.6.13"));
        this.tables_oids.add(new MyOid("udpTable", ".1.3.6.1.2.1.7.5"));
        this.tables_oids.add(new MyOid("egpNeighTable", ".1.3.6.1.2.1.8.5"));
        this.tables_oids.add(new MyOid("hrStorageTable", ".1.3.6.1.2.1.25.2.3"));
        this.tables_oids.add(new MyOid("hrDeviceTable", ".1.3.6.1.2.1.25.3.2"));
        this.tables_oids.add(new MyOid("hrProcessorTable", ".1.3.6.1.2.1.25.3.3"));
        this.tables_oids.add(new MyOid("hrNetworkTable", ".1.3.6.1.2.1.25.3.4"));
        this.tables_oids.add(new MyOid("hrPrinterTable", ".1.3.6.1.2.1.25.3.5"));
        this.tables_oids.add(new MyOid("hrDiskStorageTable", ".1.3.6.1.2.1.25.3.6"));
        this.tables_oids.add(new MyOid("hrPartitionTable", ".1.3.6.1.2.1.25.3.7"));
        this.tables_oids.add(new MyOid("hrFSTable", ".1.3.6.1.2.1.25.3.8"));
        this.tables_oids.add(new MyOid("hrSWRunTable", ".1.3.6.1.2.1.25.4.2"));
        this.tables_oids.add(new MyOid("hrSWRunPerfTable", ".1.3.6.1.2.1.25.5.1"));
        this.tables_oids.add(new MyOid("hrSWInstalledTable", ".1.3.6.1.2.1.25.6.3"));*/
    }

    private void addEditableOids() {
        this.editable_oids.add(new MyOid("sysContact", ".1.3.6.1.2.1.1.4.0"));
        this.editable_oids.add(new MyOid("sysName", ".1.3.6.1.2.1.1.5.0"));
        this.editable_oids.add(new MyOid("sysLocation", ".1.3.6.1.2.1.1.6.0"));
        this.editable_oids.add(new MyOid("ipForwarding", ".1.3.6.1.2.1.4.1.0"));
        this.editable_oids.add(new MyOid("ipDefaultTTL", ".1.3.6.1.2.1.4.2.0"));
        this.editable_oids.add(new MyOid("snmpEnableAuthenTraps", ".1.3.6.1.2.1.11.30.0"));
        this.editable_oids.add(new MyOid("hrSystemDate", ".1.3.6.1.2.1.25.1.2.0"));
        this.editable_oids.add(new MyOid("hrSystemInitialLoadDevice", ".1.3.6.1.2.1.25.1.3.0"));
        this.editable_oids.add(new MyOid("hrSystemInitialLoadParameters", ".1.3.6.1.2.1.25.1.4.0"));
    }

    /*private void addTableObjOids() {
        this.tableobj_oids.add(new MyOid("ifEntry", ".1.3.6.1.2.1.2.2.1.0"));
    }*/

    public ArrayList<MyOid> getFolder_oids(){
        return folder_oids;
    }

    public ArrayList<MyOid> getSimple_oids(){
        return simple_oids;
    }

    public ArrayList<MyOid> getTables_oids(){
        return tables_oids;
    }

    public ArrayList<MyOid> getEditable_oids(){
        return editable_oids;
    }

}

