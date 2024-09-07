package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Evento;
import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Trabalho;
import com.mycompany.avaliacaosubmissaodetrabalhos.Trilha;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

public class TelaEnvioTrabalhoController implements Initializable {
    private ObservableList<String> ObsTrilhasIndex; 

    @FXML
    private ComboBox<String> boxTrilha;

    private List<Trilha> trilhas = new ArrayList<>();

    @FXML
    private Button buttonEnviarTrab;

    @FXML
    private Button buttonEscolhaArquivo;

    @FXML
    private TextField fieldOrientador;

    @FXML
    private TextField fieldPalavrasChave;

    @FXML
    private TextArea fieldResumo;

    @FXML
    private TextField fieldTitulo;

    @FXML
    private TextField fieldCoAutores;

    @FXML
    private Label nomeEvento;

    @FXML
    private Label dataDeAbertura;

    @FXML
    private Label dataDeVencimento;

    @FXML
    private Label labelEnvio;

    @FXML
    void enviarTrabalho(ActionEvent event) {
        Trabalho trabalho1 = new Trabalho();
        trabalho1.setQntCoAutores(1);
        trabalho1.setTitulo (fieldTitulo.getText());
        trabalho1.setNomeOrientador(fieldOrientador.getText());
        trabalho1.setPalavrasChave(fieldPalavrasChave.getText());
        trabalho1.setResumo(fieldResumo.getText());
        trabalho1.setNomeCoAutores(fieldCoAutores.getText());
        labelEnvio.setText("Trabalho enviado com sucesso!");

    }

    void adicionarTextoLabel(){
        Evento evento = new Evento("Encontros", "26/02/25", "29/02/25");
        nomeEvento.setText("Evento: " + evento.getNome());
        dataDeAbertura.setText("Inicio: " + evento.getDataInicio());
        dataDeVencimento.setText("Vencimento: " + evento.getDataFim());
    }

    @FXML
    private void handleAnexarArquivo() {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (.pdf)", ".pdf");
        fileChooser.getExtensionFilters().add(extFilter);

        Stage stage = (Stage) buttonEscolhaArquivo.getScene().getWindow(); // Pega a Stage atual
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            System.out.println("Arquivo selecionado: " + file.getAbsolutePath());
        } else {
            System.out.println("Nenhum arquivo selecionado.");
        }
    }

    private ObservableList<String> getIndexList(List<Trilha> trilhas)
    {
        List<String> comboBoxList = new ArrayList<String>();

        for(Trilha trilha : trilhas)
            comboBoxList.add(trilha.getNome());

        return FXCollections.observableArrayList(comboBoxList);
    }

    public void carregarTrilha(){
        Trilha trilha1 = new Trilha();
        trilha1.setNome("Poster");
        Trilha trilha2 = new Trilha();
        trilha2.setNome("Pitch");

        trilhas.add(trilha1);
        trilhas.add(trilha2);

        ObsTrilhasIndex = getIndexList(trilhas);

        boxTrilha.setItems(ObsTrilhasIndex);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarTrilha();
        adicionarTextoLabel();
    }
}


