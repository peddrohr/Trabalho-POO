package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaAvaliacaoController implements Initializable {



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
    private ToggleGroup nota1;

    @FXML
    private ToggleGroup nota2;

    @FXML
    private ToggleGroup nota3;

    @FXML
    private ToggleGroup nota4;

    void adicionarTextoLabel(){
        Evento evento = new Evento("Encontros", "26/02/2025", "29/02/2025");
        Modalidade modalidade = new Modalidade("Pitch", "Descricao Pitch");
        Trilha trilha = new Trilha("BIA", "Descricao BIA");
        Trabalho trabalho = new Trabalho("Victor Carvalho", "Marcos Vinicius", "POO", "Resumo", "Programacao, Orientado a Objeto", modalidade, trilha);
        nomeEvento.setText("Evento: " + evento.getNome());
        dataDeAbertura.setText("Inicio: " + evento.getDataInicio());
        dataDeVencimento.setText("Vencimento: " + evento.getDataFim());
        labelAutor.setText("Autor: " + trabalho.getNomeAutor());
        labelTitulo.setText("Titulo: " + trabalho.getTitulo());
        labelOrientador.setText("Orientador: " + trabalho.getNomeOrientador());
        labelTrilha.setText("Trilha: " +trabalho.getTrilha().getNome());
        labelResumo.setText("Resumo: " +trabalho.getResumo());
        labelChave.setText("Palavras chave: " +trabalho.getPalavrasChave());
    }

    @FXML
    void enviarAvaliacao(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adicionarTextoLabel();
    }
}
