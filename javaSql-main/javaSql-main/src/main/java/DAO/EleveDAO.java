package DAO;

import modele.Eleve;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class EleveDAO {

    public static List<Eleve> getEleves() {
        List<Eleve> eleves = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_ecole", "mamaneib1u_appli", "32031496");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM televe");
            while (rs.next()) {
                eleves.add(new Eleve(rs.getString(1), rs.getString(2),rs.getString(3)));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return eleves;
    }
    public void ajouterEleve(Eleve eleve) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_ecole", "mamaneib1u_appli", "32031496");
            PreparedStatement statement = con.prepareStatement("INSERT INTO televe (nom, prenom) VALUES (?, ?)");
            statement.setString(1, eleve.getNom());
            statement.setString(2, eleve.getPrenom());


            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        }

        public void supprimerEleve(String id) {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_ecole", "mamaneib1u_appli", "32031496");
                PreparedStatement statement = con.prepareStatement("Delete from televe WHERE id = ? ");
                statement.setString(1,id);
                statement.executeUpdate();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public void modiferEleve(String id,String nom,String prenom){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_ecole", "mamaneib1u_appli", "32031496");
                PreparedStatement statement = con.prepareStatement("update televe SET nom = ?, prenom = ? WHERE id = ? ");
                statement.setString(1,nom);
                statement.setString(2,prenom);
                statement.setString(3,id);
                statement.executeUpdate();
                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }



}


