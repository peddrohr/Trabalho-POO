package View;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;


public class TelaEnvioTrabalhoController {

    @FXML
    private Button buttonEnviarTrab;

    @FXML
    private Button buttonEscolhaArquivo;

    @FXML
    private TextField fieldOrientador;

    @FXML
    private TextField fieldPalavrasChave;

    @FXML
    private TextArea fieldResumo;

    @FXML
    private TextField fieldTitulo;

    @FXML
    void escolherPdfTrab(ActionEvent event) {
    }

    @FXML
    void enviarTrabalho(ActionEvent event) {
        String titulo = fieldTitulo.getText();
        String orientador = fieldOrientador.getText();
        String palavras = fieldPalavrasChave.getText();
        String resumo = fieldResumo.getText();
    }
}

