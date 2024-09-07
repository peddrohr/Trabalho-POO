package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TelaInicialController {
    private Model model = MainTelaLogin.model;

    @FXML
    private MenuBar barraMenu;

    @FXML
    private Menu menuEventos;

    @FXML
    private Menu menuPerfil;

    @FXML
    private Menu menuTrabalhos;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    void abrirTelaEventos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaEventos.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    @FXML
    void abrirTelaEnvioTrabalho() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("TelaEnvioTrabalho.fxml"));
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

}