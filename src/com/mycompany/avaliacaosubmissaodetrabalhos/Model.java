package com.mycompany.avaliacaosubmissaodetrabalhos;

import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.AlunoInvalidoException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.NotaInvalidaException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.SemTrabalhoDefinidoException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.TrilhaInvalidaException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static com.mycompany.avaliacaosubmissaodetrabalhos.Dados.*;

public class Model {
    private Evento eventoSelecionado;
    private Object usuarioLogado;
    private Object usuarioLogadoTipado;
    private String tipoUsuarioLogado;
    private ArrayList<Trabalho> trabalhosDisponiveis;
    private ArrayList<Trabalho> trabalhosEnviados;
    private Trabalho trabalhoSelecionado;

    public Model (){
        trabalhosDisponiveis = new ArrayList<>();
        trabalhosEnviados = new ArrayList<>();
    }


    public boolean validarAluno(String nomeAluno){
        for(Object user: usuarios){
            if(Aluno.class == user.getClass() && ((Aluno)user).getUsuario().getNome().equals(nomeAluno)){
                return true;
            }
        }
        return false;
    }

    private Trabalho getTrabalho(String nomeAutor){
        for(Trabalho trabalho:trabalhosDisponiveis){
            if(nomeAutor.equals(trabalho.getNomeAutor())){
                trabalhosDisponiveis.remove(trabalho);
                return trabalho;
            }
        }
        return null;
    }

    //TelaAvaliacao
    //retorna o trabalho enviado pelo aluno
    public Trabalho getTrabalhoEnviado(){
        if(tipoUsuarioLogado.equals("Aluno")) {
            return ((Aluno) usuarioLogadoTipado).getTrabalho(eventoSelecionado);
        } else {
            return ((Usuario)usuarioLogado).getTrabalho(eventoSelecionado);
        }
    }

    //retorna os trabalhos disponiveis para avaliar
    public ArrayList<Trabalho> getTrabalhosDisponíveis(){
        return trabalhosDisponiveis;
    }

    public Trabalho getTrabalhosDisponiveis(Evento evento){
        for(Trabalho trabalho : trabalhosEnviados){
            if(trabalho.getEvento().equals(evento)){
                return trabalho;
            }
        }
        return null;
    }

    public ArrayList<Trabalho> getTrabalhosEvento(Evento evento){
        ArrayList<Trabalho> trabalhos = new ArrayList<>();
        for(Trabalho trabalho : trabalhosEnviados){
            if(trabalho.getEvento().equals(evento)){
                trabalhos.add(trabalho);
            }
        }
        return trabalhos;
    }

    public void enviarAvaliacao(float nota1,float nota2,float nota3,float nota4, String comentario, String nomeAutor) throws SemTrabalhoDefinidoException, NotaInvalidaException {

        Trabalho trabalhoAvaliado = getTrabalho(nomeAutor);
        Avaliacao avaliacao = new Avaliacao(trabalhoAvaliado);
        float[] notas = {nota1, nota2, nota3, nota4};

        for(int i = 0; i < notas.length; i++) {
            avaliacao.avaliarCriterio(criterios.get(i), notas[i]);
        }

        avaliacao.calcularNotaFinal();

        assert trabalhoAvaliado != null;
        trabalhoAvaliado.adicionarAvaliacao(((Professor)usuarioLogadoTipado), avaliacao );
        trabalhoAvaliado.notaFinal();

    }

    //Viem Tela Inicial
    public AnchorPane AbrirTelaAvaliacao() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/TelaAvaliacao.fxml"));
    }

    public AnchorPane abrirTelaEventos() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/TelaEventos.fxml"));
    }

    public AnchorPane abrirTelaEnvioTrabalho() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/TelaEnvioTrabalho.fxml"));
    }

    public AnchorPane abrirTelaPerfil() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/TelaPerfil.fxml"));
    }

    public AnchorPane abrirTelaInicial() throws IOException {
        return (AnchorPane) FXMLLoader.load(getClass().getResource("/View/LayoutInicial.fxml"));
    }

    //Metodo para autenticar que tipo de usuario está logando e se é um usuario válido

    public boolean AutenticarUsuario(String login, String senha){
        boolean usuarioValido = false;

        for (Usuario usuariosCadastrado : usuariosCadastrados) {
            if (login.equals(usuariosCadastrado.getNome()) && senha.equals(usuariosCadastrado.getSenha())) {
                System.out.println("usuario existe, pode entrar");
                usuarioValido = true;
                usuarioLogado = usuariosCadastrado;
                for (Object user : usuarios) {
                    if (Aluno.class == user.getClass()) {
                        if (Objects.equals(((Aluno) user).getUsuario().getNome(), usuariosCadastrado.getNome())) {
                            tipoUsuarioLogado = "Aluno";
                            usuarioLogadoTipado = (Aluno) user;
                            break;
                        }
                    } else if (Servidor.class == user.getClass()) {
                        if (Objects.equals(((Servidor) user).getUsuario().getNome(), usuariosCadastrado.getNome())) {
                            tipoUsuarioLogado = "Servidor";
                            usuarioLogadoTipado = (Servidor) user;
                            break;
                        }
                    } else if (Professor.class == user.getClass()) {
                        if (Objects.equals(((Professor) user).getUsuario().getNome(), usuariosCadastrado.getNome())) {
                            tipoUsuarioLogado = "Professor";
                            usuarioLogadoTipado = (Professor) user;
                            break;
                        }
                    }
                }
                break;
            }
        }

        return usuarioValido;
    }

    //View Tela Eventos

    public Evento carregarDadosEvento(Evento evento){
        setEventoSelecionado(evento);

        return eventoSelecionado;
    }

    //View Tela Envio Trabalho

    public void enviarTrabalho(String titulo, String palavrasChave, String resumo, ArrayList<String> coAutores, String trilha, String nomeOrientador) throws TrilhaInvalidaException, AlunoInvalidoException {
        if(vericarOrientador(nomeOrientador) && tipoUsuarioLogado.equals("Aluno")){
            Professor orientador = getOrientador(nomeOrientador);
            Trilha trilhaTrabalho = getTrilha(trilha);
            Trabalho trabalho = new Trabalho(((Usuario) usuarioLogado).getNome(), orientador, titulo, resumo, palavrasChave, trilhaTrabalho);
            trabalho.setEvento(getEventoSelecionado());
            trabalho.setNomeAutor(((Usuario) getUsuarioLogado()).getNome());
            trabalho.setNomeCoAutores(coAutores);
            trabalho.formarCoAutores();
            ((Aluno)usuarioLogadoTipado).setTrabalho(trabalho);
            adicionarTrabalhoOrientador(nomeOrientador, trabalho);
            trabalho.setNomeCoAutores(new ArrayList<>());

            trabalhosDisponiveis.add(trabalho);
            trabalhosEnviados.add(trabalho);
        } else {
            Trilha trilhaTrabalho = getTrilha(trilha);
            Trabalho trabalho = new Trabalho(((Usuario) usuarioLogado).getNome(), titulo, resumo, palavrasChave, trilhaTrabalho);
            trabalho.setEvento(getEventoSelecionado());
            trabalho.setNomeAutor(((Usuario) getUsuarioLogado()).getNome());
            trabalho.setNomeCoAutores(coAutores);
            trabalho.formarCoAutores();
            ((Usuario)usuarioLogado).setTrabalho(trabalho);
            trabalho.setNomeCoAutores(new ArrayList<>());

            trabalhosDisponiveis.add(trabalho);
            trabalhosEnviados.add(trabalho);
        }
    }

    private void adicionarTrabalhoOrientador(String nomeOrientador, Trabalho trabalho) throws AlunoInvalidoException {
        for(Object user: usuarios){
            if(Professor.class == user.getClass() && ((Professor) user).getNome().equals(nomeOrientador)){
                ((Professor) user).addAlunoOrientado((Aluno)usuarioLogadoTipado);
            }
        }
    }

    //

    public FileChooser anexarArquivo(){
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (.pdf)", ".pdf");
        fileChooser.getExtensionFilters().add(extFilter);

        return fileChooser;
    }

    //View Tela Perfil
    public void desconectarUsuario(){
        usuarioLogado = null;
        usuarioLogadoTipado = null;
    }

    //View Tela Cadastro
    public void cadastrarUsuario(String tipoUsuario, String nome, String cpf,  String email, String senha, String matricula){
        Usuario usuario = new Usuario(nome, cpf, email, senha);
        switch (tipoUsuario){
            case "Professor":
                Professor professor = new Professor(usuario, matricula);
                usuariosCadastrados.add(usuario);
                usuarios.add(professor);
                usuarioLogado = usuario;
                usuarioLogadoTipado = professor;
                tipoUsuarioLogado = "Professor";
                break;

            case "Avaliador":
                Professor avaliador = new Professor(usuario, matricula);
                usuariosCadastrados.add(usuario);
                usuarios.add(avaliador);
                usuarioLogado = usuario;
                usuarioLogadoTipado = avaliador;
                avaliador.serAvaliador();
                tipoUsuarioLogado = "Professor";
                break;

            case "Orientador":
                Professor orientador = new Professor(usuario, matricula);
                usuariosCadastrados.add(usuario);
                usuarios.add(orientador);
                usuarioLogado = usuario;
                usuarioLogadoTipado = orientador;
                orientador.serOrientador();
                tipoUsuarioLogado = "Professor";
                break;

            case "Servidor":
                Servidor servidor = new Servidor(usuario, matricula);
                usuariosCadastrados.add(usuario);
                usuarios.add(servidor);
                usuarioLogado = usuario;
                usuarioLogadoTipado = servidor;
                tipoUsuarioLogado = "Servidor";
                break;

            case "Aluno":
                Aluno aluno = new Aluno(usuario, Integer.parseInt(matricula));
                usuariosCadastrados.add(usuario);
                usuarios.add(aluno);
                usuarioLogado = usuario;
                usuarioLogadoTipado = aluno;
                tipoUsuarioLogado = "Aluno";
                break;

            case "Avaliador e Orientador":
                Professor avaliadorOrientador = new Professor(usuario, matricula);
                usuariosCadastrados.add(usuario);
                usuarios.add(avaliadorOrientador);
                usuarioLogado = usuario;
                usuarioLogadoTipado = avaliadorOrientador;
                avaliadorOrientador.serOrientador();
                avaliadorOrientador.serAvaliador();
                tipoUsuarioLogado = "Professor";
                break;
        }
    }

    //Verificando se o usuario logado é Avaliador
    public boolean verificarAvaliador(){
        return tipoUsuarioLogado.equals("Professor") && ((Professor)usuarioLogadoTipado).getAvaliador();
    }

    public boolean verificarOrientador(){
        return tipoUsuarioLogado.equals("Professor") && ((Professor)usuarioLogadoTipado).getOrientador();
    }

    public Professor getOrientador(String nome){
        for(Object usuario : usuarios){
            if(Professor.class == usuario.getClass()){
                if(((Professor) usuario).getUsuario().getNome().equals(nome)){
                    return (Professor) usuario;
                }
            }
        }
        return null;
    }

    private void setEventoSelecionado(Evento eventoSelecionado) {
        if(eventoSelecionado != null) {
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

    public Trilha getTrilha(String nomeTrilha){
        Trilha trilhaSelecionada = new Trilha(nomeTrilha, "a");
        for(Trilha trilha : trilhas){
            if(Objects.equals(trilha.getNome(), nomeTrilha)){
                trilhaSelecionada = trilha;
                break;
            }
        }
        return trilhaSelecionada;
    }

    public boolean vericarOrientador(String nomeOrinetador) throws AlunoInvalidoException {
        boolean orientadorValido = false;
        for(Object usuario: usuarios){
            if(Professor.class == usuario.getClass()){
                if(((Professor) usuario).getOrientador()){
                    orientadorValido = true;
                }
            }
        }
        return orientadorValido;
    }

    public void setTrabalhoSelecionado(Trabalho trabalhoSelecionado) {
        this.trabalhoSelecionado = trabalhoSelecionado;
    }
    public Trabalho getTrabalhoSelecionado() {
        return trabalhoSelecionado;
    }
}
