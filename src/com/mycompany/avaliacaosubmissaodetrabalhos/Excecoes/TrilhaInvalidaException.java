package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

public class TrilhaInvalidaException extends Exception{
    public String getMensagem(){
        String mensagem = "Por favor informe uma trilha valida";
        return mensagem;
    }
}
