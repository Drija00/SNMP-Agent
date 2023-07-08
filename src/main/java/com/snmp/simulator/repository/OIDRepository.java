package com.snmp.simulator.repository;

import com.snmp.simulator.model.OID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OIDRepository extends JpaRepository<OID, Long> {
    List<OID> getByIdIn(Set<Long> ids);
}
