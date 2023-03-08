package Code.ModificadorAcceso.ClaseElectrodomestico;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static <T> Integer randomizeValue(List <T> dataList) {
        Integer randomIndex = (int) Math.floor(Math.random() * dataList.size());
        return randomIndex;        
    }

    // private static Integer randomIntegerValue(Integer minValue, Integer maxValue) {
    //    return ((int) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue));
    // }

    private static Double randomDoubleValue(Double minValue, Double maxValue) {
        return ((double) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue));
    }

    private static void dataLoop(final Integer cantidadDatos) {
        // * ArrayList that stores all the instances of 'Electrodomestico' => Preventing the IndexOutOfRangeException
        ArrayList <Electrodomestico> arrayElectrodomestico = new ArrayList <Electrodomestico> ();


        // ! Arrays to fill up the program with random values
        List <String> colorValues = List.of("Blanco", "Negro", "Rojo", "Azul", "Gris", "XXX");
        List <String> efficiencyValues = List.of("A", "B", "C", "D", "E", "F", "X");


        // * Loop to fill the ArrayList
        for (Integer i = 0; i < cantidadDatos; i++) {
            // ! Adding a new Instance of 'Electrodomestico'
            arrayElectrodomestico.add(new Electrodomestico(
                randomDoubleValue(0.0,200.0), 
                colorValues.get(randomizeValue(colorValues)), 
                efficiencyValues.get(randomizeValue(efficiencyValues)),
                randomDoubleValue(0.0, 200.0)));

            // * Just showing the finalPrice
            System.out.format("[ INFO ] Precio Final: %f%n", arrayElectrodomestico.get(i).getPrecioFinal());
        }
    }

    public static void main(String[] args) {
        // ! For testing change the value below 
        final Integer cantidadDatos = 10;
        dataLoop(cantidadDatos);
    }
}
