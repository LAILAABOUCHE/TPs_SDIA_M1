package Ex3;

public class Ordinateur {
    private String nom, marque, description;
    private double prix;
    private int nombreEnStock;

    private Categorie categorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Ordinateur(String nom, String marque, String description, double prix, int nombreEnStock) {
        this.nom = nom;
        this.marque = marque;
        this.description = description;
        this.prix = prix;
        this.nombreEnStock = nombreEnStock;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNombreEnStock() {
        return nombreEnStock;
    }

    public void setNombreEnStock(int nombreEnStock) {
        this.nombreEnStock = nombreEnStock;
    }

    public double prixPourQuantite(int quantite) {
        return this.prix * quantite;
    }

    @Override
    public String toString() {
        return "Ordinateur{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", nombreEnStock=" + nombreEnStock +
                '}';
    }
}
