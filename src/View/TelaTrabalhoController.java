package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class TelaTrabalhoController {

    private Model model;
    private Stage view;

    @FXML
    private Label labelCriterio1;

    @FXML
    private Label labelCriterio2;

    @FXML
    private Label labelCriterio3;

    @FXML
    private Label labelCriterio4;

    @FXML
    private Label labelNotaC1;

    @FXML
    private Label labelNotaC2;

    @FXML
    private Label labelNotaC3;

    @FXML
    private Label labelNotaC4;

    @FXML
    private Label labelCoAutores;

    @FXML
    private Label dataDeAbertura;

    @FXML
    private Label dataDeVencimento;

    @FXML
    private Label labelAutor;

    @FXML
    private Label labelChave;

    @FXML
    private Label labelOrientador;

    @FXML
    private Label labelTitulo;

    @FXML
    private Label labelTrilha;

    @FXML
    private Label nomeEvento;

    @FXML
    private Label labelResumo;

    @FXML
    private Label nomeNota;

    @FXML
    private Menu menuAvaliarTrabalho;

    @FXML
    private Menu menuEventos;

    @FXML
    private Menu menuPerfil;

    @FXML
    private Menu menuTrabalhosOrientados;

    @FXML
    private Menu menuTrabalhosEnviados;

    @FXML
    void abrirTelaTrabalhosEnviados() throws IOException {
        TelaTrabalhosEnviadosView novaTela = new TelaTrabalhosEnviadosView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void AbrirTelaAvaliacao() throws IOException {
        TelaAvaliacaoView novaTela = new TelaAvaliacaoView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaEventos() throws IOException {
        TelaEventosView novaTela = new TelaEventosView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaEnvioTrabalho() throws IOException {
        TelaEnvioTrabalhoView novaTela = new TelaEnvioTrabalhoView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaPerfil() throws IOException {
        TelaPerfilView novaTela = new TelaPerfilView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaTrabalhosOrientados() throws IOException {
        TelaTrabalhosOrientadosView novaTela = new TelaTrabalhosOrientadosView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaInicial() throws IOException {
        TelaInicialView novaTela = new TelaInicialView();
        novaTela.iniciarTela(model, view);
    }


    @FXML
    void adicionarTextoLabel() {
        Trabalho trabalho = model.getTrabalhoSelecionado();
        Evento evento = trabalho.getEvento();

        nomeEvento.setText(evento.getNome());
        dataDeAbertura.setText("Inicio: " + evento.getDataInicio());
        dataDeVencimento.setText("Vencimento: " + evento.getDataFim());
        labelAutor.setText("Autor: " + trabalho.getNomeAutor());
        labelTitulo.setText("Titulo: " + trabalho.getTitulo());
        labelOrientador.setText("Orientador: " + trabalho.getNomeOrientador());
        labelTrilha.setText("Trilha: " + trabalho.getTrilha().getNome());
        labelResumo.setText("Resumo: " + trabalho.getResumo());
        labelChave.setText("Palavras chave: " + trabalho.getPalavrasChave());
        labelCriterio1.setText(Dados.criterios.get(0).getNome() + " " + Dados.criterios.get(0).getDescricao());
        labelCriterio2.setText(Dados.criterios.get(1).getNome() + " " + Dados.criterios.get(1).getDescricao());
        labelCriterio3.setText(Dados.criterios.get(2).getNome() + " " + Dados.criterios.get(2).getDescricao());
        labelCriterio4.setText(Dados.criterios.get(3).getNome() + " " + Dados.criterios.get(3).getDescricao());
        float notas[] = new float[4];
        int i = 0;
        for(var entry: trabalho.getAvaliacoes().entrySet()){
            for(var notaCrit: entry.getValue().getNotasPorCriterio().entrySet()){
                notas[i] = notaCrit.getValue();
                i++;
            }
            i = 0;
        }
        labelNotaC1.setText(""+notas[0]);
        labelNotaC2.setText(""+notas[1]);
        labelNotaC3.setText(""+notas[2]);
        labelNotaC4.setText(""+notas[3]);

        if(trabalho.getCoAutores() != "") {
            labelCoAutores.setText("Co autores: " + trabalho.getCoAutores());
        }

        if(trabalho.isAvaliado()){
            nomeNota.setVisible(true);
            nomeNota.setText("Nota: "+trabalho.getNota());
        }
    }


    public void initialize(Model model, Stage stage) {
        this.model = model;
        this.view = stage;

        adicionarTextoLabel();
        if (model.verificarAvaliador()) {
            menuAvaliarTrabalho.setDisable(false);
            menuAvaliarTrabalho.setVisible(true);
        }
        if (model.verificarOrientador()) {
            menuTrabalhosOrientados.setDisable(false);
            menuTrabalhosOrientados.setVisible(true);
        }
    }
}

