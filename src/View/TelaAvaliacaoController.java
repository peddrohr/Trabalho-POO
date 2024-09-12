package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.NotaInvalidaException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.SemTrabalhoDefinidoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class TelaAvaliacaoController {

    private Model model;
    private Stage view;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button buttonEnviarAval;

    @FXML
    private RadioButton c1b1;

    @FXML
    private RadioButton c1b2;

    @FXML
    private RadioButton c1b3;

    @FXML
    private RadioButton c1b4;

    @FXML
    private RadioButton c1b5;

    @FXML
    private RadioButton c2b1;

    @FXML
    private RadioButton c2b2;

    @FXML
    private RadioButton c2b3;

    @FXML
    private RadioButton c2b4;

    @FXML
    private RadioButton c2b5;

    @FXML
    private RadioButton c3b1;

    @FXML
    private RadioButton c3b2;

    @FXML
    private RadioButton c3b3;

    @FXML
    private RadioButton c3b4;

    @FXML
    private RadioButton c3b5;

    @FXML
    private RadioButton c4b1;

    @FXML
    private RadioButton c4b2;

    @FXML
    private RadioButton c4b3;

    @FXML
    private RadioButton c4b4;

    @FXML
    private RadioButton c4b5;

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
    private ToggleGroup criterio1;

    @FXML
    private ToggleGroup criterio2;

    @FXML
    private ToggleGroup criterio3;

    @FXML
    private ToggleGroup criterio4;

    @FXML
    private MenuBar barraMenu;

    @FXML
    private ComboBox<Trabalho> comboBoxTrabalhosDisponiveis;

    @FXML
    private AnchorPane criterios;

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

    void carregarTrabalhos() {
        ArrayList<Trabalho> trabalhosDisponiveis = model.getTrabalhosDisponíveis();
        ObservableList<Trabalho> obsTrabalhosDisponiveis = FXCollections.observableList(trabalhosDisponiveis);
        comboBoxTrabalhosDisponiveis.setItems(obsTrabalhosDisponiveis);
    }

    @FXML
    void adicionarTextoLabel() {
        criterios.setDisable(false);

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

        if(!Objects.equals(fieldComentario.getText(), "")){
            RadioButton selectedRadioButtonCriterio1 = (RadioButton) criterio1.getSelectedToggle();
            float nota1 = Float.parseFloat(selectedRadioButtonCriterio1.getText());

            RadioButton selectedRadioButtonCriterio2 = (RadioButton) criterio2.getSelectedToggle();
            float nota2 = Float.parseFloat(selectedRadioButtonCriterio2.getText());

            RadioButton selectedRadioButtonCriterio3 = (RadioButton) criterio3.getSelectedToggle();
            float nota3 = Float.parseFloat(selectedRadioButtonCriterio3.getText());

            RadioButton selectedRadioButtonCriterio4 = (RadioButton) criterio4.getSelectedToggle();
            float nota4 = Float.parseFloat(selectedRadioButtonCriterio4.getText());

            model.enviarAvaliacao(nota1, nota2, nota3, nota4, fieldComentario.getText(), comboBoxTrabalhosDisponiveis.getValue().getNomeAutor());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Envio");
            alert.setHeaderText("Trabalho avaliado com sucesso");
            alert.setContentText("" /*trabalhoAvaliado.getNota()*/);
            alert.show();

            buttonEnviarAval.setDisable(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setHeaderText("A avaliação precisa ter um comentário");
            alert.setContentText("" /*trabalhoAvaliado.getNota()*/);
            alert.show();
        }
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
