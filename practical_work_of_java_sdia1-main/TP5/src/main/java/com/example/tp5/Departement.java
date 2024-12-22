package com.example.tp5;

import java.util.List;

public class Departement {
    private int id_depart;
    private String nom;

    private List<Professeur> professeurs;

    public Departement(int id_depart) {
        this.id_depart = id_depart;
    }

    public Departement(String nom, List<Professeur> professeurs) {
        this.nom = nom;
        this.professeurs = professeurs;
    }

    public Departement(int id_depart, String nom, List<Professeur> professeurs) {
        this.id_depart = id_depart;
        this.nom = nom;
        this.professeurs = professeurs;
    }

    public int getId_depart() {
        return id_depart;
    }

    public void setId_depart(int id_depart) {
        this.id_depart = id_depart;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id_deprat=" + id_depart +
                ", nom='" + nom + '\'' +
                ", professeurs=" + professeurs +
                '}';
    }
}
