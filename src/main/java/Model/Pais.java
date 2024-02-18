package Model;

public enum Pais {

    COLOMBIA("Colombia"),
    PERU("Peru"),
    CHILE("Chile"),
    ECUADOR("Ecuador"),
    ARGENTINA("Argentina");

    private final String nombre;


    Pais(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
