package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Professor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaInicialController implements Initializable {
    private Model model = MainTelaLogin.model;

    @FXML
    private MenuBar barraMenu;

    @FXML
    private Menu menuAvaliarTrabalho;

    @FXML
    private Menu menuEventos;

    @FXML
    private Menu menuPerfil;

    @FXML
    private Menu menuTrabalhos;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    void AbrirTelaAvaliacao() throws IOException {
        anchorPane.getChildren().setAll(model.AbrirTelaAvaliacao());
    }

    @FXML
    void abrirTelaEventos() throws IOException {
        anchorPane.getChildren().setAll(model.abrirTelaEventos());
    }

    @FXML
    void abrirTelaEnvioTrabalho() throws IOException {
        anchorPane.getChildren().setAll(model.abrirTelaEnvioTrabalho());
    }

    @FXML
    void abrirTelaPerfil() throws IOException {
        anchorPane.getChildren().setAll(model.abrirTelaPerfil());
    }

    @FXML
    void abrirTelaInicial() throws IOException {
        anchorPane.getChildren().setAll(model.abrirTelaInicial());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(model.getTipoUsuarioLogado().equals("Professor") && ((Professor)model.getUsuarioLogadoTipado()).getAvaliador()){
            menuAvaliarTrabalho.setDisable(false);
            menuAvaliarTrabalho.setVisible(true);
        }
        try {
            abrirTelaInicial();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}