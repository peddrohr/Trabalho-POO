package com.mycompany.avaliacaosubmissaodetrabalhos;

public class Etapa {

    //atributos
    private String nomeEtapa;
    private String dataInicio;
    private String dataFim;
    private String descricao;

    //construtores
    public Etapa(String nomeEtapa) {
        setNomeEtapa(nomeEtapa);
    }

    public Etapa(String nomeEtapa, String dataInicio, String dataFim, String descricao) {
        setNomeEtapa(nomeEtapa);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setDescricao(descricao);
    }


    //setters
    private void setNomeEtapa(String nomeEtapa) {
        if (nomeEtapa != null && !nomeEtapa.isEmpty()) {
            this.nomeEtapa = nomeEtapa;
        } else {
            throw new ExceptionInInitializerError("O nome da etapa não pode ser vazio");
        }
    }

    public void setDataInicio(String dataInicio) {
        if (dataInicio.length() == 8) {
            this.dataInicio = dataInicio;
        } else {
            throw new ExceptionInInitializerError("por favor informe a data de forma correta: ##/##/####");
        }
    }

    public void setDataFim(String dataFim) {
        if (dataFim.length() == 8) {
            this.dataFim = dataFim;
        } else {
            throw new ExceptionInInitializerError("por favor informe a data de forma correta: ##/##/####");
        }
    }

    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new ExceptionInInitializerError("A descricao não pode ser vazia");
        }
    }

    //getters
    public String getNomeEtapa() {
        return nomeEtapa;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public String getDescricao() {
        return descricao;
    }
}
