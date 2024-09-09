package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.TrilhaInvalidaException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

public class TelaEnvioTrabalhoController implements Initializable {
    private ObservableList<String> ObsTrilhasIndex;
    private Model model = MainTelaLogin.model;

    @FXML
    private ComboBox<String> boxTrilha;

    @FXML
    private AnchorPane anchorPane;

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
    void enviarTrabalho(ActionEvent event) throws IOException, TrilhaInvalidaException {
        String nomeOrientador = "";
        if(model.vericarOrientador(fieldOrientador.getText()) && boxTrilha.getSelectionModel().getSelectedItem() != null){
             nomeOrientador = fieldOrientador.getText();

            labelEnvio.setText("Trabalho enviado por: " + model.getTrabalho().getNomeAutor());
            AnchorPane a = FXMLLoader.load(getClass().getResource("LayoutInicial.fxml"));
            anchorPane.getChildren().setAll(a);
            anchorPane.setVisible(true);
            anchorPane.setDisable(false);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Envio");
            alert.setHeaderText("Trabalho enviado com sucesso");
            alert.setContentText("Acompanhe o resumo e outras informações no sistema");
            alert.show();
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Orientador ou Trilha inválida");
            alert.setHeaderText("Orientador ou Trilha informada inválida");
            alert.setContentText("Digite um nome válido ou selecione uma trilha válida por favor");
            alert.show();
        }

        String titulo = fieldTitulo.getText();
        String palavrasChave = fieldPalavrasChave.getText();
        String resumo = fieldResumo.getText();
        String coAutores = fieldCoAutores.getText();
        String trilha = boxTrilha.getSelectionModel().getSelectedItem();

        model.enviarTrabalho(titulo, palavrasChave, resumo, coAutores, trilha, nomeOrientador);

    }

    void adicionarTextoLabel(){
        Evento evento = model.getEventoSelecionado();
        nomeEvento.setText(evento.getNome());
        dataDeAbertura.setText("Inicio: " + evento.getDataInicio());
        dataDeVencimento.setText("Vencimento: " + evento.getDataFim());
    }

    @FXML
    private void handleAnexarArquivo() {
        FileChooser fileChooser = model.anexarArquivo();

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
        ObsTrilhasIndex = getIndexList(Dados.trilhas);

        boxTrilha.setItems(ObsTrilhasIndex);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarTrilha();
        adicionarTextoLabel();
    }
}


