package View;

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
import javafx.stage.Stage;

public class TelaEventosController {

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
    private Button enviarTrabalho;

    @FXML
    private Label labelDatainicio;

    @FXML
    private Label labelEtapas;

    @FXML
    private Label labelNomeEvento;

    void carregarEventos(){
        ObservableList<Evento> eventos = FXCollections.observableList(Dados.eventosCadastrados);
        comboboxEventos.setItems(eventos);
    }

    @FXML
    void carregarDadosEvento(){
        enviarTrabalho.setDisable(false);
        Evento eventoSelecionado = comboboxEventos.getSelectionModel().getSelectedItem();

        labelNomeEvento.setText(eventoSelecionado.getNome());
        labelDatainicio.setText(eventoSelecionado.getDataInicio());
        labelDataFim.setText(eventoSelecionado.getDataFim());
        labelEtapas.setText("Etapas");
    }

    @FXML
    void enviarTrabalho(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaEnvioTrabalho.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        carregarEventos();
    }

}