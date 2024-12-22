package Ex3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ordinateur> ordinateurs = new ArrayList<>();
        ordinateurs.add(new Ordinateur("xps", "hp", "this pc is so good", 10938, 30));
        ordinateurs.add(new Ordinateur("400x", "dell", "this pc is so good", 4000, 29));
        ordinateurs.add(new Ordinateur("209 ultra", "sony", "this pc is so good", 20938, 12));
        Categorie categorie = new Categorie(ordinateurs, "pc gamer", "this category is good for gaming");
        Client client = new Client(new ArrayList<>(),"jonathan", "jostar", "america", "jojo989@gmail.com", "new york", "0889678812");
        Commande commande = new Commande("84hfu4", new Date(), client,true);
        client.getCommandes().add(commande);
        List<LigneCommande> ligneCommandes = new ArrayList<>();
        for(Ordinateur o: ordinateurs) {
            ligneCommandes.add(new LigneCommande(1, commande, o));
        }
        System.out.println(commande);

    }
}
