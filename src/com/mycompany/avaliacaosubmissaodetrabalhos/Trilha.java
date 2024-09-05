package com.mycompany.avaliacaosubmissaodetrabalhos;

public class Trilha {

    private String nome;
    private String descricao;

    //setters
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome da trilha não pode ser vazio");
        }
    }

    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
    }

    //getters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
