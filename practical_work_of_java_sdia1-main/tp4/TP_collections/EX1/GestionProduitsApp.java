package TP_collections.EX1;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionProduitsApp {
    public static void main(String[] args) {
        ArrayList<Produit> produits = new ArrayList<>();
        produits.add(new Produit(1, "p1", 1111));
        produits.add(new Produit(2, "p2", 2222));
        produits.add(new Produit(3, "p3", 3333));
        produits.add(new Produit(4, "p4", 4444));
        produits.remove(2);
        for(Produit p:produits) {
            System.out.println(p);
        }
        produits.set(2,new Produit(5,"5",555));
        Scanner scanner = new Scanner(System.in);
        String nom = scanner.nextLine();
        for(Produit p:produits) {
            if(p.getNom().equals(nom)){
                System.out.println(p);
            }
        }
    }
}
