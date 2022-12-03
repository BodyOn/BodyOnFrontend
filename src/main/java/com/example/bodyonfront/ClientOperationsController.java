package com.example.bodyonfront;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import model.dao.ClienteDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Cliente;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import static junit.framework.TestCase.assertEquals;

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
    public int clientId;

    String[] Schedule = new String[]{"7:00 - 9:00", "9:00 - 11:00", "11:00 - 13:00", "13:00 - 15:00",
            "15:00 - 17:00", "17:00 - 19:00", "19:00 - 21:00"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clientSchedule.getItems().addAll(Schedule);
        deleteClient.setOnAction(this::deleteClient);
    }

    public void chooseOperation(Cliente client) {
        if (client == null) {
            mainOperationButton.setOnAction(this::registerClient);
            deleteClient.setVisible(false);
        }else{
            mainOperationButton.setOnAction(this::editClient);
            deleteClient.setVisible(true);

            // pega cliente no db
            Date dataCliente = client.getDataPagamento();
            LocalDate date = dataCliente.toLocalDate();

            // setando os dados
            clientId = client.getId();
            clientName.setText(client.getNome());
            clientAddress.setText(client.getEndereco());
            clientEmail.setText(client.getEmail());
            clientCpf.setText(client.getCpf());
            clientFone.setText(client.getTelefone());
            // clientSchedule.setText(client.getNome());
            clientWeight.setText((String.valueOf(client.getPeso())));
            clientHeight.setText((String.valueOf(client.getAltura())));
            clientPayday.setValue(date);
            clientPendency.setVisible(client.isPendente());
        }
    }

    @FXML
    protected void registerClient(ActionEvent event) {
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        ClienteDAO cliente = new ClienteDAO();

        LocalDate payday = clientPayday.getValue();

        //TODO
        //REMOVER ISSO QUANDO TIVER TERMINADO
        System.out.println("CLIENT ID " + clientId);

        Cliente insertClient = new Cliente(
                                        clientName.getText(),
                                        clientAddress.getText(),
                                        clientFone.getText(),
                                        clientEmail.getText(),
                                        clientCpf.getText(),
                                        Double.parseDouble(clientWeight.getText()),
                                        Double.parseDouble(clientHeight.getText()),
                                        clientSchedule.getItems().get(0),
                                 1,
                                        Date.valueOf(payday),
                                        clientPendency.isSelected()
        );

        cliente.setConnection(conn);
        boolean resposta = cliente.insertById(insertClient);

        if(resposta){
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }

    }

    public void editClient(ActionEvent event) {
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        ClienteDAO cliente = new ClienteDAO();

        LocalDate payday = clientPayday.getValue();

        //TODO
        //REMOVER ISSO QUANDO TIVER TERMINADO
        System.out.println("CLIENT ID " + clientId);

        Cliente updateClient = new Cliente(
                clientId,
                clientName.getText(),
                clientAddress.getText(),
                clientFone.getText(),
                clientEmail.getText(),
                clientCpf.getText(),
                Double.parseDouble(clientWeight.getText()),
                Double.parseDouble(clientHeight.getText()),
                clientSchedule.getItems().get(0),
                1,
                Date.valueOf(payday),
                clientPendency.isSelected()
        );

        cliente.setConnection(conn);
        boolean resposta = cliente.update(updateClient);

        if(resposta){
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }

    public void deleteClient(ActionEvent event) {
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        ClienteDAO cliente = new ClienteDAO();

        LocalDate payday = clientPayday.getValue();

        //TODO
        //REMOVER ISSO QUANDO TIVER TERMINADO
        System.out.println("CLIENT ID " + clientId);

        Cliente deleteClient = new Cliente(
                clientId,
                clientName.getText(),
                clientAddress.getText(),
                clientFone.getText(),
                clientEmail.getText(),
                clientCpf.getText(),
                Double.parseDouble(clientWeight.getText()),
                Double.parseDouble(clientHeight.getText()),
                clientSchedule.getItems().get(0),
                1,
                Date.valueOf(payday),
                clientPendency.isSelected()
        );

        cliente.setConnection(conn);
        boolean resposta = cliente.delete(deleteClient);

        if(resposta){
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }

    public void onCancelButton(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
