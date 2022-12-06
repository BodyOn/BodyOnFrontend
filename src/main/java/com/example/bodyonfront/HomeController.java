package com.example.bodyonfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.dao.OwnerAuth;

import java.io.IOException;

public class HomeController {
    private OwnerAuth ownerAuth = OwnerAuth.getInstance();
    @FXML
    public Button clientButton;

    @FXML
    private void onClientButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900 , 600);
        Stage stage = new Stage();
        stage.setTitle("BodyOn");
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void onEmployeeButtonClick(ActionEvent event) throws IOException {
        // verificar se está logado
        if (ownerAuth.isLogged()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("funcionarios.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900 , 600);
            Stage stage = new Stage();
            stage.setTitle("BodyOn");
            stage.setResizable(false);
            stage.setMaximized(true);
            stage.setScene(scene);
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 520 , 400);
            Stage stage = new Stage();
            stage.setTitle("BodyOn");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }
}
