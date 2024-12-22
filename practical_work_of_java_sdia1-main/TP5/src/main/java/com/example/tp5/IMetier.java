package com.example.tp5;

import java.sql.SQLException;
import java.util.List;

public interface IMetier {
    // gerer professeurs
    public List<Professeur> retournerProfesseurs() throws SQLException;
    public List<Professeur> trouverProfesseurParCin(String s) throws SQLException;
    public boolean ajouterProfesseur(Professeur p) throws SQLException;
    public boolean supprimerProfesseur(int idProf) throws SQLException;
    public boolean modifierProfesseur(Professeur p) throws SQLException;
    public boolean affecterProfesseurADepartement(int id_prof, int id_depart) throws SQLException;

    // gerer departements
    public boolean ajouterDepartement(Departement d) throws SQLException;
    public List<Departement> retournerDepartements() throws SQLException;
    public boolean supprimerDepartement(int id_depart) throws SQLException;
    public boolean modifierDepartement(Departement d) throws SQLException;
    public List<Professeur> afficherProfesseursDeDepartement(int id_depart) throws SQLException;
}
