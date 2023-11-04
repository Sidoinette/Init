package com.exo.entities;

public class RendezVous {
    private int id;
    // private int idMed;
    // private int idPatient;
    private Medecin med;
    private Patient patient;
    private String date;
    private String heure;
    private int etat;
    private static int nbre;

    
    public RendezVous() {
    }

    public RendezVous(Medecin med, Patient patient, String date, String heure, int etat) {
        this.id = ++nbre;
        this.med = med;
        this.patient = patient;
        this.date = date;
        this.heure = heure;
        this.etat = etat;
    }

    public RendezVous(int id,Medecin med, Patient patient, String date, String heure, int etat) {
        this.id = id;
        this.med = med;
        this.patient = patient;
        this.date = date;
        this.heure = heure;
        this.etat = etat;
    }

    public RendezVous(int id, String date, String heure, int etat) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Medecin getMed() {
        return med;
    }

    public void setMed(Medecin med) {
        this.med = med;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getHeure() {
        return heure;
    }
    public void setHeure(String heure) {
        this.heure = heure;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RendezVous other = (RendezVous) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "RendezVous [Medecin= " + med + ", Patient= " + patient + ", date=" + date + ", heure=" + heure
                + ", etat=" + etat + "]";
    }
}
