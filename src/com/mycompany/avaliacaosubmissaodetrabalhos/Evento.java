package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

public class Evento {

    //atributos
    private String nome;
    private String dataInicio;
    private String dataFim;
    private ArrayList<Etapa> etapas;

    //construtores
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
        if (dataInicio != null && !dataInicio.isEmpty() && dataInicio.length() == 10) {
            this.dataInicio = dataInicio;
        } else {
            throw new ExceptionInInitializerError("Data de inicio do evento não pode ser vazia");
        }
    }

    private void setDataFim(String dataFim) {
        if (dataFim != null && !dataFim.isEmpty() && dataFim.length() == 10) {
            this.dataFim = dataFim;
        } else {
            throw new ExceptionInInitializerError("Data de fim do evento não pode ser vazia");
        }
    }

    //getters
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

    @Override
    public String toString() {
        return getNome();
    }

    //metodo para cadastrar uma nova etapa e adiciona no ArrayList de etapas
    public void cadastrarEtapa(Etapa etapa) {
        if (etapa != null && etapa instanceof Etapa) {
            etapas.add(etapa);
        }
    }
}
