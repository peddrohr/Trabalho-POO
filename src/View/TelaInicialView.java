package View;

import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import com.mycompany.avaliacaosubmissaodetrabalhos.Observer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaInicialView implements Observer {

    Model model;
    Stage stage;

    public void iniciarTela(Model model, Stage stage) throws IOException {
        this.model = model;
        this.stage = stage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaInicial.fxml"));
        Parent root = loader.load();

        TelaInicialController controller = loader.getController();
        controller.initialize(model, stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void update() {

    }
}
