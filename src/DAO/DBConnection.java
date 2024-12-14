package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // URL de connexion à la base de données MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/TP1";
    // Nom d'utilisateur de la base de données
    private static final String USER = "root";
    // Mot de passe de la base de données
    private static final String PASSWORD = "";

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() throws SQLException {
        // Établir et retourner la connexion avec les paramètres fournis
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
