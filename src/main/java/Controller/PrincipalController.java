package Controller;

import Model.Productos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController  {


    @FXML
    private Button btnProductos;
    @FXML
    private Button btnClientes;


    public void Productos(ActionEvent event) throws IOException {

        openNewWindow("/View/PrincipalProductos.fxml", "Productos");

    }

    public void Clientes(ActionEvent event) throws IOException {

        openNewWindow("/View/PrincipalPersona.fxml", "Clientes");

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
