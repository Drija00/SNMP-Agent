package com.snmp.simulator.repository;

import com.snmp.simulator.model.DeviceOID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceOIDRepository extends JpaRepository<DeviceOID,Long> {
}
