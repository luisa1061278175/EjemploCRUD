package Controller;

import Model.PersonaNatural;
import Model.ProductoPerecedero;
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

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductoRefrigeradoController implements Initializable {

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
    private TableColumn colCodigoTemperatura;

    @FXML
    private TableColumn colDescripcion;

    @FXML
    private TableColumn colNombre;

    @FXML
    private TableColumn colValorUnitario;

    @FXML
    private TableView<ProductosRefrigerados> tabla;

    @FXML
    private TextField txtCantidadExistente;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtCodigoTemperatura;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtValorUnitario;


    private ObservableList<ProductosRefrigerados> productosRefrigerados;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        productosRefrigerados = FXCollections.observableArrayList();


        this.colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        this.colCantidadExistente.setCellValueFactory(new PropertyValueFactory<>("cantidadExistente"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.colCodigoTemperatura.setCellValueFactory(new PropertyValueFactory<>("codigoTemperatura"));
        this.colValorUnitario.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));

        // Agregado para asociar la columna conId

    }


    @FXML
    private void agregarProducto(ActionEvent event) {


        try {

            String nombre = txtNombre.getText();
            int codigo = Integer.parseInt(txtCodigo.getText());
            int cantidadExistente = Integer.parseInt(txtCantidadExistente.getText());
            int valorU = Integer.parseInt(txtValorUnitario.getText());
            String codigoTemperatura = txtCodigoTemperatura.getText();
            String descripcion = txtDescripcion.getText();


            txtCodigo.setText("");
            txtDescripcion.setText("");
            txtNombre.setText("");
            txtCodigoTemperatura.setText("");
            txtValorUnitario.setText("");
            txtCantidadExistente.setText("");

            ProductosRefrigerados p = new ProductosRefrigerados(codigo, nombre, descripcion, valorU, cantidadExistente, codigoTemperatura);

            this.productosRefrigerados.add(p);
            this.tabla.setItems(productosRefrigerados);


        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog (null,"Error al convertir texto a número. Asegúrate de ingresar valores válidos.");
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

        ProductosRefrigerados p = this.tabla.getSelectionModel().getSelectedItem();

    }

    @FXML

    private void eliminar() {
        try {
            ProductosRefrigerados p = this.tabla.getSelectionModel().getSelectedItem();
            if (p != null) {
                this.productosRefrigerados.remove(p);
                this.tabla.refresh();
            } else {
                JOptionPane.showMessageDialog (null,"Selecciona un elemento antes de intentar eliminar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null,"Error al intentar eliminar el producto.");
        }
    }


    @FXML
    private void modificar() {

        try {

            ProductosRefrigerados p = this.tabla.getSelectionModel().getSelectedItem();
            if (p != null) {
                String nombre = txtNombre.getText();
                int codigo = Integer.parseInt(txtCodigo.getText());
                int cantidadExistente = Integer.parseInt(txtCantidadExistente.getText());
                int valorU = Integer.parseInt(txtValorUnitario.getText());
                String codigoTemperatura = txtCodigoTemperatura.getText();
                String descripcion = txtDescripcion.getText();

                ProductosRefrigerados aux = new ProductosRefrigerados(codigo, nombre, descripcion, valorU, cantidadExistente, codigoTemperatura);

                p.setNombre(aux.getNombre());
                p.setCodigo(aux.getCodigo());
                p.setCantidadExistente(aux.getCantidadExistente());
                p.setValorUnitario(aux.getValorUnitario());
                p.setCodigoTemperatura(aux.getCodigoTemperatura());
                p.setDescripcion(aux.getDescripcion());

                this.tabla.refresh();
            } else {
                JOptionPane.showMessageDialog (null,"Selecciona un elemento antes de intentar modificar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog (null,"Error al convertir texto a número. Asegúrate de ingresar valores válidos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog (null,"Error al intentar modificar el producto.");
        }
    }


    }


















