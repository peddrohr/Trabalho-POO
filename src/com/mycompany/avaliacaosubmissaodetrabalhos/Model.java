package com.mycompany.avaliacaosubmissaodetrabalhos;

import static com.mycompany.avaliacaosubmissaodetrabalhos.Dados.usuariosCadastrados;
import View.*;

public class Model {
    public boolean AutenticarUsuario(String login, String senha){
        boolean usuarioValido = false;

        for (Usuario usuariosCadastrado : usuariosCadastrados) {
            if (login.equals(usuariosCadastrado.getNome()) && senha.equals(usuariosCadastrado.getSenha())) {
                System.out.println("usuario existe, pode entrar");
                usuarioValido = true;
            }
        }

        return usuarioValido;
    }

}
