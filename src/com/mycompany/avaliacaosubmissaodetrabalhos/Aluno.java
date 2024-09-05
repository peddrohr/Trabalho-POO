


package com.mycompany.avaliacaosubmissaodetrabalhos;


public class Aluno {
    //atributos
    private String nome;
    private int matriculaSigaa;
    private Trabalho trabalho;
    private Evento evento;
    private Usuario usuario;

    //construtores
    public Aluno(String nome, String email, int matriculasigaa) {
        this.usuario = new Usuario(nome, email);
        this.nome = nome;
        this.matriculaSigaa = matriculaSigaa <0 ? matriculaSigaa : 0; 
    }
    
    public Aluno(Usuario usuario, int matriculasigaa) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
        this.nome = usuario.getNome();
        this.matriculaSigaa = matriculasigaa != 0 ? matriculasigaa : 0; 
    }

    public Aluno() {
        this.usuario = new Usuario("", "");
        this.nome = "";
        this.matriculaSigaa = 0;
    }

    //get e set
    public Usuario getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
