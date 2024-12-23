package Classes;

import java.util.List;
import java.util.Scanner;

public class CabinetAppConsole {
    private static ICabinetMetier metier = new CabinetMetierImpl();  // Implémentation du service métier

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Affichage du menu
            System.out.println("\n=== Menu ===");
            System.out.println("0. rechercher medcin");
            System.out.println("1. Ajouter un patient");
            System.out.println("2. Lister les patients");
            System.out.println("3. Rechercher un patient");
            System.out.println("4. Ajouter un médecin");
            System.out.println("5. Lister les médecins");
            System.out.println("6. Ajouter une consultation");
            System.out.println("7. Lister les consultations");
            System.out.println("8. Quitter");

            // Lire le choix de l'utilisateur
            System.out.print("Choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer le \n restant

            switch (choix) {

                case 1:
                    ajouterPatient(scanner);
                    break;
                case 2:
                    listerPatients();
                    break;
                case 3:
                    rechercherPatient(scanner);
                    break;
                case 4:
                    ajouterMedecin(scanner);
                    break;
                case 5:
                    listerMedecins();
                    break;
                case 6:
                    ajouterConsultation(scanner);
                    break;
                case 7:
                    listerConsultations();
                    break;
                case 8:
                    exit = true;
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide. Essayez encore.");
            }
        }
    }

    // Méthodes pour interagir avec l'utilisateur
    private static void ajouterPatient(Scanner scanner) {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("CIN: ");
        String cin = scanner.nextLine();
        System.out.print("Téléphone: ");
        String telephone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        //System.out.print("Date de naissance (yyyy-mm-dd): ");
        //String dateNaissance = scanner.nextLine();
        //java.time.LocalDate localDate = java.time.LocalDate.parse(dateNaissance);

        Patient patient = new Patient("0", nom, prenom, cin, telephone, email);
        PatientController.ajouterPatient(patient);
        System.out.println("Patient ajouté !");
    }

    private static void listerPatients() {
        List<Patient> patients = metier.listerPatients();
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    private static void rechercherPatient(Scanner scanner) {
        System.out.print("Mot-clé (nom ou prénom): ");
        String motCle = scanner.nextLine();
        Patient patient = metier.rechercherPatient(motCle);
        if (patient != null) {
            System.out.println("Patient trouvé: " + patient);
        } else {
            System.out.println("Aucun patient trouvé.");
        }
    }

    private static void ajouterMedecin(Scanner scanner) {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Téléphone: ");
        String telephone = scanner.nextLine();

        // Remarque : ID médecin peut être auto-généré par la base de données, donc on passe une valeur par défaut (0)
        Medecin medecin = new Medecin("0", nom, prenom, email, telephone);
        metier.ajouterMedecin(medecin);
        System.out.println("Médecin ajouté !");
    }

    private static void listerMedecins() {
        List<Medecin> medecins = metier.listerMedecins();
        for (Medecin m : medecins) {
            System.out.println(m);
        }
    }

    private static void ajouterConsultation(Scanner scanner) {
        System.out.print("ID du patient: ");
        String idPatient = scanner.nextLine();
        System.out.print("ID du médecin: ");
        String idMedecin = scanner.nextLine();
        System.out.print("Date de la consultation (yyyy-mm-dd): ");
        String dateConsultation = scanner.next();
        java.time.LocalDate localDate = java.time.LocalDate.parse(dateConsultation);

        Patient patient = metier.rechercherPatient(idPatient); // Assurez-vous que cette méthode retourne le bon patient
        Medecin medecin = metier.rechercherMedecin(idMedecin); // Assurez-vous que cette méthode retourne le bon médecin

        if (patient != null && medecin != null) {
            Consultation consultation = new Consultation(0, localDate, patient, medecin);
            metier.ajouterConsultation(consultation);
            System.out.println("Consultation ajoutée !");
        } else {
            System.out.println("Patient ou médecin introuvable.");
        }
    }

    private static void listerConsultations() {
        List<Consultation> consultations = metier.listerConsultations();
        for (Consultation c : consultations) {
            System.out.println(c);
        }
    }
}
