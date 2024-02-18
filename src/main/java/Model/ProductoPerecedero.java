package Model;

public class ProductoPerecedero extends Productos {

    private String fechaVencimiento;

    public ProductoPerecedero(int codigo, String nombre, String descripcion, int valorUnitario, int cantidadExistente, String fechaVencimiento) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistente);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
