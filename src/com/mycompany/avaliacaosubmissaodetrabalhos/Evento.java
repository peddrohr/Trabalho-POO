package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

public class Evento {

    private String nome;
    private String dataInicio;
    private String dataFim;
    private ArrayList<Etapa> etapas;

    public Evento(String nome, String dataInicio, String dataFim) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;

        etapas = new ArrayList();
    }

    public Evento(){
        etapas = new ArrayList<>();
    }

    //setters
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new ExceptionInInitializerError("Nome do evento não pode ser vazio");
        }
    }

    public void setDataInicio(String dataInicio) {
        if (dataInicio != null && !dataInicio.isEmpty() && dataInicio.length() == 8) {
            this.dataInicio = dataInicio;
        } else {
            throw new ExceptionInInitializerError("Data de inicio do evento não pode ser vazia");
        }
    }

    public void setDataFim(String dataFim) {
        if (dataFim != null && !dataFim.isEmpty() && dataFim.length() == 8) {
            this.dataFim = dataFim;
        } else {
            throw new ExceptionInInitializerError("Data de fim do evento não pode ser vazia");
        }
    }

    //cadastra uma nova etapa
    public void cadastrarEtapa(Etapa etapa) {
        if (etapa != null && etapa instanceof Etapa) {
            etapas.add(etapa);
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void CriarNovaEtapa(String nome, String dataInicio, String dataFim, String descricao){
        Etapa etapa = new Etapa(nome, dataInicio, dataFim, descricao);
        this.etapas.add(etapa);
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
}
