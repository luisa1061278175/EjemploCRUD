
package Controller;

import Model.PersonaJuridica;
import Model.PersonaNatural;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.*;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonaJuridicaController implements Initializable {

    @FXML
    private Button btnAgregar;

    @FXML
    private TableColumn colApellido;

    @FXML
    private TableColumn colDireccion;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colNit;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colTelefono;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtIdentificación;

    @FXML
    private TextField txtNit;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TableView<PersonaJuridica> tabla;

    @FXML
    private ObservableList<PersonaJuridica> personaJuricals;


    public void initialize(URL url, ResourceBundle resourceBundle) {

        personaJuricals = FXCollections.observableArrayList();

        this.colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        this.colNit.setCellValueFactory(new PropertyValueFactory<>("nit"));
        this.colId.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        // Agregado para asociar la columna conId

    }


    @FXML
    private void agregarPersona(ActionEvent event) {

        try {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        String nit = txtNit.getText();
        String id = txtIdentificación.getText();

        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtNit.setText("");
        txtIdentificación.setText("");
        txtTelefono.setText("");


        PersonaJuridica pe = new PersonaJuridica(nombre, apellido, id, direccion, telefono, nit);


        this.personaJuricals.add(pe);
        this.tabla.setItems(personaJuricals);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog (null,"Error al convertir texto a número. Asegúrate de ingresar valores válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null,"Error al agregar persona jurídica. Asegúrate de ingresar valores válidos.");
        }
    }

    @FXML
    private void regresar(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cierra la ventana
        stage.close();
    }


    @FXML
    private void seleccionar(MouseEvent event) {

        PersonaJuridica p = this.tabla.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void eliminar() {
        try {
            PersonaJuridica p = this.tabla.getSelectionModel().getSelectedItem();
            if (p != null) {
                this.personaJuricals.remove(p);
                this.tabla.refresh();
            } else {
                JOptionPane.showMessageDialog (null,"Selecciona un elemento antes de intentar eliminar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null,"Error al intentar eliminar la persona jurídica.");
        }
    }

    @FXML
    private void modificar() {
        try {
            PersonaJuridica p = this.tabla.getSelectionModel().getSelectedItem();
            if (p != null) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String telefono = txtTelefono.getText();
                String direccion = txtDireccion.getText();
                String nit = txtNit.getText();
                String id = txtIdentificación.getText();

                PersonaJuridica aux = new PersonaJuridica(nombre, apellido, id, direccion, telefono, nit);

                p.setNombre(aux.getNombre());
                p.setApellidos(aux.getApellidos());
                p.setTelefono(aux.getTelefono());
                p.setDireccion(aux.getDireccion());
                p.setNit(aux.getNit());
                p.setIdentificacion(aux.getIdentificacion());

                this.tabla.refresh();
            } else {
                JOptionPane.showMessageDialog (null,"Selecciona un elemento antes de intentar modificar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog (null,"Error al convertir texto a número. Asegúrate de ingresar valores válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null,"Error al intentar modificar la persona jurídica.");
        }
    }
}




