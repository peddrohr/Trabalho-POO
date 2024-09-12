package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

public class Dados {

    //atributos
    public static ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();
    public static ArrayList<Object> usuarios = new ArrayList<>();
    public static ArrayList<Evento> eventosCadastrados = new ArrayList<>();
    public static ArrayList<Trilha> trilhas = new ArrayList<>();
    public static ArrayList<CriterioAvaliacao> criterios = new ArrayList<>();

    //construtor
    public Dados() {
        carregarUsuarios();
        carregarEventos();
        carregarTrilha();
        carregarCriterios();
    }

    String[] nomes = {
            "Ana Silva", "Carlos Souza", "Bianca Costa", "Daniel Ribeiro", "Eduarda Lima",
            "Fernando Carvalho", "Gabriela Martins", "Hugo Almeida", "Isabela Mendes", "João Ferreira",
            "Karen Barbosa", "Lucas Oliveira", "Marina Farias", "Natan Pereira", "Olivia Santos",
            "Pedro Rocha", "Quésia Teixeira", "Rafael Araújo", "Sara Antunes", "Tiago Nunes",
            "Ursula Braga", "Vinícius Matos", "Wesley Batista", "Ximena Queiroz", "Yuri Gonçalves",
            "Zilda Soares", "Arthur Reis", "Beatriz Alves", "Caio Machado", "Denise Pires",
            "Enzo Menezes", "Flávia Torres", "Gustavo Ramos", "Helena Duarte", "Igor Neves",
            "Julia Souza", "Kevin Silva", "Larissa Gomes", "Matheus Lima", "Nina Fonseca",
            "Otávio Nogueira", "Paula Correia", "Rodrigo Barros", "Simone Monteiro", "Tadeu Mendes",
            "Vera Guimarães", "William Castro", "Yasmin Coelho", "Zeca Moraes", "Lúcia Rocha"
    };

    //Carregamento prévio de usuarios e de tipos diferentes de usuarios

    public void carregarUsuarios() {

        Usuario aluno = new Usuario("aluno teste", "11111111111", "alunoteste@email.com", "aluno123");
        Aluno aluno1 = new Aluno(aluno, 100000);
        usuariosCadastrados.add(aluno);
        usuarios.add(aluno1);

        Usuario professor = new Usuario("professor teste", "22222222222", "professorteste@gmail.com", "professor123");
        Professor professor1 = new Professor(professor, "0000010");
        usuariosCadastrados.add(professor);
        usuarios.add(professor1);

        Usuario servidor = new Usuario("servidor teste", "33333333333", "servidorteste@gmail.com", "servidor123");
        Servidor servidor1 = new Servidor(servidor, "110000");
        usuariosCadastrados.add(servidor);
        usuarios.add(servidor1);

        Usuario avaliador = new Usuario("avaliador teste", "44444444444", "avaliadorteste@teste.com", "avaliador123");
        Professor avaliador1 = new Professor(avaliador, "151131");
        avaliador1.serAvaliador();
        usuariosCadastrados.add(avaliador);
        usuarios.add(avaliador1);

        Usuario orientador = new Usuario("orientador teste", "55555555555", "orientadorteste@teste.com", "orientador123");
        Professor orientador1 = new Professor(orientador, "151131");
        orientador1.serOrientador();
        usuariosCadastrados.add(orientador);
        usuarios.add(orientador1);

        for (int i = 0; i < 50; i++) {
            // Gerar dados variáveis
            String cpf = "12312312312";
            String email = "teste" + i + "@email.com";
            String senha = "senha" + (i + 1);

            Usuario usuario = new Usuario(nomes[i], cpf, email, senha);
            usuariosCadastrados.add(usuario);

            if (i < 9) { // 9 Professores
                Professor professor5 = new Professor(usuario, "SIAPE" + (200 + i));
                usuarios.add(professor5);
            } else if (i < 17) { // 8 Alunos
                Aluno aluno5 = new Aluno(usuario, 3000 + i);
                usuarios.add(aluno5);
            } else if (i < 25) { // 8 Servidores
                Servidor servidor5 = new Servidor(usuario, "Matricula" + (4000 + i));
                usuarios.add(servidor5);
            } else if (i < 37) { //12 Avaliadores
                Professor professor5 = new Professor(usuario, "SIAPE" + (200 + i));
                professor5.serAvaliador();
                usuarios.add(professor5);
            } else { //1 Orientadores
                Professor professor5 = new Professor(usuario, "SIAPE" + (200 + i));
                professor5.serOrientador();
                usuarios.add(professor5);
            }

        }
    }

    //Carregamento prévio de eventos

    public void carregarEventos() {
        Evento evento1 = new Evento("Encontros Universitarios", "07/09/2024", "07/10/2024");
        eventosCadastrados.add(evento1);

        Evento evento2 = new Evento("Sescomp", "20/09/2024", "20/10/2024");
        eventosCadastrados.add(evento2);

        Evento evento3 = new Evento("XX Congresso tal", "20/09/2024", "20/10/2024");
        eventosCadastrados.add(evento3);

        Evento evento4 = new Evento("Conferência estudantil", "20/09/2024", "20/10/2024");
        eventosCadastrados.add(evento4);

        Evento evento5 = new Evento("IV Simpósio tal", "20/09/2024", "20/10/2024");
        eventosCadastrados.add(evento5);
    }

    //Carregamento prévio de trilhas

    public void carregarTrilha() {
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

    //Carregamento prévio de criterios de avaliação

    public void carregarCriterios() {
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
