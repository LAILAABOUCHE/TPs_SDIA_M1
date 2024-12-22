package org.example.EX3;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        MetierClientImpl clientHelper = new MetierClientImpl(null, new File("src\\main\\java\\org\\example\\EX3\\clients.dat"));

        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        ObjectInputStream ois;
        FileInputStream fis;
        try {
            fis = new FileInputStream(clientHelper.getFile());
            ois = new ObjectInputStream(fis);
            clientHelper.setClients((ArrayList<Client>)ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Client client1 = new Client("Alice", "Johnson", "123 Maple Street", "555-123-4567", "alice.johnson@example.com");
//        Client client2 = new Client("Bob", "Smith", "456 Oak Avenue", "555-234-5678", "bob.smith@example.com");
//        Client client3 = new Client("Charlie", "Brown", "789 Pine Lane", "555-345-6789", "charlie.brown@example.com");
//        Client client4 = new Client("Diana", "Prince", "101 Hero Road", "555-456-7890", "diana.prince@example.com");
//        Client client5 = new Client("Edward", "Jones", "202 Business Blvd", "555-567-8901", "edward.jones@example.com");
//
//        // Store them in a list
//        List<Client> clients = new ArrayList<>();
//        clients.add(client1);
//        clients.add(client2);
//        clients.add(client3);
//        clients.add(client4);
//        clients.add(client5);

//        clientHelper.setClients(clients);
//        clientHelper.saveAll();


        do {
            System.out.println("1. Afficher la liste des clients.\n2. Rechercher un client par son nom.\n3. Ajouter un nouveau client dans la liste.\n4. Supprimer un client par nom\n5. Sauvegarder les clients.\n6. Quitter ce programme.");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for(Client c:clientHelper.getAll()) {
                        System.out.println(c.getFirstName());
                    }
                    break;
                case 2:
                    System.out.println("le nom de client est :");
                    String nom = stringScanner.nextLine();
                    System.out.println(clientHelper.findByNom(nom));
                    break;
                case 3:
                    System.out.println("le nom de nouveau client :");
                    Client c = new Client();
                    c.setFirstName(stringScanner.nextLine());
                    clientHelper.getAll().add(c);
                    break;
                case 4:
                    System.out.println("le nom de client : ");
                    clientHelper.delete(stringScanner.nextLine());
                    break;
                case 5:
                    clientHelper.saveAll();
                    break;
            }
        }while(choice != 6);
    }
}
