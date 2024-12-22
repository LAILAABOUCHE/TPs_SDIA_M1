package org.example.EX3;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl productHelper = new MetierProduitImpl(null, new File("src\\main\\java\\org\\example\\EX3\\products.dat"));

        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        ObjectInputStream ois;
        FileInputStream fis;
        try {
            fis = new FileInputStream(productHelper.getFile());
            ois = new ObjectInputStream(fis);
            productHelper.setProducts((ArrayList<Product>)ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }

        do {
            System.out.println("1. Afficher la liste des produits.\n2. Rechercher un produit par son nom.\n3. Ajouter un nouveau produit dans la liste.\n4. Supprimer un produit par nom\n5. Sauvegarder les produits.\n6. Quitter ce programme.");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for(Product p:productHelper.getAll()) {
                        System.out.println(p.getName());
                    }
                    break;
                case 2:
                    System.out.println("le nom de produit est :");
                    String nom = stringScanner.nextLine();
                    System.out.println(productHelper.findByNom(nom));
                    break;
                case 3:
                    System.out.println("le nom de nouveau produit :");
                    Product p = new Product();
                    p.setName(stringScanner.nextLine());
                    productHelper.add(p);
                    break;
                case 4:
                    System.out.println("le nom de produit : ");
                    productHelper.delete(stringScanner.nextLine());
                    break;
                case 5:
                    productHelper.saveAll();
                    break;
            }
        }while(choice != 6);
    }
}
