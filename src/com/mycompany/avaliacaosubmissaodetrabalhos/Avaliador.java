package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.SemTrabalhoDefinidoException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.UsuarioInvalidoException;

public class Avaliador {

   //atributos 
    private List<Trabalho> trabalhosAvaliados;
    private Professor professor;
    private String nome;
    private String email;

    //construtor
    public Avaliador(Professor professor) throws UsuarioInvalidoException{
        this.professor = professor;
        this.trabalhosAvaliados = new ArrayList<>();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
    }

    //adiciona um trabalho para ser avaliado na lista
    public void addTrabalhoAvaliado(Trabalho trabalhoAvaliado) throws SemTrabalhoDefinidoException{
        if(trabalhoAvaliado == null){
            throw new SemTrabalhoDefinidoException();
        }
        this.trabalhosAvaliados.add(trabalhoAvaliado);
    }
    
    //remove um trabalho para ser avaliado na lista
    public void removerTrabalhoAvaliado(Trabalho trabalhoAvalido) throws SemTrabalhoDefinidoException{
        if(trabalhoAvalido == null){
            throw new SemTrabalhoDefinidoException();
        }
        this.trabalhosAvaliados.remove(trabalhoAvalido);
}

    //getters
    //retorna uma cópia do arrayList com todos os trabalhos para serem avaliados.
    public List<Trabalho> getTrabalhosAvaliados() {
        return new ArrayList<>(trabalhosAvaliados);
    }

    public Professor getProfessor() {
        return professor;
    }
    
    public String getNome(){
        return nome;
    }

    public String getEmail() {
        return email;
    }
    
}
