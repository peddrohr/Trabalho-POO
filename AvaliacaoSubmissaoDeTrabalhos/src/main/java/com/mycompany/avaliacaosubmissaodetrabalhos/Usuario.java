package com.mycompany.avaliacaosubmissaodetrabalhos;

public class Usuario {

    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public Usuario(String nome) {
        setNome(nome);
    }

    public Usuario(String nome, String email ){
        this.nome = nome;
        this.email = email;
    }

    //setters
    private void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new ExceptionInInitializerError("O nome do ususario não pode ser vazio");
        }
    }

    public void setCpf(String cpf) {
        if (cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            throw new ExceptionInInitializerError("O cpf deve ter apenas 11 digitos");
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        } else {
            throw new ExceptionInInitializerError("Por favor preencha o campo de email");
        }
    }

    public void setSenha(String senha) {
        if (senha != null && !senha.isEmpty()) {
            this.senha = senha;
        } else {
            throw new ExceptionInInitializerError("Por favor preencha o campo de email");
        }
    }

    //getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
}
