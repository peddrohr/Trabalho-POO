package View;

import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.avaliacaosubmissaodetrabalhos.Evento;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class TelaEventosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Evento> comboboxEventos;

    @FXML
    void initialize() {
        assert comboboxEventos != null : "fx:id=\"vomboboxEventos\" was not injected: check your FXML file 'TelaEventos.fxml'.";

    }

}

