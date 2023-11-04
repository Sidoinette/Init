package com.exo.entities;

import java.util.ArrayList;

public class Patient extends Personne{
    private ArrayList<String> antecedents = new ArrayList<String>();
    private static int nbre;
    private String etat;

    public Patient() {
        this.type="patient";
    }

    public Patient(ArrayList<String> antecedents) {
        this.antecedents = antecedents;
    }


    public Patient(String nom, String prenom, String tel, ArrayList<String> antecedents) {
        super(++nbre, nom, prenom, tel);
        this.antecedents = antecedents;

    }

    public Patient(int id,String nom, String prenom, String tel) {
        super(id, nom, prenom, tel);
    }

    public Patient(int id,String nom, String prenom, String tel,String type){
        super(id, nom, prenom, tel);
        this.type=type;
    }

     public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public ArrayList<String> getAntecedents() {
        return antecedents;
    }

    public void setAntecedents(ArrayList<String> antecedents) {
        this.antecedents = antecedents;
    }

    @Override
    public String toString() {
        return "Patient "+super.toString()+" , antecedents=" + antecedents + "]";
    }
    
}
