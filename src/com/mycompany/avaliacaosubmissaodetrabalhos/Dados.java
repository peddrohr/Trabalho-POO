package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

public class Dados {
    public static ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();

    public ArrayList<Usuario> darCarga(){

        Usuario aluno = new Usuario("aluno teste", "123456789", "alunoteste@email.com","aluno123");
        usuariosCadastrados.add(aluno);

        Usuario professor = new Usuario("Professor teste", "123123123", "professorteste@gmail.com", "professor123");
        usuariosCadastrados.add(professor);

        Usuario servidor = new Usuario("Servidor teste", "789789789", "servidorteste@gmail.com", "servidor123");
        usuariosCadastrados.add(servidor);

        return usuariosCadastrados;
    }
}
