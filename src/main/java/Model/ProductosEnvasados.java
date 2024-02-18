package Model;

public class ProductosEnvasados extends Productos {

    private String fechaEnvasado;
    private int pesoEnvase;

    private String pais;


    public ProductosEnvasados(int codigo, String nombre, String descripcion, int valorUnitario, int cantidadExistente, String fechaEnvasado, int pesoEnvase, String pais) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistente);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.pais = pais;
    }

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}