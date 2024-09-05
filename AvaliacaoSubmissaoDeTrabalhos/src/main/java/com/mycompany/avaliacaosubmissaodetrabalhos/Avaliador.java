package com.mycompany.avaliacaosubmissaodetrabalhos;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.*;

public class Avaliador {

    private Trabalho trabalhoAvaliado;
    private Usuario usuario;
    private String nome;
    private String email;

    
    public Avaliador(Usuario usuario) throws UsuarioInvalidoException{
        setUsuario(usuario);
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
    //setters
    private void setUsuario(Usuario usuario) throws UsuarioInvalidoException {
        if (usuario != null && usuario instanceof Usuario) {
            this.usuario = usuario;
        } else {
            throw new UsuarioInvalidoException();
        }
    }

    public void setTrabalho(Trabalho trabalho) throws SemTrabalhoDefinidoException {
        if (trabalho != null && trabalho instanceof Trabalho) {
            this.trabalhoAvaliado = trabalho;
        } else {
            throw new SemTrabalhoDefinidoException();
        }
    }

    //getters
    public Usuario getUsuario() {
        return usuario;
    }
    
    public Trabalho getTrabalhoAvaliado(){
        return trabalhoAvaliado;
    }
    
    public String getNome(){
        return nome;
    }
}
