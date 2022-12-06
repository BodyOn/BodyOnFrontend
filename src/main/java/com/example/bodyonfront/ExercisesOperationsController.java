package com.example.bodyonfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import model.dao.ClienteDAO;
import model.dao.ExercicioDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Cliente;
import model.domain.Exercicio;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ExercisesOperationsController implements Initializable {
    @FXML
    public TextField exercisesName;
    @FXML
    public TextField exercisesSeries;
    @FXML
    public TextField exercisesRepetitions;
    @FXML
    public ComboBox<String> excercisesSchedule;
    @FXML
    public Button mainOperationButton;
    @FXML
    public Button cancelButton;
    @FXML
    public Button deleteExercises;
    public int exercisesId;
    public int exercisesClientId;


    String[] Schedule = new String[]{"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira",
            "Sexta-feira", "Sabado", "Domingo"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        excercisesSchedule.getItems().addAll(Schedule);
        deleteExercises.setOnAction(this::deleteClient);
    }

    public void chooseOperation(Exercicio exercises) {
        if (exercises == null) {
            mainOperationButton.setOnAction(this::registerClient);
            deleteExercises.setVisible(false);
        }else{
            mainOperationButton.setOnAction(this::editClient);
            deleteExercises.setVisible(true);

            // pega cliente no db
//            Date dataCliente = exercises.getDataPagamento();
//            LocalDate date = dataCliente.toLocalDate();

            // setando os dados
            exercisesId = exercises.getId();
            exercisesName.setText(exercises.getNome());
            exercisesSeries.setText(String.valueOf(exercises.getQtdSeries()));
            exercisesRepetitions.setText(String.valueOf(exercises.getQtdRepeticoes()));
            exercisesClientId = exercises.getIdCliente();
        }
    }

    @FXML
    protected void registerClient(ActionEvent event) {
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        ExercicioDAO exercicio = new ExercicioDAO();

        //TODO
        //REMOVER ISSO QUANDO TIVER TERMINADO
        System.out.println("CLIENT ID " + exercisesId);

//        Cliente insertExercises = new Cliente(
//                exercisesId,
//                exercisesName.getText(),
//                exercisesSeries.getText(),
//                exercisesRepetitions.getText(),
//                exercisesClientId
//        );
//
//        exercicio.setConnection(conn);
//           boolean resposta = exercicio.insertById(insertExercises);
//
//        if(resposta){
//            ((Node)(event.getSource())).getScene().getWindow().hide();
//        }
    }

    public void editClient(ActionEvent event) {
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        ExercicioDAO exercicio = new ExercicioDAO();

        //TODO
        //REMOVER ISSO QUANDO TIVER TERMINADO
        System.out.println("CLIENT ID " + exercisesId);

//        Cliente updateExcersises = new Cliente(
//                exercisesId,
//                exercisesName.getText(),
//                exercisesSeries.getText(),
//                exercisesRepetitions.getText(),
//                exercisesClientId
//        );
//
//        exercicio.setConnection(conn);
//        boolean resposta = exercicio.update(updateExcersises);
//
//        if(resposta){
//            ((Node)(event.getSource())).getScene().getWindow().hide();
//        }
    }

    public void deleteClient(ActionEvent event) {
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        ExercicioDAO exercicio = new ExercicioDAO();


        //TODO
        //REMOVER ISSO QUANDO TIVER TERMINADO
        System.out.println("CLIENT ID " + exercisesId);

//        Cliente deleteExercises = new Cliente(
//                exercisesId,
//                exercisesName.getText(),
//                exercisesSeries.getText(),
//                exercisesRepetitions.getText(),
//                exercisesClientId
//        );
//
//        exercicio.setConnection(conn);
//        boolean resposta = exercicio.delete(deleteExercises);

//        if(resposta){
//            ((Node)(event.getSource())).getScene().getWindow().hide();
//        }
    }

    public void onCancelButton(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
