package Code.Parciales.SegundoParcial.V1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static void printlnInConsole(Integer amountOfChar) {
        System.out.println();
        for (Integer i = 0; i < amountOfChar; i++) { System.out.format("-"); }
        System.out.println();
    }


    private static <T> String mainMenu(ArrayList <T> mainMenuListOptions) {
        final String[] optionChosed = { null };

        mainMenuListOptions.forEach((option) -> {
            System.out.format("%s%n", option);
        });

        Scanner scannerIn = null;
        
        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Ingrese una opcion: ");
                optionChosed[0] = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (optionChosed[0].isEmpty());
        } catch (Exception e) { e.printStackTrace(); }


        return optionChosed[0];
    }

    private static void handleCase(String optionIngresed, Equipo equipoCiclistas) {
        switch (optionIngresed) {
            case "1": {
                equipoCiclistas.createInstanceOfCiclista();
                break;
            }

            case "2": {
                equipoCiclistas.printTeam();
                break;
            }

            default: System.exit(1);
        }
    }

    private static void dataLoop(Equipo equipoCiclistas) {
        equipoCiclistas = new Equipo();

        ArrayList <String> mainMenuListOptions = new ArrayList <>(Arrays.asList(
            "1) Añadir ciclista al equipo",
            "2) Imprimir los datos del equipo",
            "3) Lista de los ciclistas de un equipo por tipo",
            "4) Buscar ciclista en un equipo",
            "5) Salir"
        ));

        do {
            printlnInConsole(30);
            handleCase(mainMenu(mainMenuListOptions), equipoCiclistas);
        } while (true);
    }

    public static void main(String[] args) {
        Equipo equipoCiclistas = null;
        dataLoop(equipoCiclistas);
    }
}