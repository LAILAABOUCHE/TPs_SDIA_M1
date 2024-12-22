package com.example.tp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            IMetier metier = new IMetierImp();
            List<Departement> departements = metier.retournerDepartements();
            List<Professeur> professeurs = metier.retournerProfesseurs();

            System.out.println("les professeurs sont : ");
            // afficher les professeurs
            System.out.println(professeurs);

            System.out.println("le professeur qui a le mot cle 'CIN67890' est : ");
            // trouver un professeur par mot cle
            System.out.println(metier.trouverProfesseurParCin("CIN67890"));

            // ajouter un professeur
            Professeur professeur4 = new Professeur(4, "Jack", "Daniel", "CIN90667",
                    "101 Pine St", "143-009-8945", "jack.daniel@example.com",
                    new Date(), departements.get(0));
            if(metier.ajouterProfesseur(professeur4)) {
                System.out.println("on a ajouté un nouveau professeur 4");
            }

            // supprimer un professeur
            if(metier.supprimerProfesseur(professeurs.get(1).getId_prof())) {
                System.out.println("on a supprimer professeur 2");
            }

            // modifier un professeur
            professeur4.setEmail("newEmailProfesseur4@gmail.com");
            if(metier.modifierProfesseur(professeur4)) {
                System.out.println("on a modifier le professeur numero 4");
            }

            // affecter un professeur a un departement
            if(metier.affecterProfesseurADepartement(professeur4.getId_prof(), 1)) {
                System.out.println("on a affectué le professeur 4 au departement 1");
            }

            // ajouter un departement
            Departement department4 = new Departement("Biology", new ArrayList<>());
            if(metier.ajouterDepartement(department4)) {
                System.out.println("on a ajouté un departement");
            }

            // afficher la liste des departement
            System.out.println("les departement sont : ");
            System.out.println(departements);

            // supprimer un departement
            if(metier.supprimerDepartement(4)) {
                System.out.println("on a supprimé le departement 4");
            }

            // modifier un departement
            department4.setNom("Computer science and machine learning");
            if(metier.modifierDepartement(department4)) {
                System.out.println("on a modifié le departement 4");
            }

            // afficher les professeur d'un departement
            System.out.println("les professeurs du departement 1 sont : ");
            System.out.println(metier.afficherProfesseursDeDepartement(1));;

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
