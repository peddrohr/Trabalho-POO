package View;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class menuPrincipalUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelText;

    void adicionarTextoLabel(String txt){
        labelText.setText(txt);
    }

    @FXML
    void initialize() {
        adicionarTextoLabel("Cauan");
    }
}
