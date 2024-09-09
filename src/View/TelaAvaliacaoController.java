package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.NotaInvalidaException;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaAvaliacaoController implements Initializable {

    Model model = MainTelaLogin.model;

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

    void adicionarTextoLabel(){
        Trabalho trabalho = model.getTrabalho();
        Evento evento = model.getTrabalho().getEvento();

        nomeEvento.setText("Evento: " + evento.getNome());
        dataDeAbertura.setText("Inicio: " + evento.getDataInicio());
        dataDeVencimento.setText("Vencimento: " + evento.getDataFim());
        labelAutor.setText("Autor: " + trabalho.getNomeAutor());
        labelTitulo.setText("Titulo: " + trabalho.getTitulo());
        labelOrientador.setText("Orientador: " + trabalho.getNomeOrientador());
        labelTrilha.setText("Trilha: " +trabalho.getTrilha().getNome());
        labelResumo.setText("Resumo: " +trabalho.getResumo());
        labelChave.setText("Palavras chave: " +trabalho.getPalavrasChave());
        labelCriterio1.setText(Dados.criterios.get(0).getNome()+" "+Dados.criterios.get(0).getDescricao());
        labelCriterio2.setText(Dados.criterios.get(1).getNome()+" "+Dados.criterios.get(1).getDescricao());
        labelCriterio3.setText(Dados.criterios.get(2).getNome()+" "+Dados.criterios.get(2).getDescricao());
        labelCriterio4.setText(Dados.criterios.get(3).getNome()+" "+Dados.criterios.get(3).getDescricao());
    }

    @FXML
    void enviarAvaliacao(ActionEvent event) throws NotaInvalidaException {

        Trabalho trabalhoAvaliado = model.getTrabalho();

        Avaliacao avaliacao = new Avaliacao(trabalhoAvaliado);

        RadioButton selectedRadioButtonCriterio1 = (RadioButton) nota1.getSelectedToggle();
        float nota1 = Float.parseFloat(selectedRadioButtonCriterio1.getText());
        avaliacao.avaliarCriterio(Dados.criterios.getFirst(), nota1);

        RadioButton selectedRadioButtonCriterio2 = (RadioButton) nota2.getSelectedToggle();
        float nota2 = Float.parseFloat(selectedRadioButtonCriterio2.getText());
        avaliacao.avaliarCriterio(Dados.criterios.get(1), nota2);

        RadioButton selectedRadioButtonCriterio3 = (RadioButton) nota3.getSelectedToggle();
        float nota3 = Float.parseFloat(selectedRadioButtonCriterio3.getText());
        avaliacao.avaliarCriterio(Dados.criterios.get(2), nota3);

        RadioButton selectedRadioButtonCriterio4 = (RadioButton) nota4.getSelectedToggle();
        float nota4 = Float.parseFloat(selectedRadioButtonCriterio4.getText());
        avaliacao.avaliarCriterio(Dados.criterios.get(3), nota4);

        float notaFinal = avaliacao.calcularNotaFinal();

        trabalhoAvaliado.adicionarAvaliacao((Professor)model.getUsuarioLogadoTipado(), avaliacao);
        trabalhoAvaliado.notaFinal();

        avaliacao.setComentario(fieldComentario.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Envio");
        alert.setHeaderText("Trabalho avaliado com sucesso");
        alert.setContentText("" + trabalhoAvaliado.getNota());
        alert.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adicionarTextoLabel();
    }
}
