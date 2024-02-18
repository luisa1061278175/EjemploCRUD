package Model;

public class ProductosRefrigerados extends Productos{
    private String codigoTemperatura;

    public ProductosRefrigerados(int codigo, String nombre, String descripcion, int valorUnitario, int cantidadExistente, String codigoTemperatura) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistente);
        this.codigoTemperatura = codigoTemperatura;
    }

    public String getCodigoTemperatura() {
        return codigoTemperatura;
    }

    public void setCodigoTemperatura(String codigoTemperatura) {
        this.codigoTemperatura = codigoTemperatura;
    }
}
