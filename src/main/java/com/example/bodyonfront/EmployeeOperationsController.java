package com.example.bodyonfront;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.domain.Funcionario;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeOperationsController implements Initializable {
    @FXML
    public TextField EmployeeName;
    @FXML
    public TextField EmployeeAddress;
    @FXML
    public TextField EmployeeCpf;
    @FXML
    public TextField EmployeeFone;
    @FXML
    public TextField EmployeeEmail;
    @FXML
    public ComboBox<String> EmployeeSchedule;
    @FXML
    public Button mainOperationButton;
    @FXML
    public Button cancelButton;
    @FXML
    public TextField EmployeePosition;
    @FXML
    public Button deleteEmployee;

    String[] Schedule = new String[]{"8:00 - 12:00", "14:00 - 18:00", "18:00: 22:00"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmployeeSchedule.getItems().addAll(Schedule);
        deleteEmployee.setOnAction(event -> deleteEmployee());
    }

    public void chooseOperation(Funcionario funcionario) {
        if (funcionario == null) {
            mainOperationButton.setOnAction(event -> registerEmployee());
            deleteEmployee.setVisible(false);
        }else{
            mainOperationButton.setOnAction(event -> editEmployee());
            deleteEmployee.setVisible(true);

            // pega cliente no bd

            // setando os dados
            EmployeeName.setText(funcionario.getNome());
            EmployeeAddress.setText(funcionario.getEndereco());
            EmployeeEmail.setText(funcionario.getEmail());
            EmployeeCpf.setText(funcionario.getCpf());
            EmployeeFone.setText(funcionario.getTelefone());
            EmployeePosition.setText(funcionario.getCargo());
        }
    }

    @FXML
    protected void registerEmployee() {
        // TODO
        System.out.println("registrou");
    }

    public void editEmployee() {
        // TODO
        System.out.println("editou");
    }

    public void deleteEmployee() {
        // TODO
        System.out.println("deletou");
    }
}
