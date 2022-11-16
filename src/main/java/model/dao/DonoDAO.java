package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.domain.Dono;

public class DonoDAO {
    private Connection connection;
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(Dono dono) {
        String sql = "INSERT INTO dono(id_dono, nome, cpf, telefone, endereco, cargo, horario_trabalho, email, senha) " +
                "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, dono.getId());
            stmt.setString(2, dono.getNome());
            stmt.setString(3, dono.getCpf());
            stmt.setString(4, dono.getTelefone());
            stmt.setString(5, dono.getEndereco());
            stmt.setString(6, dono.getCargo());
            stmt.setString(7, dono.getHorarioTrabalho());
            stmt.setString(8, dono.getEmail());
            stmt.setString(9, dono.getSenha());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    DonoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean update(Dono dono) {
        String sql = "UPDATE dono SET nome=?, cpf=?, telefone=?, endereco=?, cargo=?, horario_trabalho=?, email=?, senha=? WHERE id_dono=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, dono.getNome());
            stmt.setString(2, dono.getCpf());
            stmt.setString(3, dono.getTelefone());
            stmt.setString(4, dono.getEndereco());
            stmt.setString(5, dono.getCargo());
            stmt.setString(6, dono.getHorarioTrabalho());
            stmt.setString(7, dono.getEmail());
            stmt.setString(8, dono.getSenha());
            stmt.setInt(9, dono.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    DonoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean delete(Dono dono) {
        String sql = "DELETE FROM dono WHERE id_dono=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, dono.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    DonoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public List<Dono> list() {
        String sql = "SELECT * FROM dono";
        List<Dono> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Dono dono = new Dono();

                dono.setId(resultado.getInt("id_dono"));
                dono.setNome(resultado.getString("nome"));
                dono.setCpf(resultado.getString("cpf"));
                dono.setTelefone(resultado.getString("telefone"));
                dono.setEndereco(resultado.getString("endereco"));
                dono.setCargo(resultado.getString("cargo"));
                dono.setHorarioTrabalho(resultado.getString("horario_trabalho"));
                dono.setEmail(resultado.getString("email"));
                dono.setSenha(resultado.getString("senha"));

                retorno.add(dono);
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    DonoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }
        return retorno;
    }

    public Dono search(Dono dono) {
        String sql = "SELECT * FROM dono WHERE id_dono=?";
        Dono retorno = new Dono ();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, dono.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {

                dono.setId(resultado.getInt("id_dono"));
                dono.setNome(resultado.getString("nome"));
                dono.setCpf(resultado.getString("cpf"));
                dono.setTelefone(resultado.getString("telefone"));
                dono.setEndereco(resultado.getString("endereco"));
                dono.setCargo(resultado.getString("cargo"));
                dono.setHorarioTrabalho(resultado.getString("horario_trabalho"));
                dono.setEmail(resultado.getString("email"));
                dono.setSenha(resultado.getString("senha"));

                retorno = dono;
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    DonoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }
        return retorno;
    }
}
