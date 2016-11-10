package com.danielcorrea.dermapp;

import java.util.ArrayList;

/**
 * Created by DELL on 05/11/2016.
 */
public class Hospital {

    private String nombreh, abreh, codh, lath, longh, idh;

    private ArrayList<Profetional> profesionales;

    public Hospital() {
    }

    public Hospital(ArrayList<Profetional> profesionales,String nombreh, String abreh, String codh, String lath, String longh, String idh) {
        this.nombreh = nombreh;
        this.abreh = abreh;
        this.codh = codh;
        this.lath = lath;
        this.longh = longh;
        this.idh = idh;
        this.profesionales = profesionales;
    }

    public String getNombreh() {
        return nombreh;
    }

    public String getAbreh() {
        return abreh;
    }

    public String getCodh() {
        return codh;
    }

    public String getLath() {
        return lath;
    }

    public String getLongh() {
        return longh;
    }

    public String getIdh() {
        return idh;
    }

    public ArrayList<Profetional> getProfesionales() {
        return profesionales;
    }
}
