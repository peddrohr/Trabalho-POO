package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

public class NotaInvalidaException extends Exception{
    public String getMenssagem(){
        String mensagem = "A nota deve ter um valor entre 0 e 5";
        return mensagem;
    }
}
