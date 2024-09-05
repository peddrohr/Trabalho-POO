package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

public class ModalidadeInvalidaException extends Exception{
    public String getMensagem(){
        String mensagem = "Por favor envie uma modalidade valida";
        return mensagem;
    }
}
