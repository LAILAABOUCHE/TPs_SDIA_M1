package Classes;

public class Consultation {

        private int idConsultation;
        private java.time.LocalDate dateConsultation;
        private Patient patient;
        private Medecin medecin;

        // Constructeur
        public Consultation(int idConsultation, java.time.LocalDate dateConsultation, Patient patient, Medecin medecin) {
            this.idConsultation = idConsultation;
            this.dateConsultation = dateConsultation;
            this.patient = patient;
            this.medecin = medecin;
        }

        // Getters et Setters
        public int getIdConsultation() {
            return idConsultation;
        }

        public void setIdConsultation(int idConsultation) {
            this.idConsultation = idConsultation;
        }

        public java.time.LocalDate getDateConsultation() {
            return dateConsultation;
        }

        public void setDateConsultation(java.time.LocalDate dateConsultation) {
            this.dateConsultation = dateConsultation;
        }

        public Patient getPatient() {
            return patient;
        }

        public void setPatient(Patient patient) {
            this.patient = patient;
        }

        public Medecin getMedecin() {
            return medecin;
        }

        public void setMedecin(Medecin medecin) {
            this.medecin = medecin;
        }


}
