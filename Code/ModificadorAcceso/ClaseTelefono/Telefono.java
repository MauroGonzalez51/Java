package Code.ModificadorAcceso.ClaseTelefono;

public class Telefono {
    private String marca;
    private Integer capacidad;

    public Telefono(String marca, Integer capacidad) {
        this.marca = marca;
        this.capacidad = capacidad;
    }

    public Integer duracionBateria() { return ((this.capacidad < 3000) ? 16 : 24); }

    // ! ------ Getters --------|>
    public String getMarca() { return this.marca; }
    public Integer getCapacidad() { return this.capacidad; }

    // ! ------ Setters --------|>
    public void setMarca(String val) { this.marca = val; }
    public void setCapacidad(Integer val) { this.capacidad = val; }
}
