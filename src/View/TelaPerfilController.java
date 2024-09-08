package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.avaliacaosubmissaodetrabalhos.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TelaPerfilController {
    Model model = MainTelaLogin.model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelCpf;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelTipoUsuario;

    @FXML
    void carregarDados(){
        labelNome.setText(((Usuario)model.getUsuarioLogado()).getNome());
        labelEmail.setText(((Usuario)model.getUsuarioLogado()).getEmail());
        labelCpf.setText(((Usuario)model.getUsuarioLogado()).getCpf());
        labelTipoUsuario.setText(model.getTipoUsuarioLogado());
    }

    @FXML
    void initialize() {
        carregarDados();
    }

}
