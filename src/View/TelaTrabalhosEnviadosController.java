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

public class TelaTrabalhosEnviadosController implements Observer {
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
    private TableColumn<Trabalho, String> colunaNota;

    @FXML
    private TableColumn<Trabalho, String> colunaTitulo;

    @FXML
    private TableColumn<Trabalho, String> colunaTrilha;

    @FXML
    private TableView<Trabalho> tabelaTrabalhos;

    @FXML
    private Menu menuAvaliarTrabalho;

    @FXML
    private Menu menuEventos;

    @FXML
    private Menu menuPerfil;

    @FXML
    private Menu menuTrabalhosOrientados;

    @FXML
    private Menu menuTrabalhosEnviados;

    @FXML
    void abrirTelaTrabalhosEnviados() throws IOException {
        TelaTrabalhosEnviadosView novaTela = new TelaTrabalhosEnviadosView();
        novaTela.iniciarTela(model, view);
    }

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
    void abrirTelaTrabalhosOrientados() throws IOException {
        TelaTrabalhosOrientadosView novaTela = new TelaTrabalhosOrientadosView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void abrirTelaInicial() throws IOException {
        TelaInicialView novaTela = new TelaInicialView();
        novaTela.iniciarTela(model, view);
    }

    //carregar dados tabela
    void carregarDadosTrabalhos() {
        ObservableList<Trabalho> trabalhos;
        if(model.getTipoUsuarioLogado().equals("Aluno")){
            trabalhos = FXCollections.observableArrayList(((Aluno) model.getUsuarioLogadoTipado()).getTrabalhos());
        } else {
            trabalhos = FXCollections.observableArrayList(((Usuario) model.getUsuarioLogado()).getTrabalhos());
        }
        colunaAutor.setCellValueFactory(new PropertyValueFactory<>("nomeAutor"));
        colunaEvento.setCellValueFactory(new PropertyValueFactory<>("nomeEvento"));
        colunaTrilha.setCellValueFactory(new PropertyValueFactory<>("nomeTrilha"));
        colunaNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
        colunaCoAutores.setCellValueFactory(new PropertyValueFactory<>("coAutores"));
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));


        tabelaTrabalhos.setItems(trabalhos);
    }

    //iniciando controller
    void initialize(Model model, Stage stage) {
        this.model = model;
        this.view = stage;

        if (model.verificarOrientador()) {
            menuTrabalhosOrientados.setVisible(true);
            menuTrabalhosOrientados.setDisable(false);
        }
        if (model.verificarAvaliador()) {
            menuAvaliarTrabalho.setVisible(true);
            menuAvaliarTrabalho.setDisable(false);
        }

        carregarDadosTrabalhos();
    }

    @Override
    public void update() {


    }

    @FXML
    void AbrirTelaTrabalho() throws IOException {
        model.setTrabalhoSelecionado(tabelaTrabalhos.getSelectionModel().getSelectedItem());
        TelaTrabalhoView novaTela = new TelaTrabalhoView();
        novaTela.iniciarTela(model, view);
    }
}
