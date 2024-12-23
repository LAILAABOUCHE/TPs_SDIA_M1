package Classes;
import java.util.ArrayList;
import java.util.List;

public class CabinetMetierImpl implements ICabinetMetier {

    // Listes temporaires pour simuler une base de données
    private List<Patient> patients = new ArrayList<>();
    private List<Medecin> medecins = new ArrayList<>();
    private List<Consultation> consultations = new ArrayList<>();

    @Override
    public void ajouterPatient(Patient p) {
        patients.add(p);
        System.out.println("Patient ajouté : " + p.getNom() + " " + p.getPrenom());
    }

    @Override
    public List<Patient> listerPatients() {
        return patients;
    }

    @Override
    public Patient rechercherPatient(String motCle) {
        for (Patient p : patients) {
            if (p.getNom().contains(motCle) || p.getPrenom().contains(motCle)) {
                return p; // Retourne le premier patient trouvé par mot clé
            }
        }
        return null; // Si aucun patient trouvé
    }

    @Override
    public void supprimerPatient(String idPatient) {
        patients.removeIf(p -> p.getIdPatient() == idPatient);
        System.out.println("Patient supprimé avec ID : " + idPatient);
    }

    @Override
    public List<Consultation> listerConsultationsPatient(String idPatient) {
        List<Consultation> result = new ArrayList<>();
        for (Consultation c : consultations) {
            if (c.getPatient().getIdPatient() == idPatient) {
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public void ajouterMedecin(Medecin m) {
        medecins.add(m);
        System.out.println("Médecin ajouté : " + m.getNom() + " " + m.getPrenom());
    }

    @Override
    public List<Medecin> listerMedecins() {
        return medecins;
    }

    @Override
    public void supprimerMedecin(String idMedecin) {
        medecins.removeIf(m -> m.getIdMedecin() == idMedecin);
        System.out.println("Médecin supprimé avec ID : " + idMedecin);
    }

    @Override
    public Medecin rechercherMedecin(String idMedecin) {
        for (Medecin m : medecins) {
            if (m.getIdMedecin() == idMedecin) {
                return m;
            }
        }
        return null;  // Retourne null si le médecin avec l'ID spécifié n'est pas trouvé
    }

    @Override
    public List<Consultation> listerConsultationsMedecin(String idMedecin) {
        List<Consultation> result = new ArrayList<>();
        for (Consultation c : consultations) {
            if (c.getMedecin().getIdMedecin() == idMedecin) {
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public void ajouterConsultation(Consultation c) {
        consultations.add(c);
        System.out.println("Consultation ajoutée pour le patient " + c.getPatient().getNom() + " " + c.getPatient().getPrenom());
    }

    @Override
    public List<Consultation> listerConsultations() {
        return consultations;
    }

    @Override
    public void supprimerConsultation(int idConsultation) {
        consultations.removeIf(c -> c.getIdConsultation() == idConsultation);
        System.out.println("Consultation supprimée avec ID : " + idConsultation);
    }
}
