package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.CriterioAvaliacaoInvalidoException;

public class Modalidade {

    private String nome;
    private String descricao;
    private ArrayList<CriterioAvaliacao> criteriosAvaliacao;

    public Modalidade(String nome) {
        this.setNome(nome);
        criteriosAvaliacao = new ArrayList();
    }

    public void adicionarCriterioAvaliacao(CriterioAvaliacao criterioAvaliacao) throws CriterioAvaliacaoInvalidoException {
        if (criterioAvaliacao != null && criterioAvaliacao instanceof CriterioAvaliacao) {
            criteriosAvaliacao.add(criterioAvaliacao);
        } else {
            throw new CriterioAvaliacaoInvalidoException();
        }
    }

    public void removerCriterioAvaliacao(CriterioAvaliacao criterioAvaliacao) throws CriterioAvaliacaoInvalidoException {
        if (criterioAvaliacao != null && criteriosAvaliacao.contains(criterioAvaliacao) && criterioAvaliacao instanceof CriterioAvaliacao) {
            int indice = criteriosAvaliacao.indexOf(criterioAvaliacao);
            criteriosAvaliacao.remove(indice);
        } else {
            throw new CriterioAvaliacaoInvalidoException();
        }
    }

    //setters
    private void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome da modalidade não pode ser vazio");
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

    public ArrayList getCriteriosAvaliacao() {
        return criteriosAvaliacao;
    }
}
