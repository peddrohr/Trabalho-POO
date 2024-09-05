

package com.mycompany.avaliacaosubmissaodetrabalhos;


public class Professor {
    //atributos

    private String siape;
    private Usuario usuario;
    private String nome;
    private String email;

    //construtores
    public Professor(String nome, String email, String siape) {
        this.usuario = new Usuario(nome, email);
        this.nome = nome;
        this.siape = siape != null ? siape : ""; 
    }
    
    public Professor(Usuario usuario, String siape) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
        this.nome = usuario.getNome();
        this.siape = siape != null ? siape : ""; 
    }

    public Professor() {
        this.usuario = new Usuario("", "");
        this.nome = "";
        this.siape = "";
    }

    //get e set
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getSiape() {
        return siape;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setSiape(String siape) {
        if (siape != null && !siape.isEmpty()) {
            this.siape = siape;
        } else {
            throw new ExceptionInInitializerError("O email não pode ser vazio");
        }
    }
}
..