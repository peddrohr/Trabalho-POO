package com.mycompany.avaliacaosubmissaodetrabalhos;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.*;
import java.util.*;

public class Avaliacao {

    private float nota;
    private Trabalho trabalho;
    private String comentario;
    private Avaliador avaliador;
    private ArrayList<CriterioAvaliacao> criteriosAvaliacao;

    //setters  
    public void setNota(float nota) throws NotaInvalidaException {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
        } else {
            throw new NotaInvalidaException();
        }
    }

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

    public void setAvaliador(Avaliador avaliador) throws AvaliadorInvalidoException {
        if (avaliador != null && avaliador instanceof Avaliador) {
            this.avaliador = avaliador;
        } else {
            throw new AvaliadorInvalidoException();
        }
    }

    public void setCriteriosAvaliacao(Trabalho trabalho) throws SemTrabalhoDefinidoException {
        if (trabalho != null && trabalho instanceof Trabalho) {
            criteriosAvaliacao = new ArrayList();
            //criteriosAvaliacao = trabalho.getModalidade().getCriteriosAvaliacao();
        } else {
            throw new SemTrabalhoDefinidoException();
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

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public ArrayList getCriteriosAvaliacao() {
        return criteriosAvaliacao;
    }
}
