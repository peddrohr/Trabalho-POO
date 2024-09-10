package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

//excecao caso um aluno invalido seja inserido 
public class AlunoInvalidoException extends Exception{
    public String getMensagem(){
        String mensagem = "Aluno inválido, por favor tente novamente";
        return mensagem;
    }
    
}
