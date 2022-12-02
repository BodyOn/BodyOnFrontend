package com.example.bodyonfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("funcionarios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900 , 600);
        Stage stage = new Stage();
        stage.setTitle("BodyOn");
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
