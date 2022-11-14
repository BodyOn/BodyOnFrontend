package com.example.bodyonfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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

    String[] Schedule = new String[]{"7:00 - 9:00", "9:00 - 11:00", "11:00 - 13:00", "13:00 - 15:00",
            "15:00 - 17:00", "17:00 - 19:00", "19:00 - 21:00"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientSchedule.getItems().addAll(Schedule);
    }

    @FXML
    protected void registerClientButton(ActionEvent actionEvent) {
        System.out.println();
        System.out.println("clientName: " + clientName.getText());
        System.out.println("clientAddress:" + clientAddress.getText());
        System.out.println("clientEmail: " + clientEmail.getText());
        System.out.println("clientCpf: " + clientCpf.getText());
        System.out.println("clientFone: " + clientFone.getText());
        System.out.println("clientSchedule: " + clientSchedule.getValue());
        System.out.println("clientWeight: " + clientWeight.getText());
        System.out.println("clientHeight: " + clientHeight.getText());
        System.out.println("clientPayday: " + clientPayday.getValue().toString());
        System.out.println("clientPendency: " + clientPendency.isSelected());
    }
}
