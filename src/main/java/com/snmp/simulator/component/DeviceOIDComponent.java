package com.snmp.simulator.component;

import com.snmp.simulator.model.DeviceOID;
import com.snmp.simulator.service.DeviceOIDService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DeviceOIDComponent {
    private final DeviceOIDService service;

    public DeviceOIDComponent(DeviceOIDService service) {
        this.service = service;
    }

    @PostConstruct
    public void init(){
        /*DeviceOID deviceOid = new DeviceOID();
        deviceOid.setOidId(8L);
        deviceOid.setDeviceId(8L);
        deviceOid.setValue("JHSKAH");

        DeviceOID deviceOid2 = new DeviceOID();
        deviceOid2.setOidId(9L);
        deviceOid2.setDeviceId(9L);
        deviceOid2.setValue("GKHKJ");

        DeviceOID deviceOid3 = new DeviceOID();
        deviceOid3.setOidId(10L);
        deviceOid3.setDeviceId(10L);
        deviceOid3.setValue("MVBVB");
        service.insert(deviceOid);
        service.insert(deviceOid2);
        service.insert(deviceOid3);*/

        /*List<DeviceOID> deviceOIDS = service.getAll();
        System.out.println(deviceOIDS);*/
    }
}
