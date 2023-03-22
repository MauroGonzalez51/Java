package Code.Polymorphism.ClaseElectrodomestico;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static <T> Integer randomizeValue(List<T> dataList) {
        Integer randomIndex = (int) Math.floor(Math.random() * dataList.size());
        return randomIndex;
    }

    private static Boolean randomBooleanValue() {
        List<Integer> booleanValues = List.of(0, 1);
        return ((booleanValues.get(randomizeValue(booleanValues)) == 1) ? true : false);
    }

    // private static Integer randomIntegerValue(Integer minValue, Integer maxValue)
    // {
    // return ((int) Math.floor(Math.random() * (maxValue - minValue + 1) +
    // minValue));
    // }

    private static Double randomDoubleValue(Double minValue, Double maxValue) {
        return ((double) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue));
    }

    private static List <Double> dataLoop(final Integer cantidadDatos, Boolean flag) {
        // * ArrayList that stores all the instances of 'Electrodomestico' => Preventing
        // the IndexOutOfRangeException
        ArrayList<Electrodomestico> arrayElectrodomestico = new ArrayList<Electrodomestico>();

        // ! Arrays to fill up the program with random values
        List<String> colorValues = List.of("Blanco", "Negro", "Rojo", "Azul", "Gris", "XXX");
        List<String> efficiencyValues = List.of("A", "B", "C", "D", "E", "F", "X");

        List<Integer> constructorChoice = List.of(0, 1, 2);


        // * [0] > Lavadora || [1] > Television || {Index}
        Double totalLavadoras = 0.0, totalTelevision = 0.0;

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
                        arrayElectrodomestico.add(
                                new Electrodomestico(randomDoubleValue(0.0, 200.0), randomDoubleValue(0.0, 200.0)));
                        break;
                    }

                    case 2: {
                        arrayElectrodomestico.add(new Electrodomestico(
                                randomDoubleValue(0.0, 200.0),
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

                List<Integer> constructorChoiceBlock = List.of(1, 2);

                switch (constructorChoiceBlock.get(randomizeValue(constructorChoiceBlock))) {
                    case 1: {
                        switch (constructorChoiceBlock.get(randomizeValue(constructorChoiceBlock))) {
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
                        switch (constructorChoiceBlock.get(randomizeValue(constructorChoiceBlock))) {
                            case 1: {
                                arrayElectrodomestico.add(new Lavadora(
                                        randomDoubleValue(0.0, 200.0),
                                        colorValues.get(randomizeValue(colorValues)),
                                        efficiencyValues.get(randomizeValue(efficiencyValues)),
                                        randomDoubleValue(0.0, 200.0),
                                        randomDoubleValue(0.0, 200.0)));

                                break;
                            }

                            case 2: {
                                arrayElectrodomestico.add(new Television(
                                        randomDoubleValue(0.0, 200.0),
                                        colorValues.get(randomizeValue(colorValues)),
                                        efficiencyValues.get(randomizeValue(efficiencyValues)),
                                        randomDoubleValue(0.0, 200.0),
                                        randomDoubleValue(0.0, 200.0),
                                        randomBooleanValue()));
                                break;
                            }
                        }

                        break;
                    }
                }
                
                if (arrayElectrodomestico.get(i) instanceof Lavadora) {
                    totalLavadoras += arrayElectrodomestico.get(i).getPrecioFinal();
                    objectInstanceOf = "Lavadora";
                }
                
                if (arrayElectrodomestico.get(i) instanceof Television) {
                    totalTelevision += arrayElectrodomestico.get(i).getPrecioFinal();
                    objectInstanceOf = "Television";
                }

                // * Just showing the finalPrice
                System.out.format("[ INFO ] Precio Final: %f [%s]%n", arrayElectrodomestico.get(i).getPrecioFinal(),
                        objectInstanceOf);
            }
        }
        List<Double> totalCost = List.of(totalLavadoras, totalTelevision);
        return totalCost;
    }

    public static void main(String[] args) {
        // ! For testing change the value below
        final Integer cantidadDatos = 10;

        List <String> types = List.of("Lavadora", "Television");
        List <Double> result = dataLoop(cantidadDatos, true);

        System.out.println();
        result.forEach((value) -> {
            System.out.format("Total [%s]: %f%n", types.get(result.indexOf(value)), value);
        });

    }
}
