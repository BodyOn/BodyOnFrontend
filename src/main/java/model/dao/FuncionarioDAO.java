package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.domain.Funcionario;

public class FuncionarioDAO {
    private Connection connection;
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios(id_funcionario, nome, cpf, email, telefone, endereco, cargo, horario_trabalho) " +
                "     VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getEndereco());
            stmt.setString(7, funcionario.getCargo());
            stmt.setString(8, funcionario.getHorarioTrabalho());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean update(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome=?, cpf=?, email=?, telefone=?, endereco=?, cargo=?, horario_trabalho=? WHERE id_funcionario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setString(5, funcionario.getEndereco());
            stmt.setString(6, funcionario.getCargo());
            stmt.setString(7, funcionario.getHorarioTrabalho());
            stmt.setInt(8, funcionario.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean delete(Funcionario funcionario) {
        String sql = "DELETE FROM funcionarios WHERE id_funcionario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public List<Funcionario> list() {
        String sql = "SELECT * FROM funcionarios";
        List<Funcionario> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setId(resultado.getInt("id_funcionario"));
                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setEndereco(resultado.getString("endereco"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setHorarioTrabalho(resultado.getString("horario_trabalho"));

                retorno.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }
        return retorno;
    }

    public Funcionario search(Funcionario funcionario) {
        String sql = "SELECT * FROM funcionarios WHERE id_funcionario=?";
        Funcionario retorno = new Funcionario();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {

                funcionario.setNome(resultado.getString("nome"));
                funcionario.setCpf(resultado.getString("cpf"));
                funcionario.setEmail(resultado.getString("email"));
                funcionario.setTelefone(resultado.getString("telefone"));
                funcionario.setEndereco(resultado.getString("endereco"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setHorarioTrabalho(resultado.getString("horario_trabalho"));

                retorno = funcionario;
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }
        return retorno;
    }
}
