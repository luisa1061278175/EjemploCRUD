package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalPersonaController {

    @FXML
    private Button btnPersonaJ;

    @FXML
    private Button btnPersonaN;

    @FXML
    public void PersonaJuridica(ActionEvent event) throws IOException {

            openNewWindow("/View/PersonaJuridica.fxml", "Ventana Persona Jurídica");

    }

    @FXML
    public void PersonaNatural(ActionEvent event) throws IOException {

            openNewWindow("/View/PersonaNatural.fxml", "Ventana Persona Natural");

    }

    private void openNewWindow(String fxmlPath, String windowTitle) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(windowTitle);
        stage.show();
    }
}
