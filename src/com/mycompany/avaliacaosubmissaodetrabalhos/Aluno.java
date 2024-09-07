
package com.mycompany.avaliacaosubmissaodetrabalhos;


public class Aluno {
    //atributos
    private int matriculaSigaa;
    private Trabalho trabalho;
    private Evento evento;
    private Usuario usuario;

    //construtores
    public Aluno(String nome,String cpf, String email, int matriculaSigaa, String senha ) {
        this.usuario = new Usuario(nome,cpf, email, senha);
        this.matriculaSigaa = matriculaSigaa <0 ? matriculaSigaa : 0; 
    }
    
    public Aluno(Usuario usuario, int matriculasigaa) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        this.usuario = usuario;
        this.matriculaSigaa = matriculasigaa != 0 ? matriculasigaa : 0; 
    }

    public Aluno() {
        this.usuario = new Usuario("", "", "", "");
        this.matriculaSigaa = 0;
    }

    //getters
    public String getTitulo(){
        return trabalho.getTitulo();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNome() {
        return usuario.getNome();
    }

    public Evento getEvento() {
        return evento;
    }

    public int getMatriculaSigaa() {
        return matriculaSigaa;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public String getEmail(){
        return usuario.getEmail();
    }   
    
    //setters

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public void setMatriculaSigaa(int matriculaSigaa) {
        this.matriculaSigaa = matriculaSigaa;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
}
