package com.example.tp5;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class ProfesseursDeDepartementController implements Initializable {
    private int idDepart;
    private IMetierImp helper = new IMetierImp();
    private ObservableList professeursList ;

    @FXML
    private TableColumn<Professeur, String> adresseProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, String> cinProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, LocalDateTime> dateRecrutementProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, String> emailProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, Integer> idDepartProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, Integer> idProfProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, String> nomProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, String> prenomProfesseurTableColumn;

    @FXML
    private TableView<?> professeurTableView;

    @FXML
    private TableColumn<Professeur, String> telephoneProfesseurTableColumn;



    public void setIdDepartement(int idDepart) {
        this.idDepart = idDepart;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idProfProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,Integer>("id_prof"));
        nomProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("nom"));
        prenomProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("prenom"));
        cinProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("cin"));
        adresseProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("adresse"));
        emailProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("email"));
        telephoneProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("telephone"));
        dateRecrutementProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur, LocalDateTime>("date_recrutement"));
        idDepartProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,Integer>("departement"));
        idDepartProfesseurTableColumn.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getDepartement().getId_depart()).asObject()
        );

    }
    public void loadTable() {

        try {
            professeursList = FXCollections.observableArrayList(helper.afficherProfesseursDeDepartement(idDepart));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        professeurTableView.setItems(professeursList);
        System.out.println(idDepart);
        System.out.println(professeursList);
    }
}
