package Ex1;

public class Livre {
    private int isbn;
    private Auteur auteur;

    public Livre(int isbn, Auteur auteur) {
        this.isbn = isbn;
        this.auteur = auteur;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public void afficher() {
        System.out.println("isbn : " + this.isbn + "\nAuteur :");
        auteur.afficher();
    }
}
