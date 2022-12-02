package com.example.bodyonfront;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dao.ClienteDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Cliente;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    public TableView<Cliente> clientTable;
    @FXML
    public TableColumn<Cliente, String> tableColumnClientAddressNome;
    @FXML
    public TableColumn<Cliente, String> tableColumnClientAddress;
    @FXML
    public TableColumn<Cliente, String> tableColumnClientFone;
    @FXML
    public TableColumn<Cliente, String> tableColumnClientEmail;
    @FXML
    public TableColumn<Cliente, String> tableColumnClientCpf;
    @FXML
    public TableColumn<Cliente, String> tableColumnClientSchedule;
    @FXML
    public TableColumn<Cliente, Integer> tableColumnClientPlanId;
    @FXML
    public TableColumn<Cliente, Date> tableColumnClientPayday;
    @FXML
    public TableColumn<Cliente, Boolean> tableColumnClientPendency;
    @FXML
    public TableColumn<Cliente, Double> tableColumnClientWeight;
    @FXML
    public TableColumn<Cliente, Double> tableColumnClientHeight;
    @FXML
    public Button registerClientButton;
    private final List<Cliente> clientList = new ArrayList<>();

    private boolean pendencyButtonClicked = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // iniciando colunas
        tableColumnClientAddressNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnClientAddress.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tableColumnClientFone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tableColumnClientEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnClientCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tableColumnClientSchedule.setCellValueFactory(new PropertyValueFactory<>("horario"));
        tableColumnClientPlanId.setCellValueFactory(new PropertyValueFactory<>("idPlano"));
        tableColumnClientPayday.setCellValueFactory(new PropertyValueFactory<>("dataPagamento"));
        tableColumnClientPendency.setCellValueFactory(new PropertyValueFactory<>("pendente"));
        tableColumnClientWeight.setCellValueFactory(new PropertyValueFactory<>("peso"));
        tableColumnClientHeight.setCellValueFactory(new PropertyValueFactory<>("altura"));

        loadClients();

        ObservableList<Cliente> observableList = FXCollections.observableArrayList(clientList);
        clientTable.setItems(observableList);

        // table listener
        clientTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> onTableItemClick(newValue));

        clientTable.setRowFactory(tv -> new TableRow<Cliente>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && item.isPendente()) {
                    setStyle("-fx-background-color: #ffd7d1;");
                } else {
                    setStyle("");
                }
            }
        });
    }

    public void mockData() {
        Cliente client = new Cliente(0, "isa", "rua tal", "8992828281", "isa@.com",
                "922891910", 80.0, 1.80, "9h - 8h", 1, null, true);
        Cliente client1 = new Cliente(1, "fals", "rua tal", "8992828281", "fals@.com",
                "922891910", 80.0, 1.80, "9h - 8h", 1, null, false);
        Cliente client2 = new Cliente(2, "josus", "rua tal", "8992828281", "josus@.com",
                "922891910", 80.0, 1.80, "9h - 8h", 1, null, true);

        clientList.add(client);
        clientList.add(client1);
        clientList.add(client2);

        ObservableList<Cliente> observableList = FXCollections.observableArrayList(clientList);
        clientTable.setItems(observableList);
    }

    private void loadClients(){
        Database db = DatabaseFactory.getDatabase("postgresql");
        Connection conn = db.connect();
        ClienteDAO cliente = new ClienteDAO();
        cliente.setConnection(conn);
        List<Cliente> resposta = cliente.list();

        clientList.addAll(resposta);

    }

    public void onRegisterClientButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clientOperations.fxml"));
        Parent root = fxmlLoader.load();

        ClientOperationsController clientOperationsController = fxmlLoader.getController();
        clientOperationsController.chooseOperation(null);

        Stage stage = new Stage();
        stage.setTitle("BodyOn");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void onPendencyButtonClick() {
        if (pendencyButtonClicked) {
            // pegar todos os clientes
            clientList.clear();

            loadClients();

            // TODO
            // Fazer uma função load pendent clients, executar query de busca onde tiver pendente e retornar lista

            ObservableList<Cliente> observableList = FXCollections.observableArrayList(clientList);
            clientTable.setItems(observableList);
            pendencyButtonClicked = false;
        }else{
            // pegar todos os clientes pendentes
            clientList.clear();

            Cliente client = new Cliente(0, "isa", "rua tal", "8992828281", "isa@.com",
                    "922891910", 80.0, 1.80, "9h - 8h", 1, null, true);
            Cliente client2 = new Cliente(2, "josus", "rua tal", "8992828281", "josus@.com",
                    "922891910", 80.0, 1.80, "9h - 8h", 1, null, true);

            clientList.add(client);
            clientList.add(client2);

            ObservableList<Cliente> observableList = FXCollections.observableArrayList(clientList);
            clientTable.setItems(observableList);
            pendencyButtonClicked = true;
        }
    }

    public void onTableItemClick(Cliente client)  {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clientOperations.fxml"));
            Parent root = fxmlLoader.load();

            ClientOperationsController clientOperationsController = fxmlLoader.getController();
            clientOperationsController.chooseOperation(client);

            Stage stage = new Stage();
            stage.setTitle("BodyOn");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
            stage.requestFocus();
            stage.toFront();
            stage.setAlwaysOnTop(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onHomeButtonClick(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("BodyOn");
            stage.setResizable(false);
            stage.setMaximized(true);
            stage.setScene(new Scene(root));
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
