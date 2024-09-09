package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Observer;
import com.mycompany.avaliacaosubmissaodetrabalhos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.mycompany.avaliacaosubmissaodetrabalhos.Dados.usuariosCadastrados;

public class TelaLoginController implements Observer {
    public Model model;
    public Stage view;


    @FXML
    private Button butaoEntrar;

    @FXML
    private TextField fieldLogin;

    @FXML
    private TextField fieldSenha;

    @FXML
    void validarEntrada(ActionEvent event) throws IOException {
        boolean validacao = model.AutenticarUsuario(fieldLogin.getText(), fieldSenha.getText());

        if(validacao){
            System.out.println("Parabens, voce entrou");
            try {
                this.novaTela();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("login ou senha invalidos");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerta");
            alert.setHeaderText("Falha na autenticacao");
            alert.setContentText("Login ou senha invalidos");
            alert.show();
        }
    }

    void novaTela() throws IOException {
        TelaInicialView telaInicial = new TelaInicialView();
        telaInicial.iniciarTela(model, view);

    }

    public void initialize(Model model, Stage stage) {
        this.model = model;
        this.view = stage;
    }

    @Override
    public void update() {

    }
}
