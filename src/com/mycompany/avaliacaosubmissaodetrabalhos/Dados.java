package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;
import java.util.Objects;

public class Dados {
    public static ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();
    public static ArrayList<Object> usuarios= new ArrayList<>();
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
        usuarios.add(aluno1);

        Usuario professor = new Usuario("professor teste", "123123123", "professorteste@gmail.com", "professor123");
        Professor professor1 = new Professor(professor, "0000010");
        usuariosCadastrados.add(professor);
        usuarios.add(professor1);

        Usuario servidor = new Usuario("servidor teste", "789789789", "servidorteste@gmail.com", "servidor123");
        Servidor servidor1 = new Servidor(servidor, "110000");
        usuariosCadastrados.add(servidor);
        usuarios.add(servidor1);
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
