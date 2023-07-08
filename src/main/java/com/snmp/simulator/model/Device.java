package com.snmp.simulator.model;

import com.snmp.simulator.domain.ProtocolVersion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name = null;
    private String ipAdress = null;
    private int portRead;
    private int portWrite;
    private String communityWrite = null;
    private String communityRead=null;
    private ProtocolVersion protocolVersion = null;

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

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public int getPortRead() {
        return portRead;
    }

    public void setPortRead(int portRead) {
        this.portRead = portRead;
    }

    public int getPortWrite() {
        return portWrite;
    }

    public void setPortWrite(int portWrite) {
        this.portWrite = portWrite;
    }

    public String getCommunityWrite() {
        return communityWrite;
    }

    public void setCommunityWrite(String communityWrite) {
        this.communityWrite = communityWrite;
    }

    public String getCommunityRead() {
        return communityRead;
    }

    public void setCommunityRead(String communityRead) {
        this.communityRead = communityRead;
    }

    public ProtocolVersion getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(ProtocolVersion protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return portRead == device.portRead && portWrite == device.portWrite && Objects.equals(id, device.id) && Objects.equals(name, device.name) && Objects.equals(ipAdress, device.ipAdress) && Objects.equals(communityWrite, device.communityWrite) && Objects.equals(communityRead, device.communityRead) && protocolVersion == device.protocolVersion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ipAdress, portRead, portWrite, communityWrite, communityRead, protocolVersion);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ipAdress='" + ipAdress + '\'' +
                ", portRead=" + portRead +
                ", portWrite=" + portWrite +
                ", communityWrite='" + communityWrite + '\'' +
                ", communityRead='" + communityRead + '\'' +
                ", protocolVersion=" + protocolVersion +
                '}';
    }
}
