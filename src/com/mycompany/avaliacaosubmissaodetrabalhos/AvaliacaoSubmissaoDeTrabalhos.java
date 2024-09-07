package com.mycompany.avaliacaosubmissaodetrabalhos;

import View.TelaLoginController;
import com.mycompany.avaliacaosubmissaodetrabalhos.Dados;
import com.mycompany.avaliacaosubmissaodetrabalhos.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AvaliacaoSubmissaoDeTrabalhos extends Application {
    public static Model model = new Model();
    public static void main(String[] args) {
        Dados dados = new Dados();
        dados.carregarUsuarios();
        System.out.println(model);
        TelaLoginController viewController = new TelaLoginController();
        System.out.println(viewController.model);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("TelaLogin.fxml")));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
