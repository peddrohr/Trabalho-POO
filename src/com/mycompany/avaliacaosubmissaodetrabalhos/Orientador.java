package com.mycompany.avaliacaosubmissaodetrabalhos;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.AlunoInvalidoException;

public class Orientador {

    private Aluno alunoOrientado;
    private Professor professor;
    private String nome;
    private String email;

    public Orientador(Professor professor) {
        this.professor = professor;
        this.nome = professor.getNome();
        this.email = professor.getEmail();
    }

    public void setAlunoOrientado(Aluno alunoOrientado) throws AlunoInvalidoException {
        if (alunoOrientado != null && alunoOrientado instanceof Aluno) {
            this.alunoOrientado = alunoOrientado;
        } else {
            throw new AlunoInvalidoException();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Aluno getAlunoOrientado() {
        return alunoOrientado;
    }
}
