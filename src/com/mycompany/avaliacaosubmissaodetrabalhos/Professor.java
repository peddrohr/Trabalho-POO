

package com.mycompany.avaliacaosubmissaodetrabalhos;


public class Professor{
    //atributos

    private String siape;
    private Usuario usuario;

    //construtores
    public Professor(String nome,String cpf, String email,String senha, String siape) {
        this.usuario = new Usuario(nome,cpf, email, senha);
        this.siape = siape != null ? siape : ""; 
    }
    
    public Professor(Usuario usuario, String siape) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
        this.siape = siape != null ? siape : ""; 
    }

    public Professor() {
        this.usuario = new Usuario("", "", "", "");
        this.siape = "";
    }

    //setters
    public void setUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
    }
    public void setEmail(String email){
        this.usuario.setEmail(email);
    }
    public void setSiape(String siape) {
        if (siape != null && !siape.isEmpty()) {
            this.siape = siape;
        } else {
            throw new ExceptionInInitializerError("O email não pode ser vazio");
        }
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

    public String getEmail() {
        return usuario.getEmail();
    }

    public String getNome() {
        return usuario.getNome();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getSiape() {
        return siape;
    }
   
    
}
