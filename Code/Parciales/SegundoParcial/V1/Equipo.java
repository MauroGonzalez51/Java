package Code.Parciales.SegundoParcial.V1;

import java.util.ArrayList;

public class Equipo {
    private String nombreEquipo;
    private Double tiemposDeCarreraPromedio;

    public ArrayList <Ciclistas> ciclistas = new ArrayList <>();



    public String getNombreEquipo() { return this.nombreEquipo; }
    public Double tiemposDeCarreraPromedio() { return this.tiemposDeCarreraPromedio; }

    public void setNombreEquipo(String val) { this.nombreEquipo = val; }
    public void setTiemposDeCarreraPromedio(Double val) { this.tiemposDeCarreraPromedio = val; } 
}
