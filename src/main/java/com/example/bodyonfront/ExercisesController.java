package com.example.bodyonfront;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dao.ExercicioDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Exercicio;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ExercisesController implements Initializable {

    @FXML
    public TableView<Exercicio> exerciseTable;
    @FXML
    public TableColumn<Exercicio, String> tableColumnExercisesNome;
    @FXML
    public TableColumn<Exercicio, String> tableColumnExercisesSeries;
    @FXML
    public TableColumn<Exercicio, String> tableColumnExercisesRepetitions;

    @FXML
    public Button registerExrcisesButton;
    private final List<Exercicio> exercisesList = new ArrayList<>();

    private boolean pendencyButtonClicked = false;

    String[] Schedule = new String[]{"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira",
            "Sexta-feira", "Sabado", "Domingo"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // iniciando colunas
        tableColumnExercisesNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnExercisesSeries.setCellValueFactory(new PropertyValueFactory<>("series"));
        tableColumnExercisesRepetitions.setCellValueFactory(new PropertyValueFactory<>("repeticoes"));
        loadClients();

        ObservableList<Exercicio> observableList = FXCollections.observableArrayList(exercisesList);
        exerciseTable.setItems(observableList);

        // table listener
        exerciseTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> onTableItemClick(newValue));

            exerciseTable.setRowFactory(tv -> new TableRow<Exercicio>() {

            protected void updateItem(Exercicio item, boolean empty) {
               super.updateItem(item, empty);
                if (item != null) {
                    setStyle("-fx-background-color: #ffd7d1;");
                } else {
                    setStyle("");
               }
           }
       });
    }

    public void mockData() {
        Exercicio excercico1 = new Exercicio(0, "rosca direta", 4, 15, 0);
        Exercicio excercico2 = new Exercicio(0, "agachamento", 4, 15, 0);
        Exercicio excercico3 = new Exercicio(0, "alguma coisa", 4, 15, 0);

        exercisesList.add(excercico1);
        exercisesList.add(excercico2);
        exercisesList.add(excercico3);

        ObservableList<Exercicio> observableList = FXCollections.observableArrayList(exercisesList);
        exerciseTable.setItems(observableList);
    }

    private void loadClients(){
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        ExercicioDAO exercicio = new ExercicioDAO();
        exercicio.setConnection(conn);
        List<Exercicio> resposta = exercicio.list();

        exercisesList.addAll(resposta);

    }

    public void onRegisterClientButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("exercisesOperations.fxml"));
        Parent root = fxmlLoader.load();

        ExercisesOperationsController exercisesOperationsController= fxmlLoader.getController();
        exercisesOperationsController.chooseOperation(null);

        Stage stage = new Stage();
        stage.setTitle("BodyOn");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void onExercisesClientButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("exercises.fxml"));
        Parent root = fxmlLoader.load();

        ExercisesOperationsController exercisesOperationsController = fxmlLoader.getController();
        exercisesOperationsController.chooseOperation(null);

        Stage stage = new Stage();
        stage.setTitle("BodyOn");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void onTableItemClick(Exercicio exercises)  {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("exercisesOperations.fxml"));
            Parent root = fxmlLoader.load();

            ExercisesOperationsController exercisesOperationsController = fxmlLoader.getController();
            exercisesOperationsController.chooseOperation(exercises);

            Stage stage = new Stage();
            stage.setTitle("BodyOn");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
            stage.requestFocus();
            stage.toFront();
            stage.setAlwaysOnTop(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onHomeButtonClick(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("BodyOn");
            stage.setResizable(false);
            stage.setMaximized(true);
            stage.setScene(new Scene(root));
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
