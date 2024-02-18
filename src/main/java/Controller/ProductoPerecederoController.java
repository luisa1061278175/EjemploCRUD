package Controller;

import Model.PersonaNatural;
import Model.ProductoPerecedero;
import Model.ProductosEnvasados;
import Model.ProductosRefrigerados;
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

import java.net.URL;
import java.util.ResourceBundle;

public class ProductoPerecederoController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnRegresar;
    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn colCantidadExistente;

    @FXML
    private TableColumn colCodigo;

    @FXML
    private TableColumn colFechaVencimiento;

    @FXML
    private TableColumn colDescripcion;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colValorUnitario;

    @FXML
    private TableView<ProductoPerecedero> tabla;

    @FXML
    private TextField txtCantidadExistente;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtFechaVencimiento;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtValorUnitario;



    private ObservableList<ProductoPerecedero> productoPerecedero;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        productoPerecedero = FXCollections.observableArrayList();

        this.colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.colCantidadExistente.setCellValueFactory(new PropertyValueFactory<>("cantidadExistente"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colFechaVencimiento.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
        this.colValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));

        // Agregado para asociar la columna conId

    }



    @FXML
    private void agregarProducto(ActionEvent event){

        String nombre= txtNombre.getText();
        int codigo= Integer.parseInt(txtCodigo.getText());
        int cantidadExistente = Integer.parseInt(txtCantidadExistente.getText());
        int valorU= Integer.parseInt(txtValorUnitario.getText());
        String fechaVencimiento= txtFechaVencimiento.getText();
        String descripcion=txtDescripcion.getText();



        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtNombre.setText("");
        txtFechaVencimiento.setText("");
        txtValorUnitario.setText("");
        txtCantidadExistente.setText("");

        ProductoPerecedero p= new ProductoPerecedero(codigo,nombre,descripcion,valorU,cantidadExistente,fechaVencimiento);

        this.productoPerecedero.add(p);
        this.tabla.setItems(productoPerecedero);
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

        ProductoPerecedero p= this.tabla.getSelectionModel().getSelectedItem();

    }
    @FXML
    private void eliminar() {

        ProductoPerecedero p = this.tabla.getSelectionModel().getSelectedItem();


        this.productoPerecedero.remove(p);
        this.tabla.refresh();


    }

    @FXML
    private void modificar() {

        ProductoPerecedero p = this.tabla.getSelectionModel().getSelectedItem();

        String nombre= txtNombre.getText();
        int codigo= Integer.parseInt(txtCodigo.getText());
        int cantidadExistente = Integer.parseInt(txtCantidadExistente.getText());
        int valorU= Integer.parseInt(txtValorUnitario.getText());
        String fechaVencimiento= txtFechaVencimiento.getText();
        String descripcion=txtDescripcion.getText();

        ProductoPerecedero aux = new ProductoPerecedero(codigo,nombre,descripcion,valorU,cantidadExistente,fechaVencimiento);


        p.setNombre(aux.getNombre());
        p.setCodigo(aux.getCodigo());
        p.setCantidadExistente(aux.getCantidadExistente());
        p.setValorUnitario(aux.getValorUnitario());
        p.setFechaVencimiento(aux.getFechaVencimiento());
        p.setDescripcion(aux.getDescripcion());

        this.tabla.refresh();


    }


}











