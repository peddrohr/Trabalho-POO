package com.mycompany.avaliacaosubmissaodetrabalhos;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.*;

public class Orientador {

    private Aluno alunoOrientado;
    private Usuario usuario;
    private String nome;
    private String email;

    public Orientador(Usuario usuario) {
        setNome(usuario.getNome());
        setEmail(usuario.getEmail());
    }

    private void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new ExceptionInInitializerError("O nome não pode ser vazio");
        }
    }

    private void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        } else {
            throw new ExceptionInInitializerError("O email não pode ser vazio");
        }
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
