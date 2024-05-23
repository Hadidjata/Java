package modele;
import modele.MatiereEnum;

public class Note {
    private String id;
    private MatiereEnum matiere;
    private String valeur;
    private String eleveid;

    public Note(MatiereEnum matiere, String valeur, String eleveid,String id) {
        this.id = id;
        this.matiere = matiere;
        this.valeur = valeur;
        this.eleveid = eleveid;
    }

    public Note(MatiereEnum matiere, String valeur, String eleveid) {
        this.matiere = matiere;
        this.valeur = valeur;
        this.eleveid = eleveid;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatiere() {
        return matiere.toString();
    }

    public void setMatiere(MatiereEnum matiere) {
        this.matiere = matiere;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getEleveid() {
        return eleveid;
    }

    public void setEleveid(String eleveid) {
        this.eleveid = eleveid;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", matiere=" + matiere +
                ", valeur='" + valeur + '\'' +
                ", eleveid='" + eleveid + '\'' +
                '}';
    }
}
