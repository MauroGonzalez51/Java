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

    private static void printlnInConsole(Integer amountOfChar, String msgToConsole) {
        System.out.print(msgToConsole + " ");
        for (Integer i = 0; i < amountOfChar; i++) { System.out.format("-"); }
        System.out.println();
    }


    private static <T> String mainMenu(ArrayList <T> mainMenuListOptions, Integer indexOfEquipo) {
        final String[] optionChosed = { null };

        printlnInConsole(17, String.format("[ Equipo %d ]", indexOfEquipo + 1));
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

    private static Boolean handleCase(String optionIngresed, Equipo equipoCiclistas) {
        final Boolean[] toReturn = { true };

        switch (optionIngresed) {
            case "1": {
                equipoCiclistas.createInstanceOfCiclista();
                break;
            }

            case "2": {
                equipoCiclistas.printTeam();
                break;
            }

            case "3": {
                equipoCiclistas.printResultsByType();
                break;
            }

            default: toReturn[0] = false;
        }

        return toReturn[0];
    }

    private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static Boolean endCaseTeam() {
        final Boolean[] toReturn = { true };
        final String[] userInput = { "" };

        Scanner scannerIn = null;

        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Agregar un nuevo [Equipo] (Si/No): ");
                userInput[0] = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (userInput[0].isEmpty());
        } catch (Exception e) { e.printStackTrace(); }

        toReturn[0] = (userInput[0].equalsIgnoreCase("Si")) ? true : false;

        return toReturn[0];
    }

    private static void dataLoop(ArrayList <Equipo> equipos) {
        ArrayList <String> mainMenuListOptions = new ArrayList <>(Arrays.asList(
            "1) Añadir ciclista al equipo",
            "2) Imprimir los datos del equipo",
            "3) Lista de los ciclistas de un equipo por tipo",
            "4) Buscar ciclista en un equipo",
            "5) Salir"
        ));

        do {
            System.out.println();
            equipos.add(new Equipo());
            do {
                // TODO Maybe adding some delay here, so it won't interrupt so abruptly
                clearConsole(); 
                printlnInConsole(30);
            } while (handleCase(mainMenu(mainMenuListOptions, equipos.size() - 1), equipos.get(equipos.size() - 1)));
        } while (endCaseTeam());
    }

    public static void main(String[] args) {
        ArrayList <Equipo> equipos = new ArrayList <>();
        dataLoop(equipos);
    }
}