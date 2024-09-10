package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

//excecao para caso uma modalidade invalida seja inserida.
public class ModalidadeInvalidaException extends Exception{
    public String getMensagem(){
        String mensagem = "Por favor envie uma modalidade valida";
        return mensagem;
    }
}
