package com.danielcorrea.dermapp;

/**
 * Created by DELL on 05/11/2016.
 */
public class Valoration {

    private String nombrev, edadv, puntuv, riesgov, fechav, idv;

    public Valoration() {
    }

    public Valoration(String nombrev, String edadv, String puntuv, String riesgov, String fechav, String idv) {
        this.nombrev = nombrev;
        this.edadv = edadv;
        this.puntuv = puntuv;
        this.riesgov = riesgov;
        this.fechav = fechav;
        this.idv = idv;
    }

    public String getNombrev() {
        return nombrev;
    }

    public String getEdadv() {
        return edadv;
    }

    public String getPuntuv() {
        return puntuv;
    }

    public String getRiesgov() {
        return riesgov;
    }

    public String getFechav() {
        return fechav;
    }

    public String getIdv() {
        return idv;
    }
}
