package Code.RandomStuff.Test.ClaseRueda;

import java.util.Scanner;

public class Rueda {
    private String tipoRueda, marcaRueda;
    private Double grosorRueda, diametroRueda;

    public Rueda() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tipo de rueda: ");
        this.tipoRueda = (scanner.hasNext()) ? scanner.nextLine() : null;

        System.out.print("Ingrese la marca de la rueda: ");
        this.marcaRueda = (scanner.hasNext()) ? scanner.nextLine() : null;

        System.out.print("Ingrese el grosor de la rueda: ");
        if (scanner.hasNextDouble()) this.grosorRueda = scanner.nextDouble();
        else System.out.println("Ingrese un valor valido");

        System.out.print("Ingrese el diametro de la rueda: ");
        if (scanner.hasNextDouble()) this.diametroRueda = scanner.nextDouble();
        else System.out.print("Ingrese un valor valido");

        /*
            this.tipoRueda = (scanner.hasNext()) ? scanner.nextLine() : null;
            if (scanner.hasNext()) this.tipoRueda = scanner.nextLine();

            this.marcaRueda = (scanner.hasNext())? scanner.nextLine() : null;
            if (scanner.hasNext()) this.marcaRueda = scanner.nextLine();
        */

        scanner.close();
    }

    public void validarPrimeraCondicion() {
        if (this.diametroRueda > 1.4) System.out.format("%nLa rueda es para un vehiculo grande%n");
        else if (this.diametroRueda > 0.8) System.out.format("La reuda es para un vehiculo mediano%n");
        else System.out.println("La rueda es para un vehiculo pequeño");
    }

    public void validarSegundaCondicion() {
        if (((this.diametroRueda > 1.4) && (this.grosorRueda < 0.4)) || 
            ((this.diametroRueda <= 1.4) && (this.diametroRueda > 0.8) && (this.grosorRueda < 0.25))) {
                System.out.format("El grosor para esta rueda es inferior al recomendado%n");
            }
    }
}
