package Code.Parciales.SegundoParcial.V1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    // * Flag Attribute that indicates the Thread.sleep(@param milliseconds)
    private static Integer delayAfterOperation = 0;

    // * Method to print 'n' amount of char in Console
    private static void printlnInConsole(Integer amountOfChar) {
        System.out.println();
        for (Integer i = 0; i < amountOfChar; i++) { System.out.format("-"); }
        System.out.println();
    }

    // * @Override method > Msg to console to display when printing the char's
    private static void printlnInConsole(Integer amountOfChar, String msgToConsole) {
        System.out.print(msgToConsole + " ");
        for (Integer i = 0; i < amountOfChar; i++) { System.out.format("-"); }
        System.out.println();
    }

    /*
     * > Prints the current 'Team' (Workspace) 
     * > Show the options 
     * > Returns the UserInput
     * 
     */

    private static <T> String mainMenu(ArrayList <T> mainMenuListOptions, Integer indexOfEquipo) {

        /* 
         * Final => 'Effectively Final' issues working with Lambdas
         * Declaring an Array as final doesn't mean that it can't be modified (Elements stored)
         * It means that his reference (as Java points to an Object) won't be updated 
         */

        final String[] optionChosed = { null };

        // * .forEach(() -> {}); to print the MainMenu
        printlnInConsole(17, String.format("[ Equipo %d ]", indexOfEquipo + 1));
        mainMenuListOptions.forEach((option) -> {
            System.out.format("%s%n", option);
        });

        // * Declaring the ScannerObject as null to prevent Resource Leak
        Scanner scannerIn = null;
        
        // ! UserInput Block
        try {
            // * Each try-catch declares his own ScannerObject that is visible inside the block
            scannerIn = new Scanner(System.in);

            // * Just validating that isn't empty
            do {
                System.out.format("Ingrese una opcion: ");
                optionChosed[0] = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (optionChosed[0].isEmpty());
        } catch (Exception e) { e.printStackTrace(); }


        return optionChosed[0];
    }

    /*
     * > Method responsible of Handling the Case throw by the .mainMenu() method 
     * > It is meant to call the respective methods for each case so inside de method
     * must exists a referenceCopy of the 'Equipo' object
     * > The return statement is just to validate the exit of the program
     * 
     */

    private static Boolean handleCase(String optionIngresed, Equipo equipoCiclistas) {

        // ! ...
        final Boolean[] toReturn = { true };

        /*
         * Depending on each case called the 'delayAfterOperation' will take differents values
         * Except on Input "5" || AnyOtherLetter (In the mainMenu() exit is registered as "5")
         * 
         */

        switch (optionIngresed) {
            case "1": {
                equipoCiclistas.createInstanceOfCiclista();
                delayAfterOperation = 5000;
                break;
            }

            case "2": {
                equipoCiclistas.printTeam();
                delayAfterOperation = 10000;
                break;
            }

            case "3": {
                equipoCiclistas.printResultsByType(false);
                delayAfterOperation = 15000;
                break;
            }

            case "4": {
                equipoCiclistas.printResultsByType(true);
                delayAfterOperation = 10000;
                break;
            }

            default: toReturn[0] = false;
        }

        return toReturn[0];
    }

    /*
     * Method that clears the console after done with any operation 
     * The 'delayAfterOperations' gets updated through the execution ...
     * 
     */

    private static void clearConsole(Integer delayAfterOperation) {
        try {
            Thread.sleep(delayAfterOperation);
        } catch (InterruptedException e) { e.printStackTrace(); }

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) { e.printStackTrace(); }
    }

    // * @Override method > Just to be called once the execution starts
    private static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) { e.printStackTrace(); }
    }

    /*
     * > Method that validate the Exit 
     * > Takes an UserInput an returns it
     * 
     * 
     */

    private static Boolean endCaseTeam() {
        final Boolean[] toReturn = { true };
        final String[] userInput = { "" };

        Scanner scannerIn = null;

        // * Same UserInput block
        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("Agregar un nuevo [Equipo] (Si/No): ");
                userInput[0] = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (userInput[0].isEmpty());
        } catch (Exception e) { e.printStackTrace(); }

        // * Using TernaryOperator to validate the BooleanToReturn value
        toReturn[0] = (userInput[0].equalsIgnoreCase("Si")) ? true : false;

        return toReturn[0];
    }

    /*
     * > 'Main Method' 
     * > Creates a loop as long as the user wants to
     * > Keeps creating objects of 'Equipo' each Iteration
     * > Downside: After moving to a new Team, previous teams won't be accesible
     */

    private static void dataLoop(ArrayList <Equipo> equipos) {

        // ! Main menu of the options
        ArrayList <String> mainMenuListOptions = new ArrayList <>(Arrays.asList(
            "1) Añadir ciclista al equipo",
            "2) Imprimir los datos del equipo",
            "3) Lista de los ciclistas de un equipo por tipo",
            "4) Buscar ciclista en un equipo",
            "5) Salir"
        ));

        Boolean firstRun = true;

        do {
            System.out.println();

            // * Adding new 'Equipo' to the ArrayList
            equipos.add(new Equipo());

            /*
             * This block is for the actual working team 
             * The Exit method is called directly in the do-while()
             */

            do {
                if (firstRun) { clearConsole(); firstRun = !firstRun; } 
                else clearConsole(delayAfterOperation);

                printlnInConsole(30);
            } while (handleCase(mainMenu(mainMenuListOptions, equipos.size() - 1), equipos.get(equipos.size() - 1)));
        
        } while (endCaseTeam());
    }

    public static void main(String[] args) {
        // ! Initializes the ArrayList of 'Equipo' (s)
        ArrayList <Equipo> equipos = new ArrayList <>();
        dataLoop(equipos);
    }
}