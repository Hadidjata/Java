package com.example.tpguide;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabRang.setCellValueFactory(new PropertyValueFactory<Film, Integer>("rang"));
        tabId.setCellValueFactory(new PropertyValueFactory<Film, String>("id"));
        tabNom.setCellValueFactory(new PropertyValueFactory<Film, String>("nom"));
        tabAnnee.setCellValueFactory(new PropertyValueFactory<Film, Integer>("annee"));
        tabActeur.setCellValueFactory(new PropertyValueFactory<Film, String>("acteur"));

        //File file = new File("movies.txt");


    }
    public List<List<String>> getCsv() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("movies.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return records;
    }



    public void ajouterFilmDansTableau(int rang, String id, String nom, int annee, String acteur) {
        Film film = new Film();
        film.setId(id);
        film.setRang(rang);
        film.setNom(nom);
        film.setAnnee(annee);
        film.setActeur(acteur);

        ObservableList<Film> films = tableau.getItems();
        films.add(film);
        tableau.setItems(films);
    }

    @FXML
    private void ajouterFilm() {
        if (edtRang.getText().isEmpty() || edtId.getText().isEmpty() || edtNom.getText().isEmpty() || edtAnnee.getText().isEmpty() || Integer.parseInt(edtRang.getText()) < 0 || Integer.parseInt(edtAnnee.getText()) < 0) {
            return;
        }

        int rang = Integer.parseInt(edtRang.getText());
        String id = edtId.getText();
        String nom = edtNom.getText();
        int annee = Integer.parseInt(edtAnnee.getText());
        String acteur = edtActeur.getText();
        ;
        ajouterFilmDansTableau(rang, id, nom, annee, acteur);
        edtRang.setText("");
        edtId.setText("");
        edtNom.setText("");
        edtAnnee.setText("");
        edtActeur.setText("");

    }

    @FXML
    private void viderTableau() {
        tableau.getItems().clear();
    }

    @FXML
    private void supprimerFilm() {
        ObservableList<Film> films = tableau.getItems();
        films.remove(tableau.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void importer(){
        List<List<String>> csv = getCsv();
        for (int i = 1; i < csv.size(); i++) {
            Film films = new Film();
            //ajouterFilmDansTableau(Integer.parseInt(csv.get(i).get(0)), csv.get(i).get(1)+"", csv.get(i).get(2)+"", Integer.parseInt(csv.get(i).get(3)), csv.get(i).get(10)+"");
            films.setRang(Integer.parseInt(csv.get(i).get(0)));
            films.setId(csv.get(i).get(1)+"");
            films.setNom(csv.get(i).get(2)+"");
            films.setAnnee(
                    Integer.parseInt(csv.get(i).get(3))
            );
            films.setActeur(csv.get(i).get(10));
            tableau.getItems().add(films);

        }
    }
    @FXML
    private TableView tableau;
    @FXML
    private TableColumn tabRang;
    @FXML
    private TableColumn tabId;
    @FXML
    private TableColumn tabNom;
    @FXML
    private TableColumn tabAnnee;
    @FXML
    private TableColumn tabActeur;
    @FXML
    private TextField edtRang;
    @FXML
    private TextField edtId;
    @FXML
    private TextField edtNom;
    @FXML
    private TextField edtAnnee;
    @FXML
    private TextField edtActeur;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnVider;
    @FXML
    private Button btnSup;


}

