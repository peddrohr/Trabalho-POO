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
        labelCriterio1.setText(Dados.criterios.get(0).getNome()+" "+Dados.criterios.get(0).getDescricao());
        labelCriterio2.setText(Dados.criterios.get(1).getNome()+" "+Dados.criterios.get(1).getDescricao());
        labelCriterio3.setText(Dados.criterios.get(2).getNome()+" "+Dados.criterios.get(2).getDescricao());
        labelCriterio4.setText(Dados.criterios.get(3).getNome()+" "+Dados.criterios.get(3).getDescricao());
    }

    @FXML
    void enviarAvaliacao(ActionEvent event) throws NotaInvalidaException {

        Avaliacao avaliacao = new Avaliacao(model.getTrabalho());

        RadioButton selectedRadioButtonCriterio1 = (RadioButton) nota1.getSelectedToggle();
        String Snota1 = selectedRadioButtonCriterio1.getText();
        float nota1 = Float.parseFloat(Snota1);


        RadioButton selectedRadioButtonCriterio2 = (RadioButton) nota2.getSelectedToggle();
        String Snota2 = selectedRadioButtonCriterio2.getText();
        float nota2 = Float.parseFloat(Snota2);


        RadioButton selectedRadioButtonCriterio3 = (RadioButton) nota3.getSelectedToggle();
        String Snota3 = selectedRadioButtonCriterio3.getText();
        float nota3 = Float.parseFloat(Snota3);


        RadioButton selectedRadioButtonCriterio4 = (RadioButton) nota4.getSelectedToggle();
        String Snota4 = selectedRadioButtonCriterio4.getText();
        float nota4 = Float.parseFloat(Snota4);





        avaliacao.setComentario(fieldComentario.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Envio");
        alert.setHeaderText("Trabalho avaliado com sucesso");
        alert.setContentText(Dados.criterios.get(0).toString());
        alert.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adicionarTextoLabel();
    }
}
