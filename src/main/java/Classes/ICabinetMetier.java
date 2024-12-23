package Classes;

import java.util.List;

public interface ICabinetMetier {
    void ajouterPatient(Patient p);
    List<Patient> listerPatients();
    Patient rechercherPatient(String motCle);
    void supprimerPatient(String idPatient);
    List<Consultation> listerConsultationsPatient(String idPatient);

    void ajouterMedecin(Medecin m);
    List<Medecin> listerMedecins();
    void supprimerMedecin(String idMedecin);
    Medecin rechercherMedecin(String idMedecin);
    List<Consultation> listerConsultationsMedecin(String idMedecin);

    void ajouterConsultation(Consultation c);
    List<Consultation> listerConsultations();
    void supprimerConsultation(int idConsultation);




}



