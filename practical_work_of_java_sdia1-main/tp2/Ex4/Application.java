package Ex4;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        IMetierProduit helper = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        int choix = 6;
        do {
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher des produits par mot clé.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Récupérer et afficher un produit par ID.");
            System.out.println("5. Supprimer un produit par id.");
            System.out.println("6. quitter");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch(choix) {
                case 1:
                    for(Produit p:helper.getAll()) {
                        System.out.println(p.toString());
                    }
                    break;
                case 2:
                    System.out.println("ecrire le mot cle : ");
                    List<Produit> ps = helper.findByNom(scanner.nextLine());
                    for(Produit p:ps) {
                        System.out.println(p.toString());
                    }
                    break;
                case 3:
                    System.out.println("ecrire les donnees de produit : (id, nombreEnStock, nom, marque, description, prix)");
                    int id3 = scanner.nextInt();
                    int nbstock = scanner.nextInt();
                    scanner.nextLine();
                    Produit p = new Produit(id3,nbstock,scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextDouble());
                    helper.add(p);
                    break;
                case 4:
                    System.out.println("entrer l'id : ");
                    int id4 = scanner.nextInt();
                    Produit p4 = helper.findById(id4);
                    System.out.println(p4);
                    break;
                case 5:
                    System.out.println("entrer l'id : ");
                    int id5 = scanner.nextInt();
                    helper.delete(id5);
            }
        } while(choix!=6);
    }
}
