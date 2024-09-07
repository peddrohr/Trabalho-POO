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
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPontuacaoMaxima(float pontuacaoMaxima) {
        this.pontuacaoMaxima = pontuacaoMaxima;
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

