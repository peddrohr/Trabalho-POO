


package com.mycompany.avaliacaosubmissaodetrabalhos;


public class Aluno {
    //atributos
    private int matriculaSigaa;
    private Trabalho trabalho;
    private Evento evento;
    private Usuario usuario;

    //construtores
    public Aluno(int matriculaSigaa, Trabalho trabalho, Evento evento, Usuario usuario){
        this.matriculaSigaa = matriculaSigaa;
        this.trabalho = trabalho;
        this.evento = evento;
        this.usuario = usuario;
    }

    public Aluno(){
    }

    //get e set
    public Usuario getUsuario() {
        return usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public int getMatriculaSigaa() {
        return matriculaSigaa;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setMatriculaSigaa(int matriculaSigaa) {
        this.matriculaSigaa = matriculaSigaa;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
