package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.ModalidadeInvalidaException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.TrilhaInvalidaException;

public class Trabalho {

    Model model = new Model();

    //atributos
    private String nomeAutor;
    private int qntCoAutores;
    private ArrayList<String> nomeCoAutores = new ArrayList<>();
    private String coAutores = "";
    private Professor orientador;
    private String titulo;
    private String resumo;
    private String palavrasChave;
    private Modalidade modalidade;
    private String nomeTrilha;
    private String nomeEvento;
    private Trilha trilha;
    private Evento evento;
    private Map<Professor, Avaliacao> avaliacoes = new HashMap<>();
    private float nota;
    private boolean avaliado;

    //construtores
    public Trabalho() {
    }

    public Trabalho(String nomeAutor, Professor orientador, String titulo, String resumo, String palavrasChave,  Trilha trilha) throws TrilhaInvalidaException {
        this.setNomeAutor(nomeAutor);
        this.setOrientador(orientador);
        this.setTitulo(titulo);
        this.setResumo(resumo);
        this.setPalavrasChave(palavrasChave);
        this.setTrilha(trilha);
    }

    public Trabalho(String nome){
        this.nomeAutor = nome;
    }

    //setters
    public void setEvento(Evento evento){
        if(evento != null){
            this.evento = evento;
            this.nomeEvento = evento.getNome();
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

    public void setNomeCoAutores(ArrayList<String> coAutoresarr) {
        for(String coAutor: coAutoresarr){
            if (coAutor != null && !coAutor.isEmpty() && model.validarAluno(coAutor)) {

                this.nomeCoAutores.add(coAutor);
            }
        }
    }

    public void setOrientador(Professor orientador) {
        if (orientador != null) {
            this.orientador = orientador;
        } else {
            throw new IllegalArgumentException("Nome do orientador não pode ser vazio");
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
        if (trilha != null) {
            this.trilha = trilha;
            this.nomeTrilha = trilha.getNome();
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

    //formar String de coAutores
    public String formarCoAutores() {
        for(String nomeCoAutor: nomeCoAutores){
            coAutores = coAutores + nomeCoAutor+ ", ";
        }
        return coAutores;
    }

    public String getCoAutores(){
        return coAutores;
    }

    public String getNomeOrientador() {
        return orientador.getNome();
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

    public String getNomeTrilha(){ return nomeTrilha; }

    public String getNomeEvento(){ return nomeEvento; }

    public Map<Professor, Avaliacao> getAvaliacoes() {
        return new HashMap<>(avaliacoes);
    }

    public float getNota(){
        return nota;
    }

    public boolean isAvaliado() {return avaliado;}

     //adiciona uma avaliacao feita por um avaliador sobre o trabalho em um hashMap, passando o professor e a avaliacao feitas
    //por paramentro do metodo, vai ajudar a calcular a media final.

    public void adicionarAvaliacao(Professor avaliador, Avaliacao avaliacao){
        if(avaliacoes.containsKey(avaliador)){
            throw new IllegalArgumentException();
        }
        if(avaliacoes.size()>=2){
            throw new IllegalArgumentException();
        }
        avaliacoes.put(avaliador, avaliacao);
        avaliado = true;
    }

    //metodo que calcula a nota final do trabalho;
    public void notaFinal(){
        if(avaliacoes.size() <= 2){
            float somaNotas = 0;
            for(Avaliacao avaliacao: avaliacoes.values()){
                somaNotas += avaliacao.calcularNotaFinal();
            }
            nota = somaNotas/ avaliacoes.size();
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString(){
        return getTitulo();
    }

}
