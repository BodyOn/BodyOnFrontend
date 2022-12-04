package com.example.bodyonfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import model.dao.FuncionarioDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Funcionario;

import java.net.URL;
import java.sql.Connection;
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
    public int EmployeeId;

    String[] Schedule = new String[]{"8:00 - 12:00", "14:00 - 18:00", "18:00: 22:00"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EmployeeSchedule.getItems().addAll(Schedule);
        deleteEmployee.setOnAction(this::deleteEmployee);

    }

    public void chooseOperation(Funcionario funcionario) {
        if (funcionario == null) {
            mainOperationButton.setOnAction(this::registerEmployee);
            deleteEmployee.setVisible(false);
        }else{
            mainOperationButton.setOnAction(this::editEmployee);
            deleteEmployee.setVisible(true);

            // setando os dados
            EmployeeId = funcionario.getId();
            EmployeeName.setText(funcionario.getNome());
            EmployeeAddress.setText(funcionario.getEndereco());
            EmployeeEmail.setText(funcionario.getEmail());
            EmployeeCpf.setText(funcionario.getCpf());
            EmployeeFone.setText(funcionario.getTelefone());
            EmployeePosition.setText(funcionario.getCargo());
        }
    }

    @FXML
    protected void registerEmployee(ActionEvent event) {
        // TODO
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        FuncionarioDAO funcionario = new FuncionarioDAO();
        funcionario.setConnection(conn);

        Funcionario insertEmployee = new Funcionario(
                EmployeeName.getText(),
                EmployeeCpf.getText(),
                EmployeeEmail.getText(),
                EmployeeFone.getText(),
                EmployeeAddress.getText(),
                EmployeePosition.getText(),
                EmployeeSchedule.getValue()
        );
        boolean resposta = funcionario.insert(insertEmployee);

        if(resposta){
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }

    }

    public void editEmployee(ActionEvent event) {
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        FuncionarioDAO funcionario = new FuncionarioDAO();
        funcionario.setConnection(conn);

        Funcionario updateEmployee = new Funcionario(
                EmployeeId,
                EmployeeName.getText(),
                EmployeeCpf.getText(),
                EmployeeEmail.getText(),
                EmployeeFone.getText(),
                EmployeeAddress.getText(),
                EmployeePosition.getText(),
                EmployeeSchedule.getValue()
        );
        boolean resposta = funcionario.update(updateEmployee);

        if(resposta){
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }

    public void deleteEmployee(ActionEvent event) {
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        FuncionarioDAO funcionario = new FuncionarioDAO();
        funcionario.setConnection(conn);

        Funcionario deleteEmployee = new Funcionario(
                EmployeeId,
                EmployeeName.getText(),
                EmployeeCpf.getText(),
                EmployeeEmail.getText(),
                EmployeeFone.getText(),
                EmployeeAddress.getText(),
                EmployeePosition.getText(),
                EmployeeSchedule.getValue()
        );
        boolean resposta = funcionario.delete(deleteEmployee);

        if(resposta){
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }

    public void onCancelButton(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
