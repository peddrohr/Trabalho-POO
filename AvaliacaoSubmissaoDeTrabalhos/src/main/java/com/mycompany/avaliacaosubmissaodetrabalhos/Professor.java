

package com.mycompany.avaliacaosubmissaodetrabalhos;


public class Professor {
    //atributos

    private String siape;
    private Usuario usuario;

    

    //construtores
    public Professor(Usuario usuario){
        this.usuario = usuario;
    }

    public Professor(){

    }

    //get e set
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        if (siape != null && !siape.isEmpty()) {
            this.siape = siape;
        } else {
            throw new ExceptionInInitializerError("O email não pode ser vazio");
        }
    }
}
