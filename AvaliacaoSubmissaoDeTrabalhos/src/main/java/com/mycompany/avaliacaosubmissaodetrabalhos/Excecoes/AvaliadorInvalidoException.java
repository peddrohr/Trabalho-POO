package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

public class AvaliadorInvalidoException extends Exception{
     public String getMensagem(){
         String mensagem = "Por favor informe um avaliador";
         return mensagem;
     }
}
