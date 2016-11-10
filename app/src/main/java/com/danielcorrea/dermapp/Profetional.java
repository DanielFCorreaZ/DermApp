package com.danielcorrea.dermapp;

import java.util.ArrayList;

/**
 * Created by DELL on 05/11/2016.
 */
public class Profetional {

    private String nombrep, usuariop, contrap, idp;

    private ArrayList<Valoration> valoraciones;

    public Profetional() {
    }

    public Profetional(String nombrep, String usuariop, String contrap, String idp, ArrayList<Valoration> valoraciones) {
        this.nombrep = nombrep;
        this.usuariop = usuariop;
        this.contrap = contrap;
        this.idp = idp;
        this.valoraciones = valoraciones;
    }

    public String getNombrep() {
        return nombrep;
    }

    public String getUsuariop() {
        return usuariop;
    }

    public String getContrap() {
        return contrap;
    }

    public String getIdp() {
        return idp;
    }

    public ArrayList<Valoration> getValoraciones() {
        return valoraciones;
    }
}
