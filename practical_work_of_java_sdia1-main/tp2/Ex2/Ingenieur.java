package Ex2;

public class Ingenieur extends Employe{
    private String specialite;

    public Ingenieur() {}

    public Ingenieur(String nom, String prenom, String email, String telephone, double salaire, String specialite) {
        super(nom, prenom, email, telephone, salaire);
        this.specialite = specialite;
    }

    @Override
    public double calculerSalaire() {
        return super.getSalaire() + (super.getSalaire()*0.15);
    }

    @Override
    public String toString() {
        return "nom : " + super.getNom() + ", prenom : " + super.getPrenom() + ", telephone : " + super.getTelephone() + ", email : " + super.getEmail() + ", salaire : " + super.getSalaire() + ", specialite : " + this.specialite;
    }
}
