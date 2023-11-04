package com.exo.entities;


public class Medecin extends Personne{
    private String specialite;
    private String etat;
    private static int nbre;
    
    public Medecin(){
        this.type="medecin";
    }

    public Medecin(String specialite) {
        this.specialite = specialite;
    }

    public Medecin(String nom, String prenom, String tel, String specialite) {
        super(++nbre, nom, prenom, tel);
        this.specialite = specialite;
    }

    public Medecin(int id,String nom, String prenom, String tel, String specialite) {
        super(id, nom, prenom, tel);
        this.specialite = specialite;
    }

    public Medecin(int id,String nom, String prenom, String tel, String type, String specialite,String etat) {
        super(id, nom, prenom, tel);
        this.specialite = specialite;
        this.type=type;
        this.etat =etat;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Medecin "+super.toString()+" , specialite= " + specialite + " ]";
    }
}
