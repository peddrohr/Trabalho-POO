package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

//excecao para caso seja inserida uma nota invalida.
public class NotaInvalidaException extends Exception{
    public String getMenssagem(){
        String mensagem = "A nota deve ter um valor entre 0 e 5";
        return mensagem;
    }
}
