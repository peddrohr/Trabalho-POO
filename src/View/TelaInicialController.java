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
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaAvaliacao.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    void abrirTelaEventos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaEventos.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    void abrirTelaEnvioTrabalho() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaAvaliacao.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    void abrirTelaPerfil() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaPerfil.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    void abrirTelaInicial(){
        anchorPane.getChildren().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(model.getTipoUsuarioLogado().equals("Professor") && ((Professor)model.getUsuarioLogadoTipado()).getAvaliador()){
            menuAvaliarTrabalho.setDisable(false);
            menuAvaliarTrabalho.setVisible(true);
        }
    }
}