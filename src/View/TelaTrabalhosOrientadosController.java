package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaTrabalhosOrientadosController implements Observer{
    Model model;
    Stage view;

    @FXML
    private MenuBar barraMenu;

    @FXML
    private TableColumn<Trabalho, String> colunaAutor;

    @FXML
    private TableColumn<Trabalho, String> colunaCoAutores;

    @FXML
    private TableColumn<Trabalho, String> colunaEvento;

    @FXML
    private TableColumn<Trabalho, Integer> colunaNota;

    @FXML
    private TableColumn<Trabalho, String> colunaTitulo;

    @FXML
    private TableColumn<Trabalho, String> colunaTrilha;

    @FXML
    private Menu menuAvaliarTrabalho;

    @FXML
    private Menu menuEventos;

    @FXML
    private Menu menuInicio;

    @FXML
    private Menu menuPerfil;

    @FXML
    private Label nomeEvento;

    @FXML
    private TableView<Trabalho> tabelaTrabalhos;

    @FXML
    void AbrirTelaAvaliacao(ActionEvent event) {

    }

    @FXML
    void abrirTelaEventos(ActionEvent event) {

    }

    @FXML
    void abrirTelaInicial(ActionEvent event) {

    }

    @FXML
    void abrirTelaPerfil(ActionEvent event) {

    }

    //carregar dados tabela
    void carregarDadosTrabalhos(){
        ObservableList<Trabalho> trabalhos = FXCollections.observableArrayList(((Professor)model.getUsuarioLogadoTipado()).getTrabalhosOrientados());

        colunaAutor.setCellValueFactory(new PropertyValueFactory<>("nomeAutor"));
        colunaEvento.setCellValueFactory(new PropertyValueFactory<>("evento"));
        colunaNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        colunaTrilha.setCellValueFactory(new PropertyValueFactory<>("trilha"));
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));


        tabelaTrabalhos.setItems(trabalhos);

    }

    //iniciando controller
    void initialize(Model model, Stage stage){
        this.model = model;
        this.view = stage;

        carregarDadosTrabalhos();
    }

    @Override
    public void update() {

    }
}
