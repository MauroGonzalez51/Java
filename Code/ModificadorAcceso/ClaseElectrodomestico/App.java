package Code.ModificadorAcceso.ClaseElectrodomestico;

import java.util.ArrayList;

public class App {
    private static void dataLoop(final Integer cantidadDatos) {
        // * ArrayList that stores all the instances of 'Electrodomestico' => Preventing the outOfIndex Exception 
        ArrayList <Electrodomestico> arrayElectrodomestico = new ArrayList <Electrodomestico> ();

        // * Loop to fill the ArrayList
        for (Integer i = 0; i < cantidadDatos; i++) {
            // ! Adding a new Instance of 'Electrodomestico'
            arrayElectrodomestico.add(new Electrodomestico());

            // * Just showinf the finalPrice
            System.out.format("[ INFO ] Precio Final: %f%n", arrayElectrodomestico.get(i).getPrecioFinal());
        }
    }


    public static void main(String[] args) {
        // ! For testing change the value below 
        final Integer cantidadDatos = 1;
        dataLoop(cantidadDatos);
    }
}
