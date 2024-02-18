package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalProductosController {

    @FXML
    private Button btnEnlatado;

    @FXML
    private Button btnPerecedero;

    @FXML
    private Button btnRefrigerado;

    @FXML
    public void ProductosRefrigerados(ActionEvent event) throws IOException {

            openNewWindow("/View/ProductoRefrigerado.fxml", "ProductoEnlatado");

    }

    public void ProductosEnvasados(ActionEvent event) throws IOException {

        openNewWindow("/View/ProductosEnvasados.fxml", "ProductoEnvasado");

    }

    public void ProductoPerecedero(ActionEvent event) throws IOException {

        openNewWindow("/View/ProductoPerecedero.fxml", "ProductoPerecedero");

    }

   //se utiliza para abreviar la escritura al abrir ventanas
    private void openNewWindow(String fxmlPath, String windowTitle) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(windowTitle);
        stage.show();
    }

}