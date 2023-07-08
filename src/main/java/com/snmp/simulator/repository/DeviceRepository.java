package com.snmp.simulator.repository;

import com.snmp.simulator.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {
    List<Device> getByIdIn(Set<Long> ids);
}
