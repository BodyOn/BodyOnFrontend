package model.domain;

public class Exercicio {
    private int id;
    private String nome;
    private int qtdSeries;
    private int qtdRepeticoes;
    private String idCliente;

    public Exercicio(){}

    public Exercicio(
            int id,
            String nome,
            int qtdSeries,
            int qtdRepeticoes,
            String idCliente) {
        this.id = id;
        this.nome = nome;
        this.qtdSeries = qtdSeries;
        this.qtdRepeticoes = qtdRepeticoes;
        this.idCliente = idCliente;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getQtdSeries() { return qtdSeries;}

    public void setQtdSeries(int qtdSeries) { this.qtdSeries = qtdSeries; }

    public int getQtdRepeticoes() { return qtdRepeticoes; }

    public void setQtdRepeticoes(int qtdRepeticoes) { this.qtdRepeticoes = qtdRepeticoes; }

    public String getIdCliente() { return idCliente; }

    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }

    @Override
    public String toString() {
        return nome;
    }
}
