package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Professor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaInicialController {
    private Model model;
    private Stage view;

    @FXML
    private MenuBar barraMenu;

    @FXML
    private Menu menuAvaliarTrabalho;

    @FXML
    private Menu menuEventos;

    @FXML
    private Menu menuPerfil;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Menu menuTrabalhosOrientados;

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

        try {
            abrirTelaInicial();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}