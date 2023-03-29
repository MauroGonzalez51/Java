package Code.Parciales.SegundoParcial.V1;

import java.util.Scanner;

public class Velocista extends Ciclistas {
    private Double potenciaPromedio;
    private Double velocidadPromedio;

    public Velocista (Integer ID, String nombreCiclista, Double potenciaPromedio, Double velocidadPromedio) {
        super(ID, nombreCiclista);
        this.potenciaPromedio = potenciaPromedio;
        this.velocidadPromedio = velocidadPromedio;
    }

    public Velocista() {
        super();

        Scanner scannerIn = null;

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese la potencia promedio [Velocista]: ");
                this.potenciaPromedio = (scannerIn.hasNextDouble()) ? scannerIn.nextDouble() : -1.0;
            } while (this.potenciaPromedio < 0.0);

        } catch (Exception e) { e.printStackTrace(); }

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese la velocidad promedio [Velocista]: ");
                this.velocidadPromedio = (scannerIn.hasNextDouble()) ? scannerIn.nextDouble() : -1.0;
            } while (this.velocidadPromedio < 0.0); 
        } catch (Exception e) { e.printStackTrace(); }
    }

    public Double getPotencialPrimedio() { return this.potenciaPromedio; }
    public Double getVelocidadPromedio() { return this.velocidadPromedio; }

    public void setPotenciaPromedio(Double val) { this.potenciaPromedio = val; }
    public void setVelocidadPromedio(Double val) { this.velocidadPromedio = val; }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.format("Potencia promedio: [ %s ]%n", this.potenciaPromedio.toString());
        System.out.format("Velocidad promedio: [ %s ]%n", this.velocidadPromedio.toString());
    }
}
