package Code.Parciales.SegundoParcial.V1;

import java.util.Scanner;

public class Ciclistas {
    private Integer ID;
    private String nombreCiclista;
    private Double tiempoAcumuladoEnCarrera;

    public Ciclistas(Integer ID, String nombreCiclista) {
        this.ID = ID;
        this.nombreCiclista = nombreCiclista;
        this.tiempoAcumuladoEnCarrera = 0.0;
    }

    /*
     * Basic Ciclista class
     * Each DerivatedClass works the same way
     * ---------------------------------------------------------|>
     * [Constructor]
     * Takes a UserInput for all the ClassAttributes (The inherited ones will be taken in parent class)
     * 
     * ---------------------------------------------------------|>
     * [Getters] [Setters]
     * For each ClassAttribute (The inherited ones will be accesible via ParentClass [Getters][Setters])
     * 
     * ---------------------------------------------------------|>
     * .getType() [Method]
     * Returns the ClassName of an Object previously created
     */

    public Ciclistas() {
        System.out.println();

        Scanner scannerIn = null;

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese el ID: ");
                this.ID = (scannerIn.hasNextInt()) ? scannerIn.nextInt() : -1;
            } while (this.ID < 0);
        } catch (Exception e) { e.printStackTrace(); }

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese el nombre del ciclista: ");
                this.nombreCiclista = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (this.nombreCiclista.isEmpty());
        } catch (Exception e) { e.printStackTrace(); }

        this.tiempoAcumuladoEnCarrera = 0.0;
    }

    public void printInfo() {
        System.out.format("ID: [ %s ]%n", this.ID.toString());
        System.out.format("Nombre ciclista: [ %s ]%n", this.nombreCiclista);
        System.out.format("Tiempo acumulado en carrera: [ %s ]%n", this.tiempoAcumuladoEnCarrera.toString());
    }

    public String getType() { return String.format("Class [%s]%n", this.getClass().getSimpleName()); }

    public Integer getID() { return this.ID; }
    public String getNombreCiclista() { return this.nombreCiclista; }
    public Double getTiempoAcumuladoEnCarrera() { return this.tiempoAcumuladoEnCarrera; }

    public void setID(Integer val) { this.ID = val; }
    public void setNombreCiclista(String val) { this.nombreCiclista = val; }
    public void setTiempoAcumuladoEnCarrera(Double val) { this.tiempoAcumuladoEnCarrera = val; }
}
