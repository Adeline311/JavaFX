import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mysqlconnect
{
    Connection conn = null;

    public static Connection ConnectDb() {
        try {
            // Charger le pilote JDBC SQLite
            Class.forName("org.sqlite.JDBC");
            // Créer une connexion à la base de données nommée projetIHM
            String url = "jdbc:sqlite:baseDonnee.db";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connexion à la base de données SQLite établie !");
            return conn;
        } catch (Exception ex) {
              ex.printStackTrace();
            System.out.println("Nopee");
            return null;
        }
        
    }
     public static ObservableList<Etudiant> getEtu()  {
     Connection conn = ConnectDb();
     ObservableList<Etudiant> etudiant = FXCollections.observableArrayList();
     try {
            PreparedStatement ps = conn.prepareStatement("select * from Etudiant");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etudiant.add(new Etudiant (rs.getString("Nom"),rs.getString("Prenom"),Integer.parseInt(rs.getString("Annee")),rs.getString("Parcours"),rs.getString("Promo"),Integer.parseInt(rs.getString("ID"))));
            }
        } catch (Exception e) {
        // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("Nope");
            return null;
            }
     return etudiant;
     }



}
