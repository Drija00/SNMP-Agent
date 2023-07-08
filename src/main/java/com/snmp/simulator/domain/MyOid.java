package com.snmp.simulator.domain;

public class MyOid {
    private String propriedade, oid, tipo;

    public MyOid(String propriedade, String oid) {
        super();
        this.propriedade = propriedade;
        this.oid = oid;
    }

    public String getpropriedade() {
        return propriedade;
    }

    public void setpropriedade(String propriedade) {
        this.propriedade = propriedade;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return propriedade;
    }

}
