package com.mycompany.avaliacaosubmissaodetrabalhos;

import java.util.ArrayList;
import java.util.Objects;

import static com.mycompany.avaliacaosubmissaodetrabalhos.Dados.usuarios;
import static com.mycompany.avaliacaosubmissaodetrabalhos.Dados.usuariosCadastrados;

public class Model {
    private Evento eventoSelecionado;
    private Object usuarioLogado;
    private Object usuarioLogadoTipado;
    private String tipoUsuarioLogado;
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

    public Object getUsuarioLogadoTipado(){
        return usuarioLogadoTipado;
    }

    public String getTipoUsuarioLogado(){
        return tipoUsuarioLogado;
    }

    public boolean AutenticarUsuario(String login, String senha){
        boolean usuarioValido = false;

        for (Usuario usuariosCadastrado : usuariosCadastrados) {
            if (login.equals(usuariosCadastrado.getNome()) && senha.equals(usuariosCadastrado.getSenha())) {
                System.out.println("usuario existe, pode entrar");
                usuarioValido = true;
                usuarioLogado = usuariosCadastrado;
                for(Object user: usuarios){
                    if(Aluno.class == user.getClass()){
                        if(Objects.equals(((Aluno) user).getUsuario().getNome(), usuariosCadastrado.getNome())){
                            tipoUsuarioLogado = "Aluno";
                            usuarioLogadoTipado = (Aluno)user;
                            break;
                        }
                    } else if(Servidor.class == user.getClass()){
                        if(Objects.equals(((Servidor) user).getUsuario().getNome(), usuariosCadastrado.getNome())){
                            tipoUsuarioLogado = "Servidor";
                            usuarioLogadoTipado = (Servidor)user;
                            break;
                        }
                    } else if(Professor.class == user.getClass()){
                        if(Objects.equals(((Professor) user).getUsuario().getNome(), usuariosCadastrado.getNome())){
                            tipoUsuarioLogado = "Professor";
                            usuarioLogadoTipado = (Professor)user;
                            break;
                        }
                    }
                }
            }
        }

        return usuarioValido;
    }

}
