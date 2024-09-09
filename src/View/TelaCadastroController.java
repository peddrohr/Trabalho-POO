package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCadastroController implements Observer {
    Model model;
    Stage view;

    @FXML
    private Button butaoCadastro;

    @FXML
    private TextField labelCpf;

    @FXML
    private TextField labelEmail;

    @FXML
    private TextField labelMatricula;

    @FXML
    private TextField labelNome;

    @FXML
    private TextField labelSenha;

    @FXML
    private RadioButton radioAluno;

    @FXML
    private RadioButton radioProfessor;

    @FXML
    private RadioButton radioServidor;

    @FXML
    private ToggleGroup tipoUsuario;

    @FXML
    void fazerCadastro(ActionEvent event) throws IOException {
        String nome = labelNome.getText();
        String cpf = labelCpf.getText();
        String email = labelEmail.getText();
        String matricula = labelMatricula.getText();
        String senha = labelSenha.getText();

        //pegando valor do radio button da view
        RadioButton usuarioSelecionado = (RadioButton) tipoUsuario.getSelectedToggle();
        String tipoUser = usuarioSelecionado.getText();

        //cadastrando usuario
        model.cadastrarUsuario(tipoUser, nome, cpf, email, senha, matricula);

        TelaInicialView novaTela = new TelaInicialView();
        novaTela.iniciarTela(model, view);

    }

    void initialize(Model model, Stage stage){
        this.model = model;
        this.view = stage;
    }
    @Override
    public void update() {

    }
}
