package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

public class Dados {
    public static ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();
    public static ArrayList<Object> usuarios= new ArrayList<>();
    public static ArrayList<Evento> eventosCadastrados = new ArrayList<>();
    public static ArrayList<Trilha> trilhas = new ArrayList<>();
    public static ArrayList<CriterioAvaliacao> criterios = new ArrayList<>();

    public Dados(){
        carregarUsuarios();
        carregarEventos();
        carregarTrilha();
        carregarCriterios();
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

        Usuario avaliador = new Usuario("Avaliador teste", "132115131", "avaliadorteste@teste.com", "avaliador123");
        Professor avaliador1 = new Professor(avaliador, "151131");
        avaliador1.serAvaliador();
        usuariosCadastrados.add(avaliador);
        usuarios.add(avaliador1);
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
        Trilha trilha3 = new Trilha();
        trilha3.setNome("Banner");

        trilhas.add(trilha1);
        trilhas.add(trilha2);
        trilhas.add(trilha3);
    }

    public void carregarCriterios(){
        CriterioAvaliacao criterio1 = new CriterioAvaliacao("Criterio1", "Descricao1");
        CriterioAvaliacao criterio2 = new CriterioAvaliacao("Criterio2", "Descricao2");
        CriterioAvaliacao criterio3 = new CriterioAvaliacao("Criterio3", "Descricao3");
        CriterioAvaliacao criterio4 = new CriterioAvaliacao("Criterio4", "Descricao4");

        criterios.add(criterio1);
        criterios.add(criterio2);
        criterios.add(criterio3);
        criterios.add(criterio4);
    }
}
