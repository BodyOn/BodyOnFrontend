package com.example.bodyonfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dao.OwnerAuth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    private OwnerAuth ownerAuth = OwnerAuth.getInstance();
    @FXML
    public TextField usernameTextField;
    @FXML
    public PasswordField passwordTextField;


    @FXML
    protected void onLoginButtonClick(ActionEvent actionEvent) throws IOException {
        if(!usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank()){
            validateLogin(actionEvent);
        } else {
            System.out.println("Por favor digite usuário e senha");
        }
    }

    private void validateLogin(ActionEvent event) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        String verifyLogin = "SELECT count(1) FROM clientes WHERE nome = '"+usernameTextField.getText()+
                "'AND senha = '" + passwordTextField.getText() +"'";

        try {
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    ownerAuth.setLogged(true);
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }else{
                    usernameTextField.setText("Falha na autenticação");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}