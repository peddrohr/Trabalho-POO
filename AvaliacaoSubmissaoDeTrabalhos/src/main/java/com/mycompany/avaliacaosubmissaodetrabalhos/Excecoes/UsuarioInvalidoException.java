package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

public class UsuarioInvalidoException extends Exception{
    public String getMensagem(){
        String mensagem = "Por favor selecione um usuario válido";
        return mensagem;
    }
}
