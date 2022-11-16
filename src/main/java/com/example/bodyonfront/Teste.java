package com.example.bodyonfront;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Teste extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("cliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 610);
        stage.setTitle("BodyOn");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
