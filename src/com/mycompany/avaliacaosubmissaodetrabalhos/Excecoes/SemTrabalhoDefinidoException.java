package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

//excecao caso nenhum trabalho seja enviado
public class SemTrabalhoDefinidoException extends Exception{
    public String getMensagemErro(){
        String mensagem = "Nenhum Trabalho informado";
        return mensagem;
    }
}
