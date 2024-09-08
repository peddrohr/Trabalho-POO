package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private Evento evento;
    private Map<Professor, Avaliacao> avaliacoes;
    private float nota;

    public Trabalho() {
    }

    public Trabalho(String nomeAutor, String nomeOrientador, String titulo, String resumo, String palavrasChave, Modalidade modalidade, Trilha trilha) {
        this.nomeAutor = nomeAutor;
        this.nomeOrientador = nomeOrientador;
        this.titulo = titulo;
        this.resumo = resumo;
        this.palavrasChave = palavrasChave;
        this.modalidade = modalidade;
        this.trilha = trilha;
    }

    public Trabalho(String nome){
        this.nomeAutor = nome;
    }

    //setters
    public void setEvento(Evento evento){
        if(evento != null){
            this.evento = evento;
        }
    }

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
            this.nomeCoAutores = new ArrayList<>(qntCoAutores);
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
    public Evento getEvento() {
        return evento;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public int getQntCoAutores() {
        return qntCoAutores;
    }

    public String getNomeCoautores() {
        String coAutores = "";
        for(String nomeCoAutor: nomeCoAutores){
            coAutores = coAutores + nomeCoAutor;
        }
        return coAutores;
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

    public Map<Professor, Avaliacao> getAvaliacoes() {
        return new HashMap<>(avaliacoes);
    }

     //adiciona uma avaliacao feita por um avaliador sobre o trabalho em um hashMap, passando o professor e a avaliacao feitas
    //por paramentro do metodo, vai ajudar a calcular a media final.
    public void AdicionarAvaliacao(Professor avaliador, Avaliacao avaliacao){
        if(avaliacoes.containsKey(avaliador)){
            throw new IllegalArgumentException();
        }
        if(avaliacoes.size()>=2){
            throw new IllegalArgumentException();
        }
        avaliacoes.put(avaliador, avaliacao);
    }

    public float NotaFinal(){
        if(avaliacoes.size()== 2){
            float somaNotas = 0;
            for(Avaliacao avaliacao: avaliacoes.values()){
                somaNotas += avaliacao.calcularNotaFinal();
            }
            this.nota = somaNotas/ 2;
            return this.nota;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public float getNota(){
        return nota;
    }
}
