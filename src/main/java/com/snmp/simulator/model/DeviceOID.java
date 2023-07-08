package com.snmp.simulator.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DeviceOID {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long deviceId;
    private Long oidId;
    private String value;

    @Transient
    private Device device;
    @Transient
    private OID oid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getOidId() {
        return oidId;
    }

    public void setOidId(Long oidId) {
        this.oidId = oidId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public OID getOid() {
        return oid;
    }

    public void setOid(OID oid) {
        this.oid = oid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceOID deviceOID = (DeviceOID) o;
        return Objects.equals(id, deviceOID.id) && Objects.equals(deviceId, deviceOID.deviceId) && Objects.equals(oidId, deviceOID.oidId) && Objects.equals(value, deviceOID.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, oidId, value);
    }

    @Override
    public String toString() {
        return "DeviceOID{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", oidId=" + oidId +
                ", value='" + value + '\'' +
                ", device=" + device +
                ", oid=" + oid +
                '}';
    }
}
