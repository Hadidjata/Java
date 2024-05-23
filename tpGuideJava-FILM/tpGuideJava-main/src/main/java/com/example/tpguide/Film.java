package com.example.tpguide;

public class Film {
    private int rang;
    private String id;
    private String nom;
    private int annee;
    private String acteur;



    public Film() {
    }

    public String getActeur() {
        return acteur;
    }

    public void setActeur(String acteur) {
        this.acteur = acteur;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
