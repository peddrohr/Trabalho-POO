package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Trabalho;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.avaliacaosubmissaodetrabalhos.Dados;
import com.mycompany.avaliacaosubmissaodetrabalhos.Evento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaEventosController {
    private Model model = MainTelaLogin.model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ComboBox<Evento> comboboxEventos;

    @FXML
    private Label labelDataFim;

    @FXML
    private Label labelDatainicio;

    @FXML
    private Label labelEtapas;

    @FXML
    private Label labelNomeEvento;

    @FXML
    private Label labelCoAutores;

    @FXML
    private Button buttonEnviarTrabalho;

    @FXML
    private GridPane dadosTrabalho;

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

    void carregarEventos(){
        ObservableList<Evento> eventos = FXCollections.observableList(Dados.eventosCadastrados);
        comboboxEventos.setItems(eventos);
    }

    @FXML
    void carregarDadosEvento(){
        buttonEnviarTrabalho.setDisable(false);
        model.setEventoSelecionado(comboboxEventos.getSelectionModel().getSelectedItem());
        Evento eventoSelecionado = model.getEventoSelecionado();

        labelNomeEvento.setText(eventoSelecionado.getNome());
        labelDatainicio.setText(eventoSelecionado.getDataInicio());
        labelDataFim.setText(eventoSelecionado.getDataFim());
        labelEtapas.setText("Etapas");
        carregarDadosTrabalho();

    }

    @FXML
    void enviarTrabalho(ActionEvent event) throws IOException {
        AnchorPane a = FXMLLoader.load(getClass().getResource("TelaEnvioTrabalho.fxml"));
        anchorPane.getChildren().setAll(a);
        anchorPane.setVisible(true);
        anchorPane.setDisable(false);
        /*Parent root = FXMLLoader.load(getClass().getResource("TelaEnvioTrabalho.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();*/
    }

    @FXML
    void carregarDadosTrabalho(){
        if(model.getTrabalho() != null){
            dadosTrabalho.setVisible(true);
            mensagemTrabalho.setVisible(true);
            labelResumo.setVisible(true);
            buttonEnviarTrabalho.setDisable(true);

            Trabalho trabalho = model.getTrabalho();

            labelTituloTrabalho.setText(trabalho.getTitulo());
            labelCoAutores.setText(trabalho.getNomeCoautores());
            labelOrientador.setText(trabalho.getNomeOrientador());
            labelPalavrasChave.setText(trabalho.getPalavrasChave());
        }
    }

    @FXML
    void initialize() {
        carregarEventos();
        carregarDadosTrabalho();
    }

}