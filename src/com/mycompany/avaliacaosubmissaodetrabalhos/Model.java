package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;

import static com.mycompany.avaliacaosubmissaodetrabalhos.Dados.usuariosCadastrados;

public class Model {
    private Evento eventoSelecionado;
    private Object usuarioLogado;
    private ArrayList<Trabalho> trabalhos;

    public Model(){
        trabalhos = new ArrayList<>();
    }

    public void addTrabalho(Trabalho trabalho){
        if(trabalho != null){
            trabalhos.add(trabalho);
        }
    }

    public Trabalho getTrabalho(){
        if(trabalhos.size() != 0) {
            return trabalhos.getLast();
        }
        return null;
    }

    public Trabalho getTrabalho(String titulo){
        Trabalho trabalhoEncontrado = null;
        for(Trabalho trab: trabalhos){
            if(trab.getTitulo().equals(titulo)){
                trabalhoEncontrado = trab;
            }
        }
        return trabalhoEncontrado;
    }

    public void setEventoSelecionado(Evento eventoSelecionado) {
        if(eventoSelecionado != null && eventoSelecionado instanceof Evento) {
            this.eventoSelecionado = eventoSelecionado;
        }
    }

    public Evento getEventoSelecionado(){
        return eventoSelecionado;
    }

    public Object getUsuarioLogado(){
        return usuarioLogado;
    }

    public boolean AutenticarUsuario(String login, String senha){
        boolean usuarioValido = false;

        for (Object usuariosCadastrado : usuariosCadastrados) {
            Usuario usuario = (Usuario)usuariosCadastrado;
            if (login.equals(usuario.getNome()) && senha.equals(usuario.getSenha())) {
                System.out.println("usuario existe, pode entrar");
                usuarioValido = true;
                usuarioLogado = usuariosCadastrado;
            }
        }

        return usuarioValido;
    }

}
