package Model;

public class ProductosEnvasados extends Productos{

    private String fechaEnvasado;
    private int pesoEnvase;

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public int getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(int pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }

    public ProductosEnvasados(int codigo, String nombre, String descripcion, int valorUnitario, int cantidadExistente, String fechaEnvasado, int pesoEnvase) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistente);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;


    }
}
