package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.mycompany.avaliacaosubmissaodetrabalhos.Model;

import static com.mycompany.avaliacaosubmissaodetrabalhos.Dados.usuariosCadastrados;

public class TelaLoginController {

    @FXML
    private Button butaoEntrar;

    @FXML
    private TextField fieldLogin;

    @FXML
    private TextField fieldSenha;

    @FXML
    void validarEntrada(ActionEvent event) {
        Model model = new Model();
        boolean validacao = model.AutenticarUsuario(fieldLogin.getText(), fieldSenha.getText());

        if(validacao){
            System.out.println("Parabens, voce entrou");
        } else {
            System.out.println("login ou senha invalidos");
        }
    }

}
