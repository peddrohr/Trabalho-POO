package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.mycompany.avaliacaosubmissaodetrabalhos.Dados.usuariosCadastrados;

public class TelaLoginController implements Initializable {
    public Model model = MainTelaLogin.model;


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
        }
    }

    void novaTela() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menuPrincipal-usuario.fxml")));

        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        Stage fecharTela = (Stage)butaoEntrar.getScene().getWindow();
        fecharTela.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(model);
    }
}
