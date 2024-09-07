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
    private ObservableList<Trilha> ObsTrilhas;

    @FXML
    private ComboBox<Trilha> boxTrilha;

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
    void enviarTrabalho(ActionEvent event) {
        /**trabalho.setTitulo (fieldTitulo.getText());
        trabalho.setNomeOrientador(fieldOrientador.getText());
        trabalho.setPalavrasChave(fieldPalavrasChave.getText());
        trabalho.setResumo(fieldResumo.getText());
        trabalho.setNomeCoAutores(fieldCoAutores.getText());**/
    }

    void adicionarTextoLabel(Evento evento){
        nomeEvento.setText(evento.getNome());
        dataDeAbertura.setText(evento.getDataInicio());
        dataDeVencimento.setText(evento.getDataFim());
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

    public void carregarTrilha(){
        Trilha trilha1 = new Trilha();
        trilha1.setNome("Poster");
        Trilha trilha2 = new Trilha();
        trilha2.setNome("Pitch");

        trilhas.add(trilha1);
        trilhas.add(trilha2);

        ObsTrilhas = FXCollections.observableArrayList(trilhas);


        boxTrilha.setItems(ObsTrilhas);
    }

    @Override
    public String toString() {
        return ObsTrilhas.get(0).getNome();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarTrilha();
    }
}


