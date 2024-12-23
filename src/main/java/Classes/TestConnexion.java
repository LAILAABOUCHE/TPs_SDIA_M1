package Classes;

import java.sql.Connection;

public class TestConnexion {

    public static void main(String[] args) {
        // Vérification de la connexion
        Connection connection = SingletonConnexionDB.getConnexion();
        if (connection != null) {
            System.out.println("Connexion à la base de données vérifiée !");
        } else {
            System.out.println("Échec de la connexion.");
        }
    }
}
