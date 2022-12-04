package model.domain;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String cargo;
    private String horarioTrabalho;

    public Funcionario(){}

    public Funcionario(
            int id,
            String nome,
            String cpf,
            String email,
            String telefone,
            String endereco,
            String cargo,
            String horarioTrabalho) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cargo = cargo;
        this.horarioTrabalho = horarioTrabalho;
    }

    public Funcionario(
            String nome,
            String cpf,
            String email,
            String telefone,
            String endereco,
            String cargo,
            String horarioTrabalho) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cargo = cargo;
        this.horarioTrabalho = horarioTrabalho;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email;}

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCargo() { return cargo; }

    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getHorarioTrabalho() { return horarioTrabalho; }

    public void setHorarioTrabalho(String horarioTrabalho) { this.horarioTrabalho = horarioTrabalho; }

    @Override
    public String toString() {
        return nome ;
    }

}
