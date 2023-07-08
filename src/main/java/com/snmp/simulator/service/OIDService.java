package com.snmp.simulator.service;

import com.snmp.simulator.model.OID;
import com.snmp.simulator.repository.OIDRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OIDService {
    private final OIDRepository oidRepository;

    public OIDService(OIDRepository oidRepository) {
        this.oidRepository = oidRepository;
    }

    public OID insert(OID oid) {
        return oidRepository.save(oid);
    }

    public OID update(OID oid) {
        return oidRepository.save(oid);
    }

    public void insertAll(LinkedList<OID> oids){
        oidRepository.saveAll(oids);
    }

    public List<OID> getAll(){
        return oidRepository.findAll();
    }

    public void delete(OID oid) {
        oidRepository.delete(oid);
    }
}


