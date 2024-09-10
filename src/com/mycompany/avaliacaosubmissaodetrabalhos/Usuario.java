package com.mycompany.avaliacaosubmissaodetrabalhos;

public final class Usuario {

    //atributos
    private String nome;
    private String cpf;
    private String email;
    private String senha;

    //construtores
    public Usuario(String nome, String cpf, String email, String senha){
        this.setNome(nome);
        this.setCpf(cpf);
        this.setEmail(email);
        this.setSenha(senha);
    }

    //setters
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new ExceptionInInitializerError("O nome do usuario nao pode ser vazio");
        }
    }

    public void setCpf(String cpf) {
        if (cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        } else {
            throw new ExceptionInInitializerError("O cpf deve ter apenas 11 digitos");
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        } else {
            throw new ExceptionInInitializerError("O email nao pode ser vazio");
        }
    }

    public void setSenha(String senha) {
        if (senha != null && !senha.isEmpty()) {
            this.senha = senha;
        } else {
            throw new ExceptionInInitializerError("A senha nao pode ser vazia");
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
