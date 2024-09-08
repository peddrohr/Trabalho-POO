package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;
import java.util.Map;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.NotaInvalidaException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.SemTrabalhoDefinidoException;

public class Avaliacao {

    private Trabalho trabalho;
    private String comentario;
    private ArrayList<CriterioAvaliacao> criteriosAvaliacao;
    private Modalidade modalidade;
    private Map<CriterioAvaliacao, Float> notasPorCriterio;
    private float nota;

    public Avaliacao(Trabalho trabalho, float nota, String comentario){
        this.trabalho = trabalho;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Avaliacao(Trabalho trabalho){
        this.trabalho = trabalho;
    }

    //setters  

    public void setTrabalho(Trabalho trabalho) throws SemTrabalhoDefinidoException {
        if (trabalho != null && trabalho instanceof Trabalho) {
            this.trabalho = trabalho;
        } else {
            throw new SemTrabalhoDefinidoException();
        }
    }

    public void setComentario(String comentario) {
        if (comentario != null) {
            this.comentario = comentario;
        }
    }

    //getters
    public float getNota() {
        return nota;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public String getComentario() {
        return comentario;
    }

    public ArrayList getCriteriosAvaliacao() {
        return new ArrayList<>(criteriosAvaliacao);
    }

    public Map<CriterioAvaliacao, Float> getNotasPorCriterio() {
        return notasPorCriterio;
    }
    
    //adiciona uma nota para cada critério de avaliação
    public void avaliarCriterio(CriterioAvaliacao criterio, float nota)throws NotaInvalidaException{
        if(nota < 0 || nota > 5){
            throw new NotaInvalidaException();
        }
        notasPorCriterio.put(criterio, nota);
    }

    //calcula a média das notas dada pelo avaliador em cada criterio
    public float calcularNotaFinal() {
        float notaFinal;
        float somaNotas = 0;
        for (Float nota : notasPorCriterio.values()) {
            somaNotas += nota;
        }
        notaFinal = somaNotas/ notasPorCriterio.size();
        setNota(notaFinal);
        return nota; 
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
