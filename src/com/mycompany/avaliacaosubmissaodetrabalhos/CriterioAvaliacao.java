package com.mycompany.avaliacaosubmissaodetrabalhos;

public class CriterioAvaliacao {

    private String nome;
    private String descricao;
    private float pontuacaoMaxima;

    //construtores
    public CriterioAvaliacao(String nome, String descricao, float pontuacaoMaxima){
        this.nome = nome;
        this.descricao = descricao;
        this.pontuacaoMaxima = pontuacaoMaxima;
    }
    //setters
    public void setDescricao(String descricaoo) {
        if (descricao != null && !descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new ExceptionInInitializerError("A descricao nao pode ser vazia");
        }

    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new ExceptionInInitializerError("O nome do criterio nao pode ser vazio");
        }
    }

    public void setPontuacaoMaxima(float pontuacaoMaxima) {
        if (Float.isFinite(pontuacaoMaxima) && pontuacaoMaxima > 0) {
            this.pontuacaoMaxima = pontuacaoMaxima;
        } else {
            throw new IllegalArgumentException("A pontuacao deve ser finita e maior que zero");
        }
    }

    //getters
    public String getDescricao() {
        return descricao;
    }
    public String getNome() {
        return nome;
    }

    public float getPontuacaoMaxima() {
        return pontuacaoMaxima;
    }
    
}

