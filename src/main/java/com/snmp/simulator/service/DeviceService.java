package com.snmp.simulator.service;

import com.snmp.simulator.model.Device;
import com.snmp.simulator.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class DeviceService {
    private final DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public Device insert(Device dev){
        return repository.save(dev);
    }

    public Device update(Device dev){
        return repository.save(dev);
    }

    public void delete(Device dev){
        repository.delete(dev);
    }

    public List<Device> getAll() {
        return repository.findAll();
    }
}
