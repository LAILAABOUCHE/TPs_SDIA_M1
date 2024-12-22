package com.example.tp5;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    // the important objects
    private IMetierImp helper = new IMetierImp();
    private ObservableList departementsList, professeursList ;

    // fxml nodes
    @FXML
    private TableColumn<Professeur, String> adresseProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, String> telephoneProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, String> cinProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, LocalDateTime> dateRecrutementProfesseurTableColumn;

    @FXML
    private TableView<Departement> departementTableView;

    @FXML
    private TableColumn<Professeur, String> emailProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, Integer> idDepartProfesseurTableColumn;

    @FXML
    private TableColumn<Departement, Integer> idDepartDpartementTableColumn;

    @FXML
    private TableColumn<Professeur, Integer> idProfProfesseurTableColumn;

    @FXML
    private TableColumn<Departement, String> nomDepartementTableColumn;

    @FXML
    private TableColumn<Professeur, String> nomProfesseurTableColumn;

    @FXML
    private TableColumn<Professeur, String> prenomProfesseurTableColumn;

    @FXML
    private TableView<Professeur> professeurTableView;

    @FXML
    private TextField adresseProfesseurTextField;

    @FXML
    private Button affectuerAuDepartementButton;

    @FXML
    private Button afficherProfesseurDeDepartementButton;

    @FXML
    private Button ajouterDepartementButton;

    @FXML
    private Button ajouterProfesseurButton;

    @FXML
    private TextField dateRecrutementProfesseurTextField;

    @FXML
    private TextField cinProfesseurTextField;

    @FXML
    private TextField emailProfesseurTextField;

    @FXML
    private TextField idDepartDepartementTextField;

    @FXML
    private TextField idDepartProfesseurTextField;

    @FXML
    private TextField idProfPrefesseurTextField;

    @FXML
    private Button modifierDepartementButton;

    @FXML
    private Button modifierProfesseurButton;

    @FXML
    private TextField nomDepartementTextField;

    @FXML
    private TextField nomProfesseurTextField;

    @FXML
    private TextField prenomProfesseurTextField;

    @FXML
    private TextField rechercherProfesseurTextField;

    @FXML
    private Button supprimerDepartementButton;

    @FXML
    private Button supprimerProfesseurButton;

    @FXML
    private TextField telephoneProfesseurTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeDepartementsTable();
        initializeProfesseursTable();

        rechercherProfesseurTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            changeProfesseurList(newValue);
        });

        departementTableView.setOnMouseClicked(event -> {
            Departement selectedDepartement = departementTableView.getSelectionModel().getSelectedItem();
            if (selectedDepartement != null) {
                idDepartDepartementTextField.setText(selectedDepartement.getId_depart()+"");
                nomDepartementTextField.setText(selectedDepartement.getNom());
            }
        });

        professeurTableView.setOnMouseClicked(event -> {
            Professeur selectedProfesseur = professeurTableView.getSelectionModel().getSelectedItem();
            if (selectedProfesseur != null) {
                idProfPrefesseurTextField.setText(selectedProfesseur.getId_prof()+"");
                nomProfesseurTextField.setText(selectedProfesseur.getNom());
                prenomProfesseurTextField.setText(selectedProfesseur.getPrenom());
                cinProfesseurTextField.setText(selectedProfesseur.getCin());
                adresseProfesseurTextField.setText(selectedProfesseur.getAdresse());
                emailProfesseurTextField.setText(selectedProfesseur.getEmail());
                telephoneProfesseurTextField.setText(selectedProfesseur.getTelephone());
                dateRecrutementProfesseurTextField.setText(selectedProfesseur.getDate_recrutement().toString());
                idDepartProfesseurTextField.setText(selectedProfesseur.getDepartement().getId_depart()+"");
            }
        });

    }

    private void initializeDepartementsTable() {
        idDepartDpartementTableColumn.setCellValueFactory(new PropertyValueFactory<Departement,Integer>("id_depart"));
        nomDepartementTableColumn.setCellValueFactory(new PropertyValueFactory<Departement,String>("nom"));
        try {
            departementsList = FXCollections.observableArrayList(helper.retournerDepartements());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        departementTableView.setItems(departementsList);
    }

    private void initializeProfesseursTable() {
        idProfProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,Integer>("id_prof"));
        nomProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("nom"));
        prenomProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("prenom"));
        cinProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("cin"));
        adresseProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("adresse"));
        emailProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,String>("email"));
        telephoneProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur, String>("telephone"));
        dateRecrutementProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,LocalDateTime>("date_recrutement"));
        idDepartProfesseurTableColumn.setCellValueFactory(new PropertyValueFactory<Professeur,Integer>("departement"));
        idDepartProfesseurTableColumn.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getDepartement().getId_depart()).asObject()
        );

        try {
            professeursList = FXCollections.observableArrayList(helper.retournerProfesseurs());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        professeurTableView.setItems(professeursList);
    }

    private void changeProfesseurList(String newValue) {
        try {
            professeursList = FXCollections.observableArrayList(helper.trouverProfesseurParCin(newValue));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        professeurTableView.setItems(professeursList);
    }

    private void clearProfesseurTextFields() {
        idProfPrefesseurTextField.clear();
        nomProfesseurTextField.clear();
        prenomProfesseurTextField.clear();
        cinProfesseurTextField.clear();
        adresseProfesseurTextField.clear();
        emailProfesseurTextField.clear();
        telephoneProfesseurTextField.clear();
        dateRecrutementProfesseurTextField.clear();
        idDepartProfesseurTextField.clear();
    }

    private void clearDepartementTextFields() {
        idDepartDepartementTextField.clear();
        nomDepartementTextField.clear();
    }

    private void refreshProfesseurTable() {
        try {
            professeursList = FXCollections.observableArrayList(helper.retournerProfesseurs());
            rechercherProfesseurTextField.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        professeurTableView.setItems(professeursList);
    }

    private void refreshDepartementTable() {
        try {
            departementsList = FXCollections.observableArrayList(helper.retournerDepartements());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        departementTableView.setItems(departementsList);
    }

    // les actions de departement

    @FXML
    void afficherProfesseurDeDepartementAction(ActionEvent event) {
        String tempIdDepart = idDepartDepartementTextField.getText();
        if(tempIdDepart.isEmpty()) {
            MyAlert.showAlert("Error","remplir le champ de l'id", Alert.AlertType.INFORMATION);
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("professeurs-de-departement.fxml"));
            Parent root = loader.load();
            ProfesseursDeDepartementController controller = loader.getController();
            System.out.println(Integer.parseInt(tempIdDepart));
            controller.setIdDepartement(Integer.parseInt(tempIdDepart));
            controller.loadTable();
            Scene newScene = new Scene(root);
            Stage newWindow = new Stage();
            newWindow.setScene(newScene);
            newWindow.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ajouterDepartementAction(ActionEvent event) {
        if(nomDepartementTextField.getText().isEmpty()) {
            MyAlert.showAlert("alert", "inserer le nom de departement", Alert.AlertType.INFORMATION);
            return;
        }
        try {
            helper.ajouterDepartement(new Departement(nomDepartementTextField.getText(),null));
            refreshDepartementTable();
            clearDepartementTextFields();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void modifierDepartementAction(ActionEvent event) {
        if(idDepartDepartementTextField.getText().isEmpty() && nomDepartementTextField.getText().isEmpty()) {
            MyAlert.showAlert("error","remplir le champ de l'id et le nom", Alert.AlertType.INFORMATION);
        } else {
            int idDepart = Integer.parseInt(idDepartDepartementTextField.getText());
            try {
                helper.modifierDepartement(new Departement(idDepart, nomDepartementTextField.getText(),null));
                refreshDepartementTable();
                clearDepartementTextFields();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void supprimerDepartementAction(ActionEvent event) {
        if(idDepartDepartementTextField.getText().isEmpty()) {
            MyAlert.showAlert("error","remplir le champ de l'id", Alert.AlertType.INFORMATION);
        } else {
            int idDepart = Integer.parseInt(idDepartDepartementTextField.getText());
            try {
                helper.supprimerDepartement(idDepart);
                refreshDepartementTable();
                clearDepartementTextFields();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void ajouterProfesseurAction(ActionEvent event) {
        String nom = nomProfesseurTextField.getText();
        String prenom = prenomProfesseurTextField.getText();
        String cin = cinProfesseurTextField.getText();
        String adresse = adresseProfesseurTextField.getText();
        String email = emailProfesseurTextField.getText();
        String telephone = telephoneProfesseurTextField.getText();
        String dateRecrutement = dateRecrutementProfesseurTextField.getText();
        String idDepartement = idDepartProfesseurTextField.getText();
        if(nom.isEmpty() && prenom.isEmpty() && cin.isEmpty() && adresse.isEmpty() && email.isEmpty() && telephone.isEmpty() && dateRecrutement.isEmpty() && idDepartement.isEmpty()) {
            MyAlert.showAlert("error", "L'insertion de tous les champ est necessaire", Alert.AlertType.INFORMATION);
        } else {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            try {
                Date date = format.parse(dateRecrutement);
                int newIdDepart = Integer.parseInt(idDepartement);
                Professeur p = new Professeur(nom, prenom, cin, adresse, telephone, email, date, new Departement(newIdDepart));
                helper.ajouterProfesseur(p);
                clearProfesseurTextFields();
                refreshProfesseurTable();
            } catch (ParseException | SQLException e){
                e.printStackTrace();
            }
        }
    }


    @FXML
    void modifierProfesseurAction(ActionEvent event) {
        String idProf = idProfPrefesseurTextField.getText();
        String nom = nomProfesseurTextField.getText();
        String prenom = prenomProfesseurTextField.getText();
        String cin = cinProfesseurTextField.getText();
        String adresse = adresseProfesseurTextField.getText();
        String email = emailProfesseurTextField.getText();
        String telephone = telephoneProfesseurTextField.getText();
        String dateRecrutement = dateRecrutementProfesseurTextField.getText();
        String idDepartement = idDepartProfesseurTextField.getText();
        if(idProf.isEmpty() && nom.isEmpty() && prenom.isEmpty() && cin.isEmpty() && adresse.isEmpty() && email.isEmpty() && telephone.isEmpty() && dateRecrutement.isEmpty() && idDepartement.isEmpty()) {
            MyAlert.showAlert("error", "L'insertion de tous les champ est necessaire", Alert.AlertType.INFORMATION);
        } else {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            try {
                Date date = format.parse(dateRecrutement);
                int newIdDepart = Integer.parseInt(idDepartement);
                int newIdProf = Integer.parseInt(idProf);
                Professeur p = new Professeur(newIdProf,nom, prenom, cin, adresse, telephone, email, date, new Departement(newIdDepart));
                helper.modifierProfesseur(p);
                clearProfesseurTextFields();
                refreshProfesseurTable();
            } catch (ParseException | SQLException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void supprimerProfesseurAction(ActionEvent event) {
        if(idProfPrefesseurTextField.getText().isEmpty()) {
            MyAlert.showAlert("error","remplir le champ de l'id", Alert.AlertType.INFORMATION);
        } else {
            int idProf = Integer.parseInt(idProfPrefesseurTextField.getText());
            try {
                helper.supprimerProfesseur(idProf);
                refreshProfesseurTable();
                clearProfesseurTextFields();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void affecterAuDepartementProfesseurAction(ActionEvent event) {
        String idProf = idProfPrefesseurTextField.getText();

        String idDepartement = idDepartProfesseurTextField.getText();
        if(idProf.trim().isEmpty() || idDepartement.trim().isEmpty()) {
            MyAlert.showAlert("error", "L'insertion de tous les champ id professeur et id departement", Alert.AlertType.INFORMATION);
        } else {
            System.out.println(idProf);
            System.out.println(idDepartement);
            try {
                int newIdDepart = Integer.parseInt(idDepartement);
                int newIdProf = Integer.parseInt(idProf);
                helper.affecterProfesseurADepartement(newIdProf, newIdDepart);
                clearProfesseurTextFields();
                refreshProfesseurTable();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
