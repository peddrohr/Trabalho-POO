package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

public class Dados {
    public static ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();
    public static ArrayList<Evento> eventosCadastrados = new ArrayList<>();

    public Dados(){
        carregarUsuarios();
        carregarEventos();
    }

    public void carregarUsuarios(){

        Usuario aluno = new Usuario("aluno teste", "123456789", "alunoteste@email.com","aluno123");
        usuariosCadastrados.add(aluno);

        Usuario professor = new Usuario("Professor teste", "123123123", "professorteste@gmail.com", "professor123");
        usuariosCadastrados.add(professor);

        Usuario servidor = new Usuario("Servidor teste", "789789789", "servidorteste@gmail.com", "servidor123");
        usuariosCadastrados.add(servidor);
    }

    public void carregarEventos(){
        Evento evento1 = new Evento("Encontros Universitarios", "07/09/2024","07/10/2024");
        eventosCadastrados.add(evento1);

        Evento evento2 = new Evento("Sescomp", "20/09/2024","20/10/2024");
        eventosCadastrados.add(evento2);
    }
}
