package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.*;

public class Evento {

    private String nome;
    private String dataInicio;
    private String dataFim;
    private ArrayList<Etapa> etapas;

    public Evento(String nome, String dataInicio, String dataFim) {
        setNome(nome);
        setDataInicio(dataInicio);
        setDataFim(dataFim);

        etapas = new ArrayList();
    }

    //setters
    private void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new ExceptionInInitializerError("Nome do evento não pode ser vazio");
        }
    }

    private void setDataInicio(String dataInicio) {
        if (dataInicio != null && !dataInicio.isEmpty() && dataInicio.length() == 8) {
            this.dataInicio = dataInicio;
        } else {
            throw new ExceptionInInitializerError("Data de inicio do evento não pode ser vazia");
        }
    }

    private void setDataFim(String dataFim) {
        if (dataFim != null && !dataFim.isEmpty() && dataFim.length() == 8) {
            this.dataFim = dataFim;
        } else {
            throw new ExceptionInInitializerError("Data de fim do evento não pode ser vazia");
        }
    }

    public void cadastrarEtapa(Etapa etapa) {
        if (etapa != null && etapa instanceof Etapa) {
            etapas.add(etapa);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public ArrayList getEtapa() {
        return etapas;
    }
}
