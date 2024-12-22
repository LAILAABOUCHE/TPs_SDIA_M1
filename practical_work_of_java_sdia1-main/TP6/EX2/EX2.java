package org.example.EX2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EX2 {


    public static void main(String[] args) {
        // initialization
        int choice;
        Scanner scanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        DossierContact dc = new DossierContact(new HashMap<String, String>());
        File folder = new File("src\\main\\java\\org\\example\\EX2\\folder");
        BufferedReader reader;

        // read all the data of the files and put it in hashmap in the dossier contact object
        try {
            for(File f:folder.listFiles()) {
                reader = new BufferedReader(new FileReader(f));
                dc.getContacts().put(f.getName().split("\\.")[0],reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // the menu and the action methods
        do {
            System.out.println("1. Rechercher un numéro de téléphone.\n2. Ajouter un nouveau contact.\n3. Supprimer un contact.\n4. Changer le numéro de téléphone d’un contact.\n5. Quitter ce programme.");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("do you want to find who ?");
                    dc.find(stringScanner.nextLine());
                    break;
                case 2:
                    System.out.println("name of person : ");
                    String newAddedPerson = stringScanner.nextLine();
                    System.out.println("number of person : ");
                    String numberOfPerson = stringScanner.nextLine();
                    dc.addContact(folder, newAddedPerson, numberOfPerson);
                    dc.getContacts().put(newAddedPerson,numberOfPerson);
                    break;
                case 3:
                    System.out.println("name of person : ");
                    String newDeletedPerson = stringScanner.nextLine();
                    dc.deleteContact(new File(folder,newDeletedPerson + ".txt"));
                    dc.getContacts().remove(newDeletedPerson);
                    break;
                case 4:
                    System.out.println("name of person : ");
                    String updatedFile = stringScanner.nextLine();
                    System.out.println("number of person : ");
                    String newNumber = stringScanner.nextLine();
                    dc.updateContact(new File(folder,updatedFile + ".txt"), newNumber);
                    dc.getContacts().replace(updatedFile,newNumber);
                    break;
            }
        } while(choice!=5);
    }
}
