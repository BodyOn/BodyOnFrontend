package model.domain;

import java.io.Serializable;
import java.sql.Date;

public class Cliente implements Serializable {

    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;
    private double peso;
    private double altura;
    private String horario;
    private int idPlano;
    private Date dataPagamento;
    private boolean pendente;

    public Cliente(){}
    
    public Cliente(
            int id,
            String nome,
            String endereco,
            String telefone,
            String email,
            String cpf,
            double peso,
            double altura,
            String horario,
            int idPlano,
            Date dataPagamento,
            boolean pendente ) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.peso = peso;
        this.altura = altura;
        this.horario = horario;
        this.idPlano = idPlano;
        this.dataPagamento = dataPagamento;
        this.pendente = pendente;
    }

    public Cliente(
            String nome,
            String endereco,
            String telefone,
            String email,
            String cpf,
            double peso,
            double altura,
            String horario,
            int idPlano,
            Date dataPagamento,
            boolean pendente ) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.peso = peso;
        this.altura = altura;
        this.horario = horario;
        this.idPlano = idPlano;
        this.dataPagamento = dataPagamento;
        this.pendente = pendente;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public double getPeso() { return peso; }

    public void setPeso(double peso) { this.peso = peso; }

    public double getAltura() { return altura; }

    public void setAltura(double altura) { this.altura = altura; }

    public String getHorario() { return horario; }

    public void setHorario(String horario) { this.horario = horario; }

    public int getIdPlano() { return idPlano; }

    public void setIdPlano(int idPlano) { this.idPlano = idPlano; }

    public Date getDataPagamento() { return dataPagamento; }

    public void setDataPagamento(Date dataPagamento) { this.dataPagamento = dataPagamento; }

    public boolean isPendente() { return pendente; }

    public void setPendente(boolean pendente) { this.pendente = pendente; }

    @Override
    public String toString() {
        return this.nome;
    }
}
