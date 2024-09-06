package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TelaLoginController {

    @FXML
    private Button butaoEntrar;

    @FXML
    private TextField fieldLogin;

    @FXML
    private TextField fieldSenha;

    @FXML
    void validarEntrada(ActionEvent event) {


        String login = fieldLogin.getText();
        String senha = fieldSenha.getText();

        System.out.println(senha + login);
    }

}
