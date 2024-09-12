package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Evento;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Trabalho;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class TelaTrabalhoController {

    private Model model;
    private Stage view;

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
    void abrirTelaTrabalhosOrientados() throws IOException {
        TelaTrabalhosOrientadosView novaTela = new TelaTrabalhosOrientadosView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    private Menu menuInicio;

    @FXML
    private Menu menuPerfil;

    @FXML
    private Menu menuTrabalhosOrientados;


    @FXML
    void abrirTelaPerfil() throws IOException {
        TelaPerfilView novaTela = new TelaPerfilView();
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

