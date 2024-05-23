import java.sql.*;
import java.util.List;

import DAO.EleveDAO;

import DAO.NoteDAO;
import modele.Eleve;
import modele.MatiereEnum;
import modele.Note;

import javax.xml.transform.stream.StreamSource;

public class Main {
    public static void main(String[] args) {
//    afficherEleves();
//    new EleveDAO().modiferEleve("11","TILIOUINE","Lièce");
//    afficherEleves();
        afficherNotes();
        new NoteDAO().ajouterNote(new Note(MatiereEnum.valueOf("physique".toUpperCase()), "12", "11"));
//        afficherNotes();

    }


    public static void afficherEleves() {
        List<Eleve> eleves = EleveDAO.getEleves();
        eleves.stream().forEach(eleve -> System.out.println(eleve.toString()));
    }

    public static void afficherNotes() {
        List<Note> notes = NoteDAO.getNotes();
        notes.stream().forEach(note -> System.out.println(note.toString()));
    }
}
