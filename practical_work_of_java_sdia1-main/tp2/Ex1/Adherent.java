package Ex1;

public class Adherent extends Personne{
    private String numAdherent;
    public Adherent(String nom, String prenom, String email, String tel, int age, String numAdherent) {
        super(nom, prenom, email, tel, age);
        this.numAdherent = numAdherent;
    }

    public String getNumAdherent() {
        return numAdherent;
    }

    public void setNumAdherent(String numAdherent) {
        this.numAdherent = numAdherent;
    }

    @Override
    public void afficher() {
        System.out.println("nom : " + super.getNom() + ", prenom : " + super.getPrenom() + ", tel : " + super.getTel() + ", email : " + super.getEmail() + ", age : " + super.getAge() + ", num adherent : " + this.numAdherent);
    }
}
