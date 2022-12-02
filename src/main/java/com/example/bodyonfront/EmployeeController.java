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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.domain.Funcionario;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {
    @FXML
    public TableView<Funcionario> employeeTable;
    @FXML
    public TableColumn<Funcionario, String> tableColumnEmployeeId;
    @FXML
    public TableColumn<Funcionario, String> tableColumnEmployeeName;
    @FXML
    public TableColumn<Funcionario, String> tableColumnEmployeeCpf;
    @FXML
    public TableColumn<Funcionario, String> tableColumnEmployeeEmail;
    @FXML
    public TableColumn<Funcionario, String> tableColumnEmployeeFone;
    @FXML
    public TableColumn<Funcionario, String> tableColumnEmployeeAddress;
    @FXML
    public TableColumn<Funcionario, String> tableColumnEmployeePosition;
    @FXML
    public TableColumn<Funcionario, String> tableColumnEmployeeSchedule;
    @FXML
    public Button registerEmployeeButton;
    private final List<Funcionario> employeeList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mockData();

        // table listener
        employeeTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> onTableItemClick(newValue));
    }

    public void mockData() {
        tableColumnEmployeeId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnEmployeeName.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnEmployeeCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnEmployeeEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnEmployeeFone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tableColumnEmployeeAddress.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tableColumnEmployeePosition.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        tableColumnEmployeeSchedule.setCellValueFactory(new PropertyValueFactory<>("horarioTrabalho"));

        Funcionario funcionario = new Funcionario(0, "isa", "9283920192", "isa@com", "(86)994273472",
                "rua dos bobos", "patrão", "8h-12h" );
        Funcionario funcionario1 = new Funcionario(1, "junin", "9283920192", "junin@com", "(86)994273472",
                "rua dos bobos", "gerente", "8h-12h" );
        Funcionario funcionario2 = new Funcionario(2, "josu", "9283920192", "josu@com", "(86)994273472",
                "rua dos bobos", "patrão", "8h-12h" );

        employeeList.add(funcionario);
        employeeList.add(funcionario1);
        employeeList.add(funcionario2);

        ObservableList<Funcionario> observableList = FXCollections.observableArrayList(employeeList);
        employeeTable.setItems(observableList);
    }

    @FXML
    public void onRegisterEmployeeButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employeeOperations.fxml"));
        Parent root = fxmlLoader.load();

        EmployeeOperationsController employeeOperationsController = fxmlLoader.getController();
        employeeOperationsController.chooseOperation(null);

        Stage stage = new Stage();
        stage.setTitle("BodyOn");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
        stage.requestFocus();
        stage.toFront();
        stage.setAlwaysOnTop(true);
    }

    @FXML
    public void onTableItemClick(Funcionario funcionario) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employeeOperations.fxml"));
            Parent root = fxmlLoader.load();

            EmployeeOperationsController employeeOperationsController = fxmlLoader.getController();
            employeeOperationsController.chooseOperation(funcionario);

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
