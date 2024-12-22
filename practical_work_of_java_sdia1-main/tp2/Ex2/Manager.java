package Ex2;

public class Manager extends Employe{
    private String service;

    public Manager() {
    }

    public Manager(String nom, String prenom, String email, String telephone, double salaire, String service) {
        super(nom, prenom, email, telephone, salaire);
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public double calculerSalaire() {
        return super.getSalaire() + super.getSalaire()*0.2;
    }

    @Override
    public String toString() {
        return "nom : " + super.getNom() + ", prenom : " + super.getPrenom() + ", telephone : " + super.getTelephone() + ", email : " + super.getEmail() + ", salaire : " + super.getSalaire() + ", service : " + this.service;
    }
}
