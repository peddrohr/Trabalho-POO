package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

//excecao caso uma trilha invalida seja inserida
public class TrilhaInvalidaException extends Exception{
    public String getMensagem(){
        String mensagem = "Por favor informe uma trilha valida";
        return mensagem;
    }
}
