package com.snmp.simulator.model;


import com.snmp.simulator.domain.Access;
import com.snmp.simulator.domain.Status;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name = "";
    private String fullName="";
    private String OID=null;
    private String type=null;
    private Access access = null;
    private String defaultValue=null;
    private Status status =null;
    private String description=null;
    @Transient
    private String specValue = null;

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOID() {
        return OID;
    }

    public void setOID(String OID) {
        this.OID = OID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OID oid = (OID) o;
        return Objects.equals(id, oid.id) && Objects.equals(name, oid.name) && Objects.equals(fullName, oid.fullName) && Objects.equals(OID, oid.OID) && Objects.equals(type, oid.type) && access == oid.access && status == oid.status && Objects.equals(description, oid.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, fullName, OID, type, access, status, description);
    }

    @Override
    public String toString() {
        return "OID{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", OID='" + OID + '\'' +
                ", type='" + type + '\'' +
                ", access=" + access +
                ", defaultValue='" + defaultValue + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", specValue='" + specValue + '\'' +
                '}';
    }
}
