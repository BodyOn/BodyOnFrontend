package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.domain.Exercicio;

public class ExercicioDAO {
    private Connection connection;
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(Exercicio exercicio) {
        String sql = "INSERT INTO exercicios(id_exercicio, nome, qtd_series, qtd_repeticoes, id_cliente) " +
                "     VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, exercicio.getId());
            stmt.setString(2, exercicio.getNome());
            stmt.setInt(3, exercicio.getQtdSeries());
            stmt.setInt(4, exercicio.getQtdRepeticoes());
            stmt.setInt(5, exercicio.getIdCliente());

            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    ExercicioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean update(Exercicio exercicio) {
        String sql = "UPDATE exercicios SET nome=?, qtd_series=?, qtd_repeticoes=?, id_cliente=? WHERE id_exercicio=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, exercicio.getNome());
            stmt.setInt(2, exercicio.getQtdSeries());
            stmt.setInt(3, exercicio.getQtdRepeticoes());
            stmt.setInt(4, exercicio.getIdCliente());
            stmt.setInt(5, exercicio.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    ExercicioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public boolean delete(Exercicio exercicio) {
        String sql = "DELETE FROM exercicios WHERE id_exercicio=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, exercicio.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(
                    ExercicioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
            return false;
        }
    }

    public List<Exercicio> list() {
        String sql = "SELECT * FROM exercicios";
        List<Exercicio> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Exercicio exercicio =  new Exercicio();

                exercicio.setId(resultado.getInt("id_exercicio"));
                exercicio.setNome(resultado.getString("nome"));
                exercicio.setQtdSeries(resultado.getInt("qtd_series"));
                exercicio.setQtdRepeticoes(resultado.getInt("qtd_repeticoes"));
                exercicio.setIdCliente(resultado.getInt("id_cliente"));

                retorno.add(exercicio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    ExercicioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }
        return retorno;
    }

    public Exercicio search(Exercicio exercicio) {
        String sql = "SELECT * FROM exercicios WHERE id_exercicio=?";
        Exercicio retorno =  new Exercicio();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, exercicio.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {

                exercicio.setNome(resultado.getString("nome"));
                exercicio.setQtdSeries(resultado.getInt("qtd_series"));
                exercicio.setQtdRepeticoes(resultado.getInt("qtd_repeticoes"));
                exercicio.setIdCliente(resultado.getInt("id_cliente"));

                retorno = exercicio;
            }
        } catch (SQLException ex) {
            Logger.getLogger(
                    ExercicioDAO.class.getName()).log(Level.SEVERE, null, ex
            );
        }
        return retorno;
    }
}
