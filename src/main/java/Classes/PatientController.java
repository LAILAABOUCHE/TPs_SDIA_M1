package Classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class PatientController {

    private static final String URL = "jdbc:mysql://localhost:3306/cabinet_medical";
    private static final String USER = "root";  // Remplacez par votre nom d'utilisateur MySQL
    private static final String PASSWORD = "";  // Remplacez par votre mot de passe MySQL

    public static void ajouterPatient(Patient patient) {
        String query = "INSERT INTO patients (nom, prenom, cin, telephone, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, patient.getNom());
            stmt.setString(2, patient.getPrenom());
            stmt.setString(3, patient.getCin());
            stmt.setString(4, patient.getTelephone());
            stmt.setString(5, patient.getEmail());
           // stmt.setDate(6, java.sql.Date.valueOf(patient.getDateNaissance())); // Conversion LocalDate to java.sql.Date

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Patient ajouté avec succès !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
