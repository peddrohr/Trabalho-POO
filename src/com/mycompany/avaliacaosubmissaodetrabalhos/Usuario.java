package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

public final class Usuario {

    //atributos
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private ArrayList<Trabalho> trabalho = new ArrayList<>();

    //construtores
    public Usuario(String nome, String cpf, String email, String senha) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setEmail(email);
        this.setSenha(senha);
    }

    //setters
    public void setTrabalho(Trabalho trabalho) {
        if(trabalho != null) {
            this.trabalho.add(trabalho);
        }
    }
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome do usuario nao pode ser vazio");
        }
    }

    public void setCpf(String cpf) {
        if (cpf.matches("\\d{11}")) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("O cpf deve ter apenas 11 digitos e não pode ser vazio");
        }
    }

    // Regex para validar o formato do email para tratar letras, numeros, dominio, subdominio e sufixo

    public void setEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("O email nao pode ser vazio.");
        }

        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("O email deve seguir o formato padrão");
        }

        this.email = email;
    }


    public void setSenha(String senha) {
        if (senha != null && !senha.isEmpty()) {
            this.senha = senha;
        } else {
            throw new IllegalArgumentException("A senha nao pode ser vazia");
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

    public Trabalho getTrabalho(Evento evento) {
        for (Trabalho trabalho1 : trabalho) {
            if (trabalho1.getEvento().equals(evento)) {
                return trabalho1;
            }
        }
        return null;
    }

    public ArrayList<Trabalho> getTrabalhos() {
        return trabalho;
    }
}
