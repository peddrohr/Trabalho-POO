package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.CriterioAvaliacaoInvalidoException;

public class Modalidade {

    //atributos
    private String nome;
    private String descricao;
    private ArrayList<CriterioAvaliacao> criteriosAvaliacao;

    //construtor
    public Modalidade(String nome, String descricao) {
        this.setNome(nome);
        this.setDescricao(descricao);
        criteriosAvaliacao = new ArrayList();
    }

    //cria um novo criterio de avaliacao e adiciona no ArrayList de criterios de avaliacao.
    public CriterioAvaliacao CriarCriterioAvaliacao(String nome, String descricao) throws CriterioAvaliacaoInvalidoException {
        CriterioAvaliacao criterio = new CriterioAvaliacao(nome, descricao);
        criteriosAvaliacao.add(criterio);
        return criterio;
    }

    //remove um criterio do ArrayList de criterios de avaliacao
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

    public ArrayList<CriterioAvaliacao> getCriteriosAvaliacao() {
        return new ArrayList<>(criteriosAvaliacao);
    }

    //faz uma busca na lista de criterios atraves do nome.
    public CriterioAvaliacao buscarCriterioPorNome(String nome) {
        for (CriterioAvaliacao criterio : criteriosAvaliacao) {
            if (criterio.getNome().equalsIgnoreCase(nome)) {
                return criterio;
            }
        }
        return null;
    }

}
