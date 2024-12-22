package org.example.EX2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DossierContact {
    private HashMap<String, String> contacts;

    public DossierContact(HashMap<String, String> contacts) {
        this.contacts = contacts;
    }

    public DossierContact() {}

    public HashMap<String, String> getContacts() {
        return contacts;
    }

    public void setContacts(HashMap<String, String> contacts) {
        this.contacts = contacts;
    }

    // look for a person if it already exists
    public void find(String searchedPerson) {
        for(String s:getContacts().keySet()) {
            if(s.equals(searchedPerson)) {
                System.out.println(getContacts().get(s));
                return;
            }
        }
        System.out.println("there is no number with the name " + searchedPerson);
    }

    // add a new person
    public void addContact(File dir, String nom, String numero) {
        // Validate directory
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory: " + dir.getAbsolutePath());
            return;
        }

        // Create the file path
        File newFile = new File(dir, nom + ".txt");

        // Write to the file
        try (PrintWriter writer = new PrintWriter(newFile)) {
            writer.println(numero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // update a person
    public void updateContact(File file, String numero) {
        if(!file.exists()) {
            System.out.println("file doesn't exist");
        }
        try(PrintWriter writer = new PrintWriter(file)) {
            // Write to the file;
            writer.println(numero);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // delete a person
    public void deleteContact(File file) {
        System.out.println(file.getAbsoluteFile());
        // Attempt to delete the file
        if (file.exists()) { // Check if the file exists
            if (file.delete()) {
                System.out.println("File deleted successfully: " + file.getAbsolutePath());
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}
