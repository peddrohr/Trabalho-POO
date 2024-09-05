package com.mycompany.avaliacaosubmissaodetrabalhos;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.SemTrabalhoDefinidoException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.UsuarioInvalidoException;

public class Avaliador {

    private Trabalho trabalhoAvaliado;
    private Professor professor;
    private String nome;
    private String email;

    
    public Avaliador(Professor professor) throws UsuarioInvalidoException{
        this.professor = professor;
        this.nome = professor.getNome();
        this.email = professor.getEmail();
    }
    //setters
    public void setTrabalho(Trabalho trabalho) throws SemTrabalhoDefinidoException {
        if (trabalho != null && trabalho instanceof Trabalho) {
            this.trabalhoAvaliado = trabalho;
        } else {
            throw new SemTrabalhoDefinidoException();
        }
    }

    //getters
    public Professor getProfessor() {
        return professor;
    }
    
    public Trabalho getTrabalhoAvaliado(){
        return trabalhoAvaliado;
    }
    
    public String getNome(){
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
}
