package com.example.bodyonfront;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.domain.Cliente;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientOperationsController implements Initializable {
    @FXML
    public TextField clientName;
    @FXML
    public TextField clientAddress;
    @FXML
    public TextField clientEmail;
    @FXML
    public TextField clientCpf;
    @FXML
    public TextField clientFone;
    @FXML
    public ComboBox<String> clientSchedule;
    @FXML
    public TextField clientWeight;
    @FXML
    public TextField clientHeight;
    @FXML
    public DatePicker clientPayday;
    @FXML
    public RadioButton clientPendency;
    @FXML
    public Button mainOperationButton;
    @FXML
    public Button cancelButton;
    @FXML
    public Button deleteClient;

    String[] Schedule = new String[]{"7:00 - 9:00", "9:00 - 11:00", "11:00 - 13:00", "13:00 - 15:00",
            "15:00 - 17:00", "17:00 - 19:00", "19:00 - 21:00"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientSchedule.getItems().addAll(Schedule);
        deleteClient.setOnAction(event -> deleteClient());
    }

    public void chooseOperation(Cliente client) {
        if (client == null) {
            mainOperationButton.setOnAction(event -> registerClient());
            deleteClient.setVisible(false);
        }else{
            mainOperationButton.setOnAction(event -> editClient());
            deleteClient.setVisible(true);

            // pega cliente no bd

            // setando os dados
            clientName.setText(client.getNome());
            clientAddress.setText(client.getEndereco());
            clientEmail.setText(client.getEmail());
            clientCpf.setText(client.getCpf());
            clientFone.setText(client.getTelefone());
            // clientSchedule.setText(client.getNome());
            clientWeight.setText((String.valueOf(client.getPeso())));
            clientHeight.setText((String.valueOf(client.getAltura())));
            // clientPayday.setText(client.getNome());
            clientPendency.setVisible(client.isPendente());
        }
    }

    @FXML
    protected void registerClient() {
        // TODO
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