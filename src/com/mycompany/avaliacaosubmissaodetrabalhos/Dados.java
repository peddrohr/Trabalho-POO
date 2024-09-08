package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

public class Dados {
    public static ArrayList<Object> usuariosCadastrados = new ArrayList<>();
    public static ArrayList<Evento> eventosCadastrados = new ArrayList<>();
    public static ArrayList<Trilha> trilhas = new ArrayList<>();

    public Dados(){
        carregarUsuarios();
        carregarEventos();
        carregarTrilha();
    }

    public void carregarUsuarios(){

        Usuario aluno = new Usuario("aluno teste", "123456789", "alunoteste@email.com","aluno123");
        Aluno aluno1 = new Aluno(aluno, 100000);
        usuariosCadastrados.add(aluno);

        Usuario professor = new Usuario("Professor teste", "123123123", "professorteste@gmail.com", "professor123");
        Professor professor1 = new Professor(professor, "000001");
        usuariosCadastrados.add(professor);

        Usuario servidor = new Usuario("Servidor teste", "789789789", "servidorteste@gmail.com", "servidor123");
        Servidor servidor1 = new Servidor(servidor, "110000");
        usuariosCadastrados.add(servidor);
    }

    public void carregarEventos(){
        Evento evento1 = new Evento("Encontros Universitarios", "07/09/2024","07/10/2024");
        eventosCadastrados.add(evento1);

        Evento evento2 = new Evento("Sescomp", "20/09/2024","20/10/2024");
        eventosCadastrados.add(evento2);
    }

    public void carregarTrilha(){
        Trilha trilha1 = new Trilha();
        trilha1.setNome("Poster");
        Trilha trilha2 = new Trilha();
        trilha2.setNome("Pitch");

        trilhas.add(trilha1);
        trilhas.add(trilha2);
    }
}
