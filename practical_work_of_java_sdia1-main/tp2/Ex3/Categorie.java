package Ex3;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private List<Ordinateur> ordinateurs;
    private String nom, description;

    public Categorie(List<Ordinateur> ordinateurs, String nom, String description) {
        this.ordinateurs = ordinateurs;
        this.nom = nom;
        this.description = description;
    }

    public List<Ordinateur> getOrdinateurs() {
        return ordinateurs;
    }

    public void setOrdinateurs(List<Ordinateur> ordinateurs) {
        this.ordinateurs = ordinateurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean ajouterOrdinateur(Ordinateur o) {
        if(ordinateurs.contains(o))
            return false;
        return ordinateurs.add(o);
    }

    public boolean supprimerOrdinateur(Ordinateur o) {
        return this.ordinateurs.remove(o);
    }

    public List<Ordinateur> rechercherParPrix(double p) {
        List<Ordinateur> temp = new ArrayList<Ordinateur>();
        for(Ordinateur o: this.ordinateurs) {
            if(o.getPrix() == p) {
                temp.add(o);
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "ordinateurs=" + ordinateurs +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
