package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;
import java.util.List;

public class CriarCriterioAvaliacao{

    private List<CriterioAvaliacao> criterios;

    // Construtor
    public CriarCriterioAvaliacao() {
        this.criterios = new ArrayList<>();
    }

    // Metodo para criar e adicionar um criterio de avaliacao
    public CriterioAvaliacao criarCriterioAvaliacao(String nome, String descricao) {
        CriterioAvaliacao criterio = new CriterioAvaliacao( nome,  descricao);
        criterios.add(criterio);
        return criterio;
    }

    // Metodo para remover um criterio de avaliacao
    public boolean removerCriterioAvaliacao(CriterioAvaliacao criterio) {
        return criterios.remove(criterio);
    }

    // metodo para obter todos os criterios de avaliacao
    public List<CriterioAvaliacao> getCriterios() {
        return new ArrayList<>(criterios); // Retorna uma cópia para preservar o encapsulamento
    }

    // metodo para buscar um criterio pelo nome
    public CriterioAvaliacao buscarCriterioPorNome(String nome) {
        for (CriterioAvaliacao criterio : criterios) {
            if (criterio.getNome().equalsIgnoreCase(nome)) {
                return criterio;
            }
        }
        return null; 
    }
}