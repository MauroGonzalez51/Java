package Code.Parciales.SegundoParcial.V1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Equipo {
    private String nombreEquipo;
    private Double tiemposDeCarreraPromedio;

    public ArrayList <Ciclistas> ciclistas = new ArrayList <>();

    public Equipo() {
        Scanner scannerIn = null;

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese el nombre del equipo: ");
                this.nombreEquipo = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (this.nombreEquipo.isEmpty());
        } catch (Exception e) { e.printStackTrace(); }
    }

    public String getNombreEquipo() { return this.nombreEquipo; }
    public Double tiemposDeCarreraPromedio() { return this.tiemposDeCarreraPromedio; }

    public void setNombreEquipo(String val) { this.nombreEquipo = val; }
    public void setTiemposDeCarreraPromedio(Double val) { this.tiemposDeCarreraPromedio = val; } 

    public void printTeam() {
        this.printlnInConsole(30);
        System.out.println("Datos del equipo");

        System.out.format("Nombre del equipo: %s%n", this.nombreEquipo);
        System.out.format("TIempo de carrera promedio: %f%n", this.tiemposDeCarreraPromedio);

        ciclistas.forEach((ciclista) -> {
            this.printlnInConsole(15);
            System.out.format("Ciclista [%d]%n", ciclistas.indexOf(ciclista) + 1);
            ciclista.printInfo();
        });
    }

    private void printlnInConsole(Integer amountOfChar) {
        System.out.println();
        for (Integer i = 0; i < amountOfChar; i++) { System.out.format("-"); }
        System.out.println();
    }

    public void createInstanceOfCiclista() {
        Scanner scannerIn = null;

        this.printlnInConsole(30);

        ArrayList <String> typesOfCiclista = new ArrayList <>(Arrays.asList(
            "1) Escalador",
            "2) Velocista",
            "3) Contrarelojista"
        ));

        typesOfCiclista.forEach((typeOfCiclista) -> {
            System.out.format("%s%n", typeOfCiclista);
        });

        final String[] optionIngresed = { null };

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese una opcion: ");
                optionIngresed[0] = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (optionIngresed[0].isEmpty());
        } catch (Exception e) { e.printStackTrace(); }

        switch (optionIngresed[0]) {
            case "1": {
                this.ciclistas.add(new Escalador());
                break;
            }

            case "2": {
                this.ciclistas.add(new Velocista());
                break;
            }

            case "3": {
                this.ciclistas.add(new Contrarelojista());
                break;
            }

            default: System.out.format("[ OPTION NOT SUPPORTED ]%n");
        }
    }
}
