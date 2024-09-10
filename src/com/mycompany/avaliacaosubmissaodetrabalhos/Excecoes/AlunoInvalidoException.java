package com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes;

//excecao caso um aluno invalido seja inserido 
public class AlunoInvalidoException extends Exception{
    public AlunoInvalidoException(){
        System.out.print("Aluno inválido, por favor tente novamente");
    }
}
