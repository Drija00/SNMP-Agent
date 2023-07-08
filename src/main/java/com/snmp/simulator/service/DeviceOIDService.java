package com.snmp.simulator.service;

import com.snmp.simulator.model.Device;
import com.snmp.simulator.model.DeviceOID;
import com.snmp.simulator.model.OID;
import com.snmp.simulator.repository.DeviceOIDRepository;
import com.snmp.simulator.repository.DeviceRepository;
import com.snmp.simulator.repository.OIDRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeviceOIDService {
    private final DeviceOIDRepository repository;
    private final DeviceRepository deviceRepository;

    private final OIDRepository oidRepository;

    public DeviceOIDService(DeviceOIDRepository repository, DeviceRepository deviceRepository, OIDRepository oidRepository) {
        this.repository = repository;
        this.deviceRepository = deviceRepository;
        this.oidRepository = oidRepository;
    }

    public DeviceOID insert(DeviceOID deviceOid){
        return repository.save(deviceOid);
    }

    public DeviceOID update(DeviceOID deviceOid){
        return repository.save(deviceOid);
    }

    public void delete(DeviceOID deviceOid){
        repository.delete(deviceOid);
    }

    public List<DeviceOID> getAll() {
        List<DeviceOID> deviceOIDs = repository.findAll();
        List<Device> devices = deviceRepository.getByIdIn(deviceOIDs.stream().map(DeviceOID::getDeviceId).collect(Collectors.toSet()));
        List<OID> OIDs = oidRepository.getByIdIn(deviceOIDs.stream().map(DeviceOID::getOidId).collect(Collectors.toSet()));
        Map<Long, Device> deviceMap = devices.stream().collect(Collectors.toMap(Device::getId, item -> item));
        Map<Long,OID> oidMap = OIDs.stream().collect(Collectors.toMap(OID::getId, item -> item));

        deviceOIDs.forEach(item -> item.setDevice(deviceMap.get(item.getDeviceId())));
//        for(DeviceOID item: deviceOIDs) {
//            item.setDevice(deviceMap.get(item.getDevice_id()));
//        }
        deviceOIDs.forEach(item -> item.setOid(oidMap.get(item.getOidId())));

        return deviceOIDs;
    }
}
