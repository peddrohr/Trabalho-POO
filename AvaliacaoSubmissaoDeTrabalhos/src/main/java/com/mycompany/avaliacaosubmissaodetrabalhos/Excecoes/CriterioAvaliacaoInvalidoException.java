package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

public class CriterioAvaliacaoInvalidoException extends Exception {

    public String getMensagem() {
        String mensagem = "Por favor informe um criterio de avaliacao valido";
        return mensagem;
    }
}
