package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.AlunoInvalidoException;
import com.mycompany.avaliacaosubmissaodetrabalhos.Excecoes.TrilhaInvalidaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;

import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class TelaEnvioTrabalhoController {
    private ObservableList<String> ObsTrilhasIndex;
    private Model model = MainTelaLogin.model;
    private Stage view;

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
    private TextField fieldCoAutores1;

    @FXML
    private TextField fieldCoAutores2;

    @FXML
    private TextField fieldCoAutores3;

    @FXML
    private Label nomeEvento;

    @FXML
    private Label dataDeAbertura;

    @FXML
    private Label dataDeVencimento;

    @FXML
    private Label labelEnvio;

    @FXML
    private MenuBar barraMenu;

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

    @FXML
    void enviarTrabalho(ActionEvent event) throws IOException, TrilhaInvalidaException, AlunoInvalidoException {
        if (boxTrilha.getSelectionModel().getSelectedItem() != null && model.vericarOrientador(fieldOrientador.getText())) {
            ArrayList<String> coAutores = new ArrayList<>();
            if (fieldCoAutores != null && !fieldCoAutores.getText().isEmpty()) {
                coAutores.add(fieldCoAutores.getText());
            }
            if (fieldCoAutores2 != null && !fieldCoAutores2.getText().isEmpty()) {
                coAutores.add(fieldCoAutores2.getText());
            }
            if (fieldCoAutores1 != null && !fieldCoAutores1.getText().isEmpty()) {
                coAutores.add(fieldCoAutores1.getText());
            }
            if (fieldCoAutores3 != null && !fieldCoAutores3.getText().isEmpty()) {
                coAutores.add(fieldCoAutores3.getText());
            }

            String nomeOrientador = fieldOrientador.getText();
            String titulo = fieldTitulo.getText();
            String palavrasChave = fieldPalavrasChave.getText();
            String resumo = fieldResumo.getText();
            String trilha = boxTrilha.getSelectionModel().getSelectedItem();
            try {
                // cadastrando usuário pelo metodo da model
                model.enviarTrabalho(titulo, palavrasChave, resumo, coAutores, trilha, nomeOrientador);

                labelEnvio.setText("Trabalho enviado por: " + model.getTrabalhoEnviado().getNomeAutor());

                abrirTelaInicial();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Envio");
                alert.setHeaderText("Trabalho enviado com sucesso");
                alert.setContentText("Acompanhe o resumo e outras informações no sistema");
                alert.show();
            } catch (IllegalArgumentException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro de Envio");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Orientador ou Trilha inválida");
            alert.setHeaderText("Orientador ou Trilha informada inválida");
            alert.setContentText("Digite um nome válido ou selecione uma trilha válida por favor");
            alert.show();
        }

    }

    void adicionarTextoLabel() {

        if(model.getTipoUsuarioLogado().equals("Professor") || model.getUsuarioLogado().equals("Servidor")){
            fieldOrientador.setDisable(true);
            fieldOrientador.setText("");
        }
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

    private ObservableList<String> getIndexList(List<Trilha> trilhas) {
        List<String> comboBoxList = new ArrayList<String>();

        for (Trilha trilha : trilhas)
            comboBoxList.add(trilha.getNome());

        return FXCollections.observableArrayList(comboBoxList);
    }

    public void carregarTrilha() {
        ObsTrilhasIndex = getIndexList(Dados.trilhas);

        boxTrilha.setItems(ObsTrilhasIndex);
    }

    public void initialize(Model model, Stage stage) {
        this.model = model;
        this.view = stage;

        if (model.verificarAvaliador()) {
            menuAvaliarTrabalho.setDisable(false);
            menuAvaliarTrabalho.setVisible(true);
        }
        if (model.verificarOrientador()) {
            menuTrabalhosOrientados.setDisable(false);
            menuTrabalhosOrientados.setVisible(true);
        }

        carregarTrilha();
        adicionarTextoLabel();
    }
}


