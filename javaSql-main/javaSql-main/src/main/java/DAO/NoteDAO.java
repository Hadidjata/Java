package DAO;

import modele.Eleve;
import modele.MatiereEnum;
import modele.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

   public static List<Note> getNotes(){
        List<Note> notes = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_ecole", "mamaneib1u_appli", "32031496");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tnot");
            while (rs.next()) {
                notes.add(new Note(MatiereEnum.valueOf(rs.getString(2).toUpperCase()),rs.getString(3), rs.getString(4),rs.getString(1)));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return notes;
    }

    public void ajouterNote(Note note) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/mamaneib1u_ecole", "mamaneib1u_appli", "32031496");
            PreparedStatement statement = con.prepareStatement("INSERT INTO tnot (matiere, valeur,eleveid) VALUES (?,?,?)");
            statement.setString(1, note.getMatiere());
            statement.setString(2, note.getValeur());
            statement.setString(3,note.getEleveid());
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
