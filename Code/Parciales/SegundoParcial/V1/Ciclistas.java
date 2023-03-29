package Code.Parciales.SegundoParcial.V1;

public class Ciclistas {
    private Integer ID;
    private String nombreCiclista;
    private Double tiempoAcumuladoEnCarrera;

    public Ciclistas(Integer ID, String nombreCiclista) {
        this.ID = ID;
        this.nombreCiclista = nombreCiclista;
        this.tiempoAcumuladoEnCarrera = 0.0;
    }

    public Ciclistas() {
        this(null, null);
    }

    public Integer getID() { return this.ID; }
    public String nombreCiclista() { return this.nombreCiclista; }
    public Double getTiempoAcumuladoEnCarrera() { return this.tiempoAcumuladoEnCarrera; }


    public void setID(Integer val) { this.ID = val; }
    public void setNombreCiclista(String val) { this.nombreCiclista = val; }
    public void setTiempoAcumuladoEnCarrera(Double val) { this.tiempoAcumuladoEnCarrera = val; }
}
