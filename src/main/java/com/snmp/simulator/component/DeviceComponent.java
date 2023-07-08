package com.snmp.simulator.component;

import com.snmp.simulator.service.DeviceService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DeviceComponent {
    private final DeviceService service;
    private final DeviceRunner deviceRunner;

    public DeviceComponent(DeviceService service, DeviceRunner deviceRunner) {
        this.service = service;
        this.deviceRunner = deviceRunner;
    }
    @PostConstruct
    public void init() throws Exception {
        deviceRunner.runDevices();
        //deviceRunner.startForm();
        /*Device dev = new Device();
        dev.setName("XXX");
        dev.setIpAdress("10.0.0.180");
        dev.setPortRead(161);
        dev.setPortWrite(162);
        dev.setCommunityWrite("dsada");
        dev.setCommunityRead("dasdas");
        dev.setProtocolVersion(ProtocolVersion.V_2C);

        Device dev2 = new Device();
        dev2.setName("YYY");
        dev2.setIpAdress("10.0.0.180");
        dev2.setPortRead(161);
        dev2.setPortWrite(162);
        dev2.setCommunityWrite("dsada");
        dev2.setCommunityRead("dasdas");
        dev2.setProtocolVersion(ProtocolVersion.V_3);

        Device dev3 = new Device();
        dev3.setName("ZZZ");
        dev3.setIpAdress("10.0.0.180");
        dev3.setPortRead(161);
        dev3.setPortWrite(162);
        dev3.setCommunityWrite("dsada");
        dev3.setCommunityRead("dasdas");
        dev3.setProtocolVersion(ProtocolVersion.V_1);
        service.insert(dev);
        service.insert(dev2);
        service.insert(dev3);*/
    }
}
