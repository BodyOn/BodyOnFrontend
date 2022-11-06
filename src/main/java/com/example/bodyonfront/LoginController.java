package com.example.bodyonfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    @FXML
    public TextField usernameTextField;
    @FXML
    public PasswordField passwordTextField;

    @FXML
    protected void onLoginButtonClick(ActionEvent actionEvent) {
        if(!usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank()){
//            LoginMessageLabel.setText("Houve uma tentativa de Logar");
            validateLogin();
        } else {
            System.out.println("Por favor digite usuário e senha");
        }
    }

    private void validateLogin() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        String verifyLogin = "SELECT count(1) FROM clientes WHERE nome = '"+usernameTextField.getText()+
                "'AND senha = '" + passwordTextField.getText() +"'";

        try {
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    usernameTextField.setText("Bem Vindo!");
                }else{
                    usernameTextField.setText("Falha na autenticação");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}