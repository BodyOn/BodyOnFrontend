package model.domain;

public class Plano {
    private int id;
    private String nome;
    private String descricao;
    private double valor;

    public Plano(){}

    public Plano(
            int id,
            String nome,
            String descricao,
            double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }

    public void setValor(double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return nome;
    }
}
