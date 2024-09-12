
package com.mycompany.avaliacaosubmissaodetrabalhos;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Aluno {
    //atributos
    private int matriculaSigaa;
    private ArrayList<Trabalho> trabalho = new ArrayList<>();
    private Evento evento;
    private Usuario usuario;
    private float notaTrabalho;

    //construtores
    public Aluno(String nome, String cpf, String email, int matriculaSigaa, String senha) {
        setUsuario(new Usuario(nome, cpf, email, senha));
        setMatriculaSigaa(matriculaSigaa);
        setSenha(senha);
    }

    public Aluno(Usuario usuario, int matriculasigaa) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
        this.matriculaSigaa = matriculasigaa != 0 ? matriculasigaa : 0;
    }

    public Aluno() {
        this.usuario = new Usuario("", "", "", "");
        this.matriculaSigaa = 0;
    }

    //getters
    public String getTitulo(Trabalho trabalho) {
        for (Trabalho trabalho1 : this.trabalho) {
            if (trabalho1.equals(trabalho)) {
                return trabalho1.getTitulo();
            }
        }
        return null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNome() {
        return usuario.getNome();
    }

    public Evento getEvento() {
        return evento;
    }

    public int getMatriculaSigaa() {
        return matriculaSigaa;
    }

    public ArrayList<Trabalho> getTrabalhos() {
        return trabalho;
    }

    public Trabalho getTrabalho(Evento evento) {
        for (Trabalho trabalho1 : trabalho) {
            if (trabalho1.getEvento().equals(evento)) {
                return trabalho1;
            }
        }
        return null;
    }

    public Trabalho getTrabalhoOrientado(Professor orientador) {
        for (Trabalho trabalho1 : trabalho) {
            if (trabalho1.getNomeOrientador().equals(orientador.getUsuario().getNome()) && !orientador.getTrabalhosOrientados().contains(trabalho1)) {
                return trabalho1;
            }
        }
        return null;
    }

    public String getEmail() {
        return usuario.getEmail();
    }

    //setters

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setMatriculaSigaa(int matriculaSigaa) throws IllegalArgumentException {
        this.matriculaSigaa = matriculaSigaa;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho.add(trabalho);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEmail(String email) {
        this.usuario.setEmail(email);
    }

    public void setSenha(String senha) {
        usuario.setSenha(senha);
    }

    public void setNome(String nome) {
        usuario.setNome(nome);
    }

    public void setCpf(String cpf) {
        usuario.setCpf(cpf);
    }

    public String getNotaTrabalho(String titluo) {
        for (Trabalho trabalho1 : trabalho) {
            if (trabalho1.getTitulo().equals(titluo)) {
                return trabalho1.getNota();
            }
        }
        return null;
    }
}
