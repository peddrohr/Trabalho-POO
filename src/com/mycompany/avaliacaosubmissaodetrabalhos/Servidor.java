
package com.mycompany.avaliacaosubmissaodetrabalhos;


public final class Servidor{
    
    //atributos
    private String matricula;
    private Usuario usuario;
    private String nome;

    //construtores
    public Servidor(String nome, String email, String matricula) {
        this.usuario = new Usuario(nome, email);
        this.nome = nome;
        this.matricula = matricula != null ? matricula : ""; 
    }
    
    public Servidor(Usuario usuario, String matricula) {
        this.usuario = usuario;
        this.nome = usuario.getNome();
        this.matricula = matricula; 
    }

    public Servidor() {
        this.usuario = new Usuario("", "");
        this.nome = "";
        this.matricula = "";
    }
    //get e set
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNomeServidor() {
        return nome;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}