package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

//excecao para caso um usuario inserido seja invalido.
public class UsuarioInvalidoException extends Exception{
    public String getMensagem(){
        String mensagem = "Por favor selecione um usuario válido";
        return mensagem;
    }
}
