package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Evento;
import com.mycompany.avaliacaosubmissaodetrabalhos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class TelaPerfilController {

    @FXML
    private Button buttonAlterarSenha;

    @FXML
    private Label emailPerfil;

    @FXML
    private Circle fotoPerfil;

    @FXML
    private Label cpfPerfil;

    @FXML
    private Label nomePerfil;


    void adicionarTextoLabel(Usuario usuario) {
        nomePerfil.setText("Evento: " + usuario.getNome());
        emailPerfil.setText("Abertura: " + usuario.getEmail());
        cpfPerfil.setText("Matricula: " + usuario.getCpf());
    }

    @FXML
    void alterarSenha(ActionEvent event) {

    }

}
