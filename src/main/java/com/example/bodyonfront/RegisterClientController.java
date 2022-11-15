package com.example.bodyonfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterClientController implements Initializable {
    public TextField clientName;
    public TextField clientAddress;
    public TextField clientEmail;
    public TextField clientCpf;
    public TextField clientFone;
    public ComboBox<String> clientSchedule;
    public TextField clientWeight;
    public TextField clientHeight;
    public DatePicker clientPayday;
    public RadioButton clientPendency;
    public Button mainOperationButton;
    public Button cancelButton;
    public Button deleteClient;

    String[] Schedule = new String[]{"7:00 - 9:00", "9:00 - 11:00", "11:00 - 13:00", "13:00 - 15:00",
            "15:00 - 17:00", "17:00 - 19:00", "19:00 - 21:00"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientSchedule.getItems().addAll(Schedule);
        deleteClient.setOnAction(event -> deleteClient());

        // chooseOperation(-1);
    }

    public void chooseOperation(int idClient) {
        if (idClient == -1) {
            mainOperationButton.setOnAction(event -> registerClient());
            deleteClient.setVisible(false);
        }else{
            mainOperationButton.setOnAction(event -> editClient());
            deleteClient.setVisible(false);

            // pega cliente no bd
             clientName.setText("quando pegar do bd so mudar os campos");
        }
    }

    @FXML
    protected void registerClient() {
        System.out.println("registrou");
    }

    public void editClient() {
        // TODO
        System.out.println("editou");
    }

    public void deleteClient() {
        // TODO
        System.out.println("deletou");
    }
}
