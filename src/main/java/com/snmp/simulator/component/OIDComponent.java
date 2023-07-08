package com.snmp.simulator.component;

import com.snmp.simulator.domain.Access;
import com.snmp.simulator.domain.MibTree;
import com.snmp.simulator.domain.MyOid;
import com.snmp.simulator.domain.Status;
import com.snmp.simulator.form.AgentForm;
import com.snmp.simulator.model.OID;
import com.snmp.simulator.service.OIDService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class OIDComponent {
    private final OIDService service;

    public OIDComponent(OIDService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        /*OID oid;
        MibTree mibTree = new MibTree();
        List<MyOid> myOids = mibTree.getSimple_oids();
        LinkedList<OID> oids = new LinkedList<>();
        System.out.println(myOids.size());
        for (MyOid mo : myOids) {
            oid = new OID();
            oid.setName(mo.getpropriedade());
            oid.setFullName(mo.getpropriedade().toUpperCase());
            oid.setOID(mo.getOid());
            oid.setAccess(Access.READ_ONLY);
            oid.setStatus(Status.MANDATORY);
            oids.addLast(oid);
        }
        service.insertAll(oids);
        OID oid = new OID();
        oid.setName("Analyzer1");
        oid.setFullName("ANALYZER1");
        oid.setOID("1.2.0.0.4.8.1");
        oid.setAccess(Access.READ_ONLY);
        oid.setStatus(Status.MANDATORY);

        OID oid2 = new OID();
        oid2.setName("Analyzer2");
        oid2.setFullName("ANALYZER2");
        oid2.setOID("1.2.0.0.4.8.1");
        oid2.setAccess(Access.READ_WRITE);
        oid2.setStatus(Status.NOT_MANDATORY);

        OID oid3 = new OID();
        oid3.setName("Analyzer3");
        oid3.setFullName("ANALYZER3");
        oid3.setOID("1.2.0.0.4.8.1");
        oid3.setAccess(Access.READ_ONLY);
        oid3.setStatus(Status.NOT_MANDATORY);

        service.insert(oid);
        service.insert(oid2);
        service.insert(oid3);*/
    }
}
