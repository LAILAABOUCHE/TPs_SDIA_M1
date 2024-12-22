package Ex1;

public class Auteur extends Personne {
    private String numAuteur;
    public Auteur(String nom, String prenom, String email, String tel, int age, String numAuteur) {
        super(nom, prenom, email, tel, age);
        this.numAuteur = numAuteur;
    }

    public String getNumAuteur() {
        return numAuteur;
    }

    public void setNumAuteur(String numAuteur) {
        this.numAuteur = numAuteur;
    }

    @Override
    public void afficher() {
        System.out.println("nom : " + super.getNom() + ", prenom : " + super.getPrenom() + ", tel : " + super.getTel() + ", email : " + super.getEmail() + ", age : " + super.getAge() + ", num auteur : " + this.numAuteur);
    }
}
