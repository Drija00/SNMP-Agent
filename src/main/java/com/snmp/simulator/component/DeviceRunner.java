package com.snmp.simulator.component;

import com.snmp.simulator.domain.SnmpAgent;
import com.snmp.simulator.form.AgentForm;
import com.snmp.simulator.model.Device;
import com.snmp.simulator.service.DeviceOIDService;
import com.snmp.simulator.service.DeviceService;
import com.snmp.simulator.service.OIDService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("DeviceRunner")
public class DeviceRunner {
    private final DeviceService deviceService;
    private final OIDService oidService;
    private final DeviceOIDService deviceOIDService;
    private List<SnmpAgent> agents = new ArrayList<>();

    public DeviceRunner(DeviceService deviceService, OIDService oidService, DeviceOIDService deviceOIDService) {
        this.deviceService = deviceService;
        this.oidService = oidService;
        this.deviceOIDService = deviceOIDService;
    }

    @Async("deviceRunTaskExecutor")
    public void runDevices() throws Exception {
        List<Device> devices = deviceService.getAll();
        for (Device device : devices) {
            run(device);
        }
        AgentForm form = new AgentForm(agents);
        form.setVisible(true);
        //agents.get(0).sendTrap();
    }

    @Async("deviceRunTaskExecutor")
    public void run(Device device) throws Exception {
        SnmpAgent agent = new  SnmpAgent(device,oidService, deviceOIDService);
        agent.run();
        agents.add(agent);
    }

    public void startForm(){
        System.out.println(agents);
        AgentForm form = new AgentForm(agents);
        form.setVisible(true);
    }
    public List<SnmpAgent> getAgents(){
        return agents;
    }
}
