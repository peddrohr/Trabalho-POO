package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

public class SemTrabalhoDefinidoException extends Exception{
    public String getMensagemErro(){
        String mensagem = "Nenhum Trabalho informado";
        return mensagem;
    }
}
