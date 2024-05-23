package modele;

public class Eleve {
    private String nom;
    private String prenom;
    private String id;

    public Eleve( String prenom, String nom) {
        this.nom = nom;
        this.prenom = prenom;

    }
    public Eleve( String prenom, String nom, String id) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Eleve{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
