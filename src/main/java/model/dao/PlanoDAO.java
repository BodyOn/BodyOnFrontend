package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.domain.Plano;

public class PlanoDAO {
    private Connection connection;
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(Plano plano) {
        String sql = "INSERT INTO planos(id_plano, nome, descricao, valor) " +
                "     VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, plano.getId());
            stmt.setString(2, plano.getNome());
            stmt.setString(3, plano.getDescricao());
            stmt.setDouble(4, plano.getValor());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    PlanoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean update(Plano plano) {
        String sql = "UPDATE planos SET nome=?, descricao=?, valor=? WHERE id_plano=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, plano.getNome());
            stmt.setString(2, plano.getDescricao());
            stmt.setDouble(3, plano.getValor());
            stmt.setInt(4, plano.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    PlanoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean delete(Plano plano) {
        String sql = "DELETE FROM planos WHERE id_plano=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, plano.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    PlanoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public List<Plano> list() {
        String sql = "SELECT * FROM planos";
        List<Plano> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Plano plano = new Plano();

                plano.setId(resultado.getInt("id_plano"));
                plano.setNome(resultado.getString("nome"));
                plano.setDescricao(resultado.getString("descricao"));
                plano.setValor(resultado.getDouble("valor"));

                retorno.add(plano);
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    PlanoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }
        return retorno;
    }

    public Plano search(Plano plano) {
        String sql = "SELECT * FROM planos WHERE id_plano=?";
        Plano retorno = new Plano();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, plano.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {

                plano.setNome(resultado.getString("nome"));
                plano.setDescricao(resultado.getString("descricao"));
                plano.setValor(resultado.getDouble("valor"));

                retorno = plano;
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    PlanoDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }
        return retorno;
    }
}
