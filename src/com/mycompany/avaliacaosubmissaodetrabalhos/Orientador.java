package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.AlunoInvalidoException;

public class Orientador {

    //atributos
    private List<Aluno> alunosOrientados;
    private Professor professor;
    private String nome;
    private String email;

    //construtor
    public Orientador(Professor professor) {
        this.professor = professor;
        this.alunosOrientados = new ArrayList<>();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
    }

    //adiciona um aluno no arrayList
    public void addAlunoOrientado(Aluno alunoOrientado) throws AlunoInvalidoException {
        if (alunoOrientado == null) {
            throw new AlunoInvalidoException();
        }
        this.alunosOrientados.add(alunoOrientado);
    }

    //remover aluno do arrayList
    public void removerAlunoOrientado(Aluno alunoOrientado) {
        this.alunosOrientados.remove(alunoOrientado);
    }

    //getters
    //retorna uma cópia do arrayList com todos os alunos orientados.
    public List<Aluno> getAlunosOrientados() {
        return new ArrayList<>(alunosOrientados);
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }


}
