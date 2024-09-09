package com.mycompany.avaliacaosubmissaodetrabalhos;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static com.mycompany.avaliacaosubmissaodetrabalhos.Dados.*;

public class Model {
    private Evento eventoSelecionado;
    private Object usuarioLogado;
    private Object usuarioLogadoTipado;
    private String tipoUsuarioLogado;
    private ArrayList<Trabalho> trabalhos;

    public Model(){
        trabalhos = new ArrayList<>();
    }

    public AnchorPane AbrirTelaAvaliacao() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/TelaAvaliacao.fxml"));
    }

    public AnchorPane abrirTelaEventos() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/TelaEventos.fxml"));
    }

    public AnchorPane abrirTelaEnvioTrabalho() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/TelaAvaliacao.fxml"));
    }

    public AnchorPane abrirTelaPerfil() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/TelaPerfil.fxml"));
    }

    public AnchorPane abrirTelaInicial() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/LayoutInicial.fxml"));
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

    public Trilha getTrilha(String nomeTrilha){
        Trilha trilhaSelecionada = new Trilha();
        for(Trilha trilha : trilhas){
            if(trilha.getNome() == nomeTrilha){
                trilhaSelecionada = trilha;
            }
        }
        return trilhaSelecionada;
    }

    public boolean vericarOrientador(String nomeOrinetador){
        boolean orientadorValido = false;
        for(Object usuario: usuarios){
            if(Professor.class == usuario.getClass()){
                if(((Professor) usuario).getNome().equals(nomeOrinetador)){
                    orientadorValido = true;
                }
            }
        }
        return orientadorValido;
    }

}
