package com.example.bodyonfront;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.dao.ClienteDAO;
import model.database.Database;
import model.database.DatabaseFactory;
import model.domain.Cliente;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public class TesteController {

    @FXML
    private TableView<Cliente> tableViewCliente;
    private List<Cliente> clientesList;
    private Database db = DatabaseFactory.getDatabase("postgresql");
    private Connection conn = db.connect();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ObservableList<Cliente> observableListClientes;

    public void loadTableViewCliente() {
        clientesList = clienteDAO.list();

        observableListClientes = FXCollections.observableArrayList(clientesList);
        tableViewCliente.setItems(observableListClientes);
    }
}
