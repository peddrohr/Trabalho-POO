package com.mycompany.avaliacaosubmissaodetrabalhos;

public class CriterioAvaliacao {

    private String nome;
    private String descricao;
    private float pontuacaoMaxima;

    //construtores
    public CriterioAvaliacao(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
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

    //getters
    public String getDescricao() {
        return descricao;
    }
    public String getNome() {
        return nome;
    }

    public float getPontuacaoMaxima() {
        return 5;
    }
    
}

