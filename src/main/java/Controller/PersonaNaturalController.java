package Controller;

import Model.PersonaNatural;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PersonaNaturalController implements Initializable {
    @FXML
    private TableColumn colApellido;

    @FXML
    private Button btnAgregar;

    @FXML
    private TableView<PersonaNatural> tabla;

    @FXML
    private TableColumn colDireccion;

    @FXML
    private TableColumn colEmail;

    @FXML
    private TableColumn colFechaNacimiento;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colTelefono;

    @FXML
    private TableColumn colId;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFechaNacimiento;

    @FXML
    private TextField txtIdentificación;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;


    private ObservableList<PersonaNatural>personaNaturals;

    @Override
     public void initialize(URL url, ResourceBundle resourceBundle) {

        personaNaturals = FXCollections.observableArrayList();

        this.colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        this.colFechaNacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        this.colId.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
        // Agregado para asociar la columna conId

    }



    @FXML
    private void agregarPersona(ActionEvent event){
        String nombre= txtNombre.getText();
        String apellido= txtApellido.getText();
        String telefono= txtTelefono.getText();
        String direccion= txtDireccion.getText();
        String fechaNacimiento= txtFechaNacimiento.getText();
        String email=txtEmail.getText();
        String id= txtIdentificación.getText();


        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtIdentificación.setText("");
        txtTelefono.setText("");
        txtFechaNacimiento.setText("");


        PersonaNatural p= new PersonaNatural(nombre,apellido,id,direccion,telefono,email,fechaNacimiento);

        this.personaNaturals.add(p);
        this.tabla.setItems(personaNaturals);
        System.out.println("Estoy aqui");

    }
@FXML
private void regresar(ActionEvent event){
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

    // Cierra la ventana
    stage.close();
}


    @FXML
    private void seleccionar(MouseEvent event){

        PersonaNatural p= this.tabla.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void eliminar(){
        PersonaNatural p= this.tabla.getSelectionModel().getSelectedItem();


        this.personaNaturals.remove(p);
        this.tabla.refresh();


    }
    @FXML
    private void modificar(){

        PersonaNatural p= this.tabla.getSelectionModel().getSelectedItem();

        String nombre= txtNombre.getText();
        String apellido= txtApellido.getText();
        String telefono= txtTelefono.getText();
        String direccion= txtDireccion.getText();
        String fechaNacimiento= txtFechaNacimiento.getText();
        String email=txtEmail.getText();
        String id= txtIdentificación.getText();

        PersonaNatural aux= new PersonaNatural(nombre,apellido,id,direccion,telefono,email,fechaNacimiento);


            p.setNombre(aux.getNombre());
            p.setApellidos(aux.getApellidos());
            p.setTelefono(aux.getTelefono());
            p.setDireccion(aux.getDireccion());
            p.setFechaNacimiento(aux.getFechaNacimiento());
            p.setEmail(aux.getEmail());
            p.setIdentificacion(aux.getIdentificacion());

            this.tabla.refresh();


        }



    }

