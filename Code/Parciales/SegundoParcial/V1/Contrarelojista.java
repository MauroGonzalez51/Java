package Code.Parciales.SegundoParcial.V1;

import java.util.Scanner;

public class Contrarelojista extends Ciclistas {
    private Double velocidadMaxima;

    public Contrarelojista(Integer ID, String nombreCiclista, Double velocidadMaxima) {
        super(ID, nombreCiclista);
        this.velocidadMaxima = velocidadMaxima;
    }

    public Contrarelojista() {
        super();

        Scanner scannerIn = null;

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese la velocidad maxima [Contrarelojista]: ");
                this.velocidadMaxima = (scannerIn.hasNextDouble()) ? scannerIn.nextDouble() : -1.0;
            } while (this.velocidadMaxima < 0.0);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public Double getVelocidadMaxima() { return this.velocidadMaxima; }

    public void setVelocidadMaxima() { this.velocidadMaxima = val; }
}
