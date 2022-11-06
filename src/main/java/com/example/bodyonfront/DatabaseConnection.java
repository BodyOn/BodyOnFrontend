package com.example.bodyonfront;

import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {

    public Connection databaseLink;
    public String url;
    public String senha;
    public String usuario;
    public String database;

    public Connection getConnection() {
         usuario = "postgres";
         database = "clientes";
         senha = "1234";
         url = "jdbc:postgresql://localhost:5432/BodyOndb";

        try {
            Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conexão feita com sucesso!!");

        } catch (Exception exception) {
            {
                exception.printStackTrace();
            }
        }
        return databaseLink;
    }
}
