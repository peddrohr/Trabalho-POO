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
        Trabalho trabalho1 = new Trabalho();
        trabalho1.setQntCoAutores(1);
        trabalho1.setTitulo (fieldTitulo.getText());
        if(model.vericarOrientador(fieldOrientador.getText()) && boxTrilha.getSelectionModel().getSelectedItem() != null){
            trabalho1.setNomeOrientador(fieldOrientador.getText());

            labelEnvio.setText("Trabalho enviado por: "+trabalho1.getNomeAutor());
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
        trabalho1.setPalavrasChave(fieldPalavrasChave.getText());
        trabalho1.setResumo(fieldResumo.getText());
        trabalho1.setNomeCoAutores(fieldCoAutores.getText());
        trabalho1.setNomeAutor(((Usuario)model.getUsuarioLogado()).getNome());
        trabalho1.setEvento(model.getEventoSelecionado());
        trabalho1.setTrilha(model.getTrilha(boxTrilha.getSelectionModel().getSelectedItem()));

        model.addTrabalho(trabalho1);

    }

    void adicionarTextoLabel(){
        Evento evento = model.getEventoSelecionado();
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
        ObsTrilhasIndex = getIndexList(Dados.trilhas);

        boxTrilha.setItems(ObsTrilhasIndex);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarTrilha();
        adicionarTextoLabel();
    }
}


