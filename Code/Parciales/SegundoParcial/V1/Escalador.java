package Code.Parciales.SegundoParcial.V1;

import java.util.Scanner;

public class Escalador extends Ciclistas {
    private Double aceleracionPromedioEnSubida;
    private Double gradoDeRampaSoportada;

    public Escalador(Integer ID, String nombreCiclista, Double aceleracionPrimedioEnSubida, Double gradoDeRampaSoportada) {
        super(ID, nombreCiclista);
        this.aceleracionPromedioEnSubida = aceleracionPrimedioEnSubida;
        this.gradoDeRampaSoportada = gradoDeRampaSoportada;
    }

    public Escalador() {
        super();

        Scanner scannerIn = null;

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese la aceleracion promedio en subida [Escalador]: ");
                this.aceleracionPromedioEnSubida = (scannerIn.hasNextDouble()) ? scannerIn.nextDouble() : -1.0;
            } while (this.aceleracionPromedioEnSubida < 0.0);
        } catch (Exception e) { e.printStackTrace(); }

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese el grado de rampa soportada [Escalador]: ");
                this.gradoDeRampaSoportada = (scannerIn.hasNextDouble()) ? scannerIn.nextDouble() : -1.0;
            } while (this.gradoDeRampaSoportada < 0.0);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public Double getAceleracionPromedioEnSubida() { return this.aceleracionPromedioEnSubida; }
    public Double getGradoDeRampaSoportada() { return this.gradoDeRampaSoportada; }

    public void setAceleracionPromedioEnSubida(Double val) { this.aceleracionPromedioEnSubida = val; }
    public void setGradoDeRampaSoportada(Double val) { this.gradoDeRampaSoportada = val; }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.format("Aceleracion promedio en subida: [ %s ]%n", this.aceleracionPromedioEnSubida.toString());
        System.out.format("Grado de rampa soportada: [ %s ]%n", this.gradoDeRampaSoportada.toString());
    }
}
