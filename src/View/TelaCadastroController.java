package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCadastroController implements Observer {
    Model model;
    Stage view;

    @FXML
    private Button butaoCancelar;

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
    private CheckBox checkAvaliador;

    @FXML
    private CheckBox checkOrientador;


    @FXML
    void Cancelar(ActionEvent event) throws IOException {
        TelaLoginView novaTela = new TelaLoginView();
        novaTela.iniciarTela(model, view);
    }

    @FXML
    void fazerCadastro(ActionEvent event) throws IOException {
        String nome = labelNome.getText();
        String cpf = labelCpf.getText();
        String email = labelEmail.getText();
        String matricula = labelMatricula.getText();
        String senha = labelSenha.getText();

        // guarda o tipo de aluno selecionado

        RadioButton usuarioSelecionado = (RadioButton) tipoUsuario.getSelectedToggle();
        String tipoUser = usuarioSelecionado.getText();
        if(checkAvaliador.isSelected()){
            if(checkOrientador.isSelected()){
                tipoUser = "AvaliadorOrientador";
            }else{
                tipoUser = "Avaliador";
            }
        }else {
            if (checkOrientador.isSelected()) {
                tipoUser = "Orientador";
            }

        try {
            // cadastrando usuário pelo metodo da model
            model.cadastrarUsuario(tipoUser, nome, cpf, email, senha, matricula);

            // abre novamente a tela inicial
            TelaInicialView novaTela = new TelaInicialView();
            novaTela.iniciarTela(model, view);
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de Cadastro");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            }
        }
    }

    @FXML
    void roleSet(ActionEvent event){
        checkAvaliador.setVisible(true);
        checkOrientador.setVisible(true);
    }

    @FXML
    void alunoSet(ActionEvent event){
        checkAvaliador.setVisible(false);
        checkOrientador.setVisible(false);
    }

    void initialize(Model model, Stage stage) {
        this.model = model;
        this.view = stage;
    }

    @Override
    public void update() {

    }
}
