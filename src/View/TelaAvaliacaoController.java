package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.NotaInvalidaException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.SemTrabalhoDefinidoException;
import com.sun.tools.javac.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaAvaliacaoController {

    private Model model;
    private Stage view;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button buttonEnviarAval;

    @FXML
    private RadioButton b1;

    @FXML
    private RadioButton b2;

    @FXML
    private RadioButton b3;

    @FXML
    private RadioButton b4;

    @FXML
    private RadioButton b5;

    @FXML
    private Label dataDeAbertura;

    @FXML
    private Label dataDeVencimento;

    @FXML
    private TextArea fieldComentario;

    @FXML
    private Label labelAutor;

    @FXML
    private Label labelChave;

    @FXML
    private Label labelCriterio1;

    @FXML
    private Label labelCriterio2;

    @FXML
    private Label labelCriterio3;

    @FXML
    private Label labelCriterio4;

    @FXML
    private Label labelEnvio;

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
    private ToggleGroup nota1;

    @FXML
    private ToggleGroup nota2;

    @FXML
    private ToggleGroup nota3;

    @FXML
    private ToggleGroup nota4;

    @FXML
    private MenuBar barraMenu;

    @FXML
    private ComboBox<Trabalho> comboBoxTrabalhosDisponiveis;

    @FXML
    private Menu menuAvaliarTrabalho;

    @FXML
    private Menu menuTrabalhosOrientados;

    @FXML
    private Menu menuEventos;

    @FXML
    private Menu menuInicio;

    @FXML
    private Menu menuPerfil;

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
    void abrirTelaEnvioTrabalho() throws IOException {
        TelaEnvioTrabalhoView novaTela = new TelaEnvioTrabalhoView();
        novaTela.iniciarTela(model, view);
    }

    void carregarTrabalhos() {
        ArrayList<Trabalho> trabalhosDisponiveis = model.getTrabalhosDisponíveis();
        ObservableList<Trabalho> obsTrabalhosDisponiveis = FXCollections.observableList(trabalhosDisponiveis);
        comboBoxTrabalhosDisponiveis.setItems(obsTrabalhosDisponiveis);
    }

    @FXML
    void adicionarTextoLabel() {
        Trabalho trabalho = comboBoxTrabalhosDisponiveis.getValue();
        Evento evento = comboBoxTrabalhosDisponiveis.getValue().getEvento();

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
    }

    @FXML
    void enviarAvaliacao(ActionEvent event) throws NotaInvalidaException, SemTrabalhoDefinidoException {

        RadioButton selectedRadioButtonCriterio1 = (RadioButton) nota1.getSelectedToggle();
        float nota1 = Float.parseFloat(selectedRadioButtonCriterio1.getText());

        RadioButton selectedRadioButtonCriterio2 = (RadioButton) nota2.getSelectedToggle();
        float nota2 = Float.parseFloat(selectedRadioButtonCriterio2.getText());

        RadioButton selectedRadioButtonCriterio3 = (RadioButton) nota3.getSelectedToggle();
        float nota3 = Float.parseFloat(selectedRadioButtonCriterio3.getText());

        RadioButton selectedRadioButtonCriterio4 = (RadioButton) nota4.getSelectedToggle();
        float nota4 = Float.parseFloat(selectedRadioButtonCriterio4.getText());

        model.enviarAvaliacao(nota1, nota2, nota3, nota4, fieldComentario.getText(), comboBoxTrabalhosDisponiveis.getValue().getNomeAutor());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Envio");
        alert.setHeaderText("Trabalho avaliado com sucesso");
        alert.setContentText("" /*trabalhoAvaliado.getNota()*/);
        alert.show();

        buttonEnviarAval.setDisable(true);
    }


    public void initialize(Model model, Stage stage) {
        this.model = model;
        this.view = stage;

        if (model.verificarAvaliador()) {
            menuAvaliarTrabalho.setDisable(false);
            menuAvaliarTrabalho.setVisible(true);
        }
        if (model.verificarOrientador()) {
            menuTrabalhosOrientados.setDisable(false);
            menuTrabalhosOrientados.setVisible(true);
        }

        carregarTrabalhos();
    }
}
