package Classes;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

public class Patient {

    private String idPatient;
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty cin;
    private StringProperty telephone;
    private StringProperty email;
    //private java.time.LocalDate dateNaissance;

    // Constructeur
    public Patient(String idPatient, String nom, String prenom, String cin, String telephone, String email) {
        this.idPatient = idPatient;
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.cin = new SimpleStringProperty(cin);
        this.telephone = new SimpleStringProperty(telephone);
        this.email = new SimpleStringProperty(email);
        //this.dateNaissance = dateNaissance;
    }

    // Getters et Setters
    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public String getCin() {
        return cin.get();
    }

    public void setCin(String cin) {
        this.cin.set(cin);
    }

    public StringProperty cinProperty() {
        return cin;
    }

    public String getTelephone() {
        return telephone.get();
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

//   // public java.time.LocalDate getDateNaissance() {
//        return dateNaissance;
//    }

//    public void setDateNaissance(java.time.LocalDate dateNaissance) {
//        this.dateNaissance = dateNaissance;
//    }
}
