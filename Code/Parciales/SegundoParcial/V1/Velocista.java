package Code.Parciales.SegundoParcial.V1;

public class Velocista extends Ciclistas {
    private Double potenciaPromedio;
    private Double velocidadPromedio;

    public Velocista (Integer ID, String nombreCiclista, Double potenciaPromedio, Double velocidadPromedio) {
        super(ID, nombreCiclista);
        this.potenciaPromedio = potenciaPromedio;
        this.velocidadPromedio = velocidadPromedio;
    }
}
