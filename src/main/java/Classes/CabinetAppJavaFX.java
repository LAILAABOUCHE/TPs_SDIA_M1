package Classes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

public class CabinetAppJavaFX extends Application {
    private ICabinetMetier metier = new CabinetMetierImpl();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cabinet Médical");

        // Layout principal
        BorderPane root = new BorderPane();

        // Menu
        MenuBar menuBar = createMenu();
        root.setTop(menuBar);

        // Zone centrale
        VBox contentArea = new VBox(10);
        contentArea.setPadding(new javafx.geometry.Insets(10));

        // Buttons et Formulaires
        Button btnAjouterPatient = new Button("Ajouter Patient");
        btnAjouterPatient.setOnAction(e -> ajouterPatient(contentArea));

        Button btnListerPatients = new Button("Lister Patients");
        btnListerPatients.setOnAction(e -> listerPatients(contentArea));

        contentArea.getChildren().addAll(btnAjouterPatient, btnListerPatients);

        // Ajouter les boutons et le formulaire dans la zone centrale
        root.setCenter(contentArea);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        Menu menuFile = new Menu("File");
        MenuItem quitItem = new MenuItem("Quitter");
        quitItem.setOnAction(e -> System.exit(0));
        menuFile.getItems().add(quitItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menuFile);
        return menuBar;
    }

    private void ajouterPatient(VBox contentArea) {
        // Créer un formulaire pour ajouter un patient
        GridPane form = new GridPane();
        form.setVgap(10);
        form.setHgap(10);
        form.setPadding(new javafx.geometry.Insets(10));

        TextField nomField = new TextField();
        nomField.setPromptText("Nom");
        TextField prenomField = new TextField();
        prenomField.setPromptText("Prénom");
        TextField cinField = new TextField();
        cinField.setPromptText("CIN");
        TextField telField = new TextField();
        telField.setPromptText("Téléphone");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        TextField dateField = new TextField();
        dateField.setPromptText("Date Naissance (yyyy-mm-dd)");

        Button submitBtn = new Button("Ajouter Patient");
        submitBtn.setOnAction(e -> {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String cin = cinField.getText();
            String tel = telField.getText();
            String email = emailField.getText();
            String dateNaissance = dateField.getText();

            // Convertir la date en LocalDate
            java.time.LocalDate date = java.time.LocalDate.parse(dateNaissance);

            Patient patient = new Patient("0", nom, prenom, cin, tel, email);
            metier.ajouterPatient(patient);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Patient ajouté");
            alert.setHeaderText(null);
            alert.setContentText("Le patient a été ajouté avec succès.");
            alert.showAndWait();
        });

        form.add(new Label("Nom: "), 0, 0);
        form.add(nomField, 1, 0);
        form.add(new Label("Prénom: "), 0, 1);
        form.add(prenomField, 1, 1);
        form.add(new Label("CIN: "), 0, 2);
        form.add(cinField, 1, 2);
        form.add(new Label("Téléphone: "), 0, 3);
        form.add(telField, 1, 3);
        form.add(new Label("Email: "), 0, 4);
        form.add(emailField, 1, 4);
        form.add(new Label("Date Naissance: "), 0, 5);
        form.add(dateField, 1, 5);
        form.add(submitBtn, 1, 6);

        contentArea.getChildren().clear();
        contentArea.getChildren().add(form);
    }

    private void listerPatients(VBox contentArea) {
        List<Patient> patients = metier.listerPatients();
        TableView<Patient> table = new TableView<>();
        TableColumn<Patient, String> nomCol = new TableColumn<>("Nom");
        nomCol.setCellValueFactory(cellData -> cellData.getValue().nomProperty());

        TableColumn<Patient, String> prenomCol = new TableColumn<>("Prénom");
        prenomCol.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());

        table.getColumns().add(nomCol);
        table.getColumns().add(prenomCol);

        table.getItems().addAll(patients);

        contentArea.getChildren().clear();
        contentArea.getChildren().add(table);
    }
}
