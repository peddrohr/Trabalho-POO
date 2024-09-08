package com.mycompany.avaliacaosubmissaodetrabalhos;

public class Servidor{
    
    //atributos

    private String matricula;
    private Usuario usuario;

    //construtores
    public Servidor(String nome,String cpf, String email, String matricula, String senha ) {
        this.usuario = new Usuario(nome,cpf, email, senha);
        this.matricula = matricula != null ? matricula : ""; 
    }
    
    public Servidor(Usuario usuario, String matricula) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
        this.matricula = matricula; 
    }

    public Servidor() {
        this.usuario = new Usuario("", "", "", "");
        this.matricula = "";
    }
    //get e set

    public void setUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEmail(String email) {
        this.usuario.setEmail(email);
    }

    public void setSenha(String senha){
        usuario.setSenha(senha);
    }

    public void setNome(String nome){
        usuario.setNome(nome);
    }

    public void setCpf(String cpf){
        usuario.setCpf(cpf);
    }

    //getters  
    public String getNome() {
        return usuario.getNome();
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public String getMatricula() {
        return matricula;
    }
    
    public String getEmail() {
        return usuario.getEmail();
    }
}