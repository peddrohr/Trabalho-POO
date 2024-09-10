package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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
    void AbrirTelaAvaliacao() throws IOException {
        TelaAvaliacaoView novaTela = new TelaAvaliacaoView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaEventos() throws IOException {
        TelaEventosView novaTela = new TelaEventosView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaEnvioTrabalho() throws IOException {
        TelaEnvioTrabalhoView novaTela = new TelaEnvioTrabalhoView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaPerfil() throws IOException {
        TelaPerfilView novaTela = new TelaPerfilView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaInicial() throws IOException {
        TelaInicialView novaTela = new TelaInicialView();
        novaTela.iniciarTela(model, view);
    }

    //carregar dados tabela
    void carregarDadosTrabalhos(){
        ObservableList<Trabalho> trabalhos = FXCollections.observableArrayList(((Professor)model.getUsuarioLogadoTipado()).getTrabalhosOrientados());

        System.out.println(((Professor)model.getUsuarioLogadoTipado()).getTrabalhosOrientados().getLast().getNomeTrilha());
        colunaAutor.setCellValueFactory(new PropertyValueFactory<>("nomeAutor"));
        colunaEvento.setCellValueFactory(new PropertyValueFactory<>("nomeEvento"));
        colunaTrilha.setCellValueFactory(new PropertyValueFactory<>("nomeTrilha"));
        colunaNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        colunaCoAutores.setCellValueFactory(new PropertyValueFactory<>("coAutores"));
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
