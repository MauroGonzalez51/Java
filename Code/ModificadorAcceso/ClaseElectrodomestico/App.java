package Code.ModificadorAcceso.ClaseElectrodomestico;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class App {
    private static <T> Integer randomizeValue(List <T> dataList) {
        Integer randomIndex = (int) Math.floor(Math.random() * dataList.size());
        return randomIndex;        
    }

    private static Boolean randomBooleanValue() {
        List <Integer> booleanValues = List.of(0, 1);
        return ((booleanValues.get(randomizeValue(booleanValues)) == 1) ? true : false );
    }

    // private static Integer randomIntegerValue(Integer minValue, Integer maxValue) {
    //    return ((int) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue));
    // }

    private static Double randomDoubleValue(Double minValue, Double maxValue) {
        return ((double) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue));
    }

    private static void dataLoop(final Integer cantidadDatos, Boolean flag) {
        // * ArrayList that stores all the instances of 'Electrodomestico' => Preventing the IndexOutOfRangeException
        ArrayList <Electrodomestico> arrayElectrodomestico = new ArrayList <Electrodomestico> ();


        // ! Arrays to fill up the program with random values
        List <String> colorValues = List.of("Blanco", "Negro", "Rojo", "Azul", "Gris", "XXX");
        List <String> efficiencyValues = List.of("A", "B", "C", "D", "E", "F", "X");

        List <Integer> constructorChoice = List.of(0,1,2);

        // * Loop to fill the ArrayList
        if (!flag) {
            for (Integer i = 0; i < cantidadDatos; i++) {
                // ! Adding a new Instance of 'Electrodomestico'

                switch (constructorChoice.get(randomizeValue(constructorChoice))) {
                    case 0: {
                        arrayElectrodomestico.add(new Electrodomestico());
                        break;
                    }

                    case 1: {
                        arrayElectrodomestico.add(new Electrodomestico(randomDoubleValue(0.0, 200.0), randomDoubleValue(0.0, 200.0)));
                        break;
                    }

                    case 2: {
                        arrayElectrodomestico.add(new Electrodomestico(
                            randomDoubleValue(0.0,200.0), 
                            colorValues.get(randomizeValue(colorValues)), 
                            efficiencyValues.get(randomizeValue(efficiencyValues)),
                            randomDoubleValue(0.0, 200.0)));
                        break;
                    }
                }



                // * Just showing the finalPrice
                System.out.format("[ INFO ] Precio Final: %f%n", arrayElectrodomestico.get(i).getPrecioFinal());
            }
        } else {
            for (Integer i = 0; i < cantidadDatos; i++) {
                String objectInstanceOf = "";

                List <Integer> constuctorChoiceBlock = List.of(1, 2);

                switch (constructorChoice.get(randomizeValue(constructorChoice))) {
                    case 1: {
                        switch (constuctorChoiceBlock.get(randomizeValue(constuctorChoiceBlock))) {
                            case 1: {
                                arrayElectrodomestico.add(new Lavadora());
                                break;
                            }

                            case 2: {
                                arrayElectrodomestico.add(new Television());
                                break;
                            }
                        }

                        break;
                    }

                    case 2: {
                        switch (constuctorChoiceBlock.get(randomizeValue(constuctorChoiceBlock))) {
                            case 1: {
                                arrayElectrodomestico.add(new Lavadora(
                                    randomDoubleValue(0.0, 200.0),
                                    colorValues.get(randomizeValue(colorValues)),
                                    efficiencyValues.get(randomizeValue(efficiencyValues)),
                                    randomDoubleValue(0.0, 200.0),
                                    randomDoubleValue(0.0, 200.0)
                                ));
                                break;
                            }

                            case 2: {
                                arrayElectrodomestico.add(new Television(
                                    randomDoubleValue(0.0, 200.0),
                                    colorValues.get(randomizeValue(colorValues)),
                                    efficiencyValues.get(randomizeValue(efficiencyValues)),
                                    randomDoubleValue(0.0, 200.0),
                                    randomDoubleValue(0.0, 200.0),
                                    randomBooleanValue()
                                ));
                                break;
                            }
                        }

                        break;
                    }
                }

                objectInstanceOf = (arrayElectrodomestico.get(i) instanceof Lavadora) ? "Lavadora" : "Television";
                
                // * Just showing the finalPrice
                System.out.format("[ INFO ] Precio Final: %f [%s]%n", arrayElectrodomestico.get(i).getPrecioFinal(), objectInstanceOf);
            }
        } 
    }

    public static void main(String[] args) {
        // ! For testing change the value below 
        final Integer cantidadDatos = 10;
        dataLoop(cantidadDatos, true);
    }
}
