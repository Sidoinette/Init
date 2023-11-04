package com.exo.entities;

public class Personne {
    protected int id;
    protected String nom;
    protected String Prenom;
    protected String tel;
    protected String type;

    public Personne(String nom, String prenom, String tel) {
        this.nom = nom;
        Prenom = prenom;
        this.tel = tel;
    }

    public Personne() {
    }
    
    public Personne(int id, String nom, String prenom, String tel) {
        this.id = id;
        this.nom = nom;
        Prenom = prenom;
        this.tel = tel;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return Prenom;
    }
    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        Personne other = (Personne) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return " [nom=" + nom + ", Prenom=" + Prenom + ", tel=" + tel ;
    }
}
