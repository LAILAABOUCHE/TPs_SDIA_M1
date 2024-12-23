package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {
    private static Connection connection;

    // Constructeur privé pour empêcher l'instanciation
    private SingletonConnexionDB() {}

    public static Connection getConnexion() {
        if (connection == null) {
            try {
                // Modifier l'URL, l'utilisateur et le mot de passe selon votre configuration MySQL
                String url = "jdbc:mysql://localhost:3306/cabinet_medical";
                String user = "root";
                String password = "";

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connexion réussie !");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la connexion : " + e.getMessage());
            }
        }
        return connection;
    }
}
