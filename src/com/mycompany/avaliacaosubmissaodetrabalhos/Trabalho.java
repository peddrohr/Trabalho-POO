package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.ModalidadeInvalidaException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.TrilhaInvalidaException;

public class Trabalho {

    private String nomeAutor;
    private int qntCoAutores;
    private ArrayList<String> nomeCoAutores;
    private String nomeOrientador;
    private String titulo;
    private String resumo;
    private String palavrasChave;
    private Modalidade modalidade;
    private Trilha trilha;

    //setters
    public void setNomeAutor(String nomeAutor) {
        if (nomeAutor != null && !nomeAutor.isEmpty()) {
            this.nomeAutor = nomeAutor;
        } else {
            throw new IllegalArgumentException("O nome do autor não pode ser vazio");
        }
    }

    public void setQntCoAutores(int qntCoAutores) {
        if (qntCoAutores > 0 && qntCoAutores < 5) {
            this.qntCoAutores = qntCoAutores;
        } else {
            throw new IllegalArgumentException("O valor de co-autores deve estar entre 0 e 5");
        }
    }

    public void setNomeCoAutores(String nomeCoAutor) {
        if (nomeCoAutor != null && !nomeCoAutor.isEmpty()) {
            this.nomeCoAutores.add(nomeCoAutor);
        }
    }

    public void setNomeOrientador(String nomeOrientador) {
        if (nomeOrientador != null && !nomeOrientador.isEmpty()) {
            this.nomeOrientador = nomeOrientador;
        } else {
            throw new IllegalArgumentException("Nome do co-autor não pode ser vazio");
        }

    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("Titulo não pode ser vazio");
        }
    }

    public void setResumo(String resumo) {
        if (resumo != null && !resumo.isEmpty()) {
            this.resumo = resumo;
        } else {
            throw new IllegalArgumentException("Resumo não pode ser vazio");
        }
    }

    public void setPalavrasChave(String palavrasChave) {
        if (palavrasChave != null && !palavrasChave.isEmpty()) {
            this.palavrasChave = palavrasChave;
        } else {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
    }

    public void setModalidade(Modalidade modalidade) throws ModalidadeInvalidaException {
        if (modalidade instanceof Modalidade) {
            this.modalidade = modalidade;
        } else {
            throw new ModalidadeInvalidaException();
        }
    }

    public void setTrilha(Trilha trilha) throws TrilhaInvalidaException {
        if (trilha instanceof Trilha) {
            this.trilha = trilha;
        } else {
            throw new TrilhaInvalidaException();
        }
    }

    //getters
    public String getNomeAutor() {
        return nomeAutor;
    }

    public int getQntCoAutores() {
        return qntCoAutores;
    }

    public ArrayList getNomeCoautores() {
        return nomeCoAutores;
    }

    public String getNomeOrientador() {
        return nomeOrientador;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public Trilha getTrilha() {
        return trilha;
    }
}
