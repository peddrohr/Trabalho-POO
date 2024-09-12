package View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class TelaPerfilController {
    private Model model;
    private Stage view;

    @FXML
    private MenuBar barraMenu;

    @FXML
    private Label labelCpf;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelTipoUsuario;

    @FXML
    private Label cargo;

    @FXML
    private Label labelCargo;

    @FXML
    private Label nomeEvento;

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
    public void sair() throws IOException {
        model.desconectarUsuario();

        TelaLoginView novaTela = new TelaLoginView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void carregarDados() {
        labelNome.setText(((Usuario) model.getUsuarioLogado()).getNome());
        labelEmail.setText(((Usuario) model.getUsuarioLogado()).getEmail());
        labelCpf.setText(((Usuario) model.getUsuarioLogado()).getCpf());
        labelTipoUsuario.setText(model.getTipoUsuarioLogado());
    }


    public void initialize(Model model, Stage stage) {
        this.model = model;
        this.view = stage;
        String nomeCargo = "";

        if (model.verificarAvaliador()) {
            menuAvaliarTrabalho.setDisable(false);
            menuAvaliarTrabalho.setVisible(true);
            labelCargo.setVisible(true);
            nomeCargo += "Avaliador";
        }
        if (model.verificarOrientador()) {
            menuTrabalhosOrientados.setDisable(false);
            menuTrabalhosOrientados.setVisible(true);
            labelCargo.setVisible(true);
            nomeCargo += "Orientador";
        }

        cargo.setText(nomeCargo);


        carregarDados();
    }

}
