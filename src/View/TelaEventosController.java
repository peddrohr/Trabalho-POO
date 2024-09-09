package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaEventosController implements Observer {
    private Model model;
    private Stage view;

    @FXML
    private AnchorPane anchorPanePai;

    @FXML
    private MenuBar barraMenu;

    @FXML
    private Button buttonEnviarTrabalho;

    @FXML
    private ComboBox<Evento> comboboxEventos;

    @FXML
    private GridPane dadosTrabalho;

    @FXML
    private Label labelCoAutores;

    @FXML
    private Label labelDataFim;

    @FXML
    private Label labelDatainicio;

    @FXML
    private Label labelEtapas;

    @FXML
    private Label labelNomeEvento;

    @FXML
    private Label labelOrientador;

    @FXML
    private Label labelPalavrasChave;

    @FXML
    private Label labelResumo;

    @FXML
    private Label labelTituloTrabalho;

    @FXML
    private Label mensagemTrabalho;

    @FXML
    private Menu menuAvaliarTrabalho;

    @FXML
    private Menu menuEventos;

    @FXML
    private Menu menuInicio;

    @FXML
    private Menu menuPerfil;

    @FXML
    private MenuItem menuTrabalho;

    @FXML
    private Menu menuTrabalhos;

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
    void abrirTelaInicial() throws IOException {
        TelaInicialView novaTela = new TelaInicialView();
        novaTela.iniciarTela(model, view);
    }

    void carregarEventos(){
        ObservableList<Evento> eventos = FXCollections.observableList(Dados.eventosCadastrados);
        comboboxEventos.setItems(eventos);
    }

    @FXML
    void carregarDadosEvento(){
        buttonEnviarTrabalho.setDisable(false);
        
        Evento evento = model.carregarDadosEvento(comboboxEventos.getSelectionModel().getSelectedItem());

        labelNomeEvento.setText(evento.getNome());
        labelDatainicio.setText(evento.getDataInicio());
        labelDataFim.setText(evento.getDataFim());
        labelEtapas.setText("Etapas");
        carregarDadosTrabalho();

    }

    @FXML
    void enviarTrabalho() throws IOException {
        abrirTelaEnvioTrabalho();
    }

    void carregarDadosTrabalho(){
        if(model != null){
            if (model.getTrabalho() != null && model.getTrabalho().getEvento() == model.getEventoSelecionado()) {
                dadosTrabalho.setVisible(true);
                mensagemTrabalho.setVisible(true);
                labelResumo.setVisible(true);
                buttonEnviarTrabalho.setDisable(true);

                Trabalho trabalho = model.getTrabalho();

                labelTituloTrabalho.setText(trabalho.getTitulo());
                labelCoAutores.setText(trabalho.getNomeCoautores());
                labelOrientador.setText(trabalho.getNomeOrientador());
                labelPalavrasChave.setText(trabalho.getPalavrasChave());
            } else {
                dadosTrabalho.setVisible(false);
                mensagemTrabalho.setVisible(false);
                labelResumo.setVisible(false);
                buttonEnviarTrabalho.setDisable(false);
            }
        }
    }

    public void initialize(Model model, Stage stage) {
        carregarEventos();
        carregarDadosTrabalho();

        this.model = model;
        this.view = stage;
    }

    @Override
    public void update() {

    }
}