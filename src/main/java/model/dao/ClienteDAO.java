package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.Cliente;

public class ClienteDAO {
    private Connection connection;
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(Cliente cliente) {
        String sql = "INSERT INTO clientes(id_cliente, nome, endereco, telefone, email, cpf, peso, altura, horario, id_plano, data_pagamento, pendente) " +
                "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getCpf());
            stmt.setDouble(7, cliente.getPeso());
            stmt.setDouble(8, cliente.getAltura());
            stmt.setString(9, cliente.getHorario());
            stmt.setInt(10, cliente.getIdPlano());
            stmt.setDate(11, cliente.getDataPagamento());
            stmt.setBoolean(12, cliente.isPendente());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    ClienteDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean update(Cliente cliente) {
        String sql = "UPDATE clientes SET nome=?, endereco=?, telefone=?, email=?, cpf=?, peso=?, altura=?, horario=?, id_plano=?, data_pagamento=?, pendente=? WHERE id_cliente=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCpf());
            stmt.setDouble(6, cliente.getPeso());
            stmt.setDouble(7, cliente.getAltura());
            stmt.setString(8, cliente.getHorario());
            stmt.setInt(9, cliente.getIdPlano());
            stmt.setDate(10, cliente.getDataPagamento());
            stmt.setBoolean(11, cliente.isPendente());
            stmt.setInt(12, cliente.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    ClienteDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean delete(Cliente cliente) {
        String sql = "DELETE FROM clientes WHERE id_cliente=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    ClienteDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public List<Cliente> list() {
        String sql = "SELECT * FROM clientes";
        List<Cliente> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(resultado.getInt("id_cliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setPeso(resultado.getDouble("peso"));
                cliente.setAltura(resultado.getDouble("altura"));
                cliente.setHorario(resultado.getString("horario"));
                cliente.setIdPlano(resultado.getInt("id_plano"));
                cliente.setDataPagamento(resultado.getDate("data_pagamento"));
                cliente.setPendente(resultado.getBoolean("pendente"));

                retorno.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Cliente search(Cliente cliente) {
        String sql = "SELECT * FROM clientes WHERE id_cliente=?";
        Cliente retorno = new Cliente();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {

                cliente.setNome(resultado.getString("nome"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setTelefone(resultado.getString("telefone"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setPeso(resultado.getDouble("peso"));
                cliente.setAltura(resultado.getDouble("altura"));
                cliente.setHorario(resultado.getString("horario"));
                cliente.setIdPlano(resultado.getInt("id_plano"));
                cliente.setDataPagamento(resultado.getDate("data_pagamento"));
                cliente.setPendente(resultado.getBoolean("pendente"));

                retorno = cliente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    ClienteDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }
        return retorno;
    }


}
