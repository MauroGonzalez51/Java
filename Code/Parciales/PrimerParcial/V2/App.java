/*
 * @autor's
 *      - Mauro Alonso Gonzalez Figueroa    | T00067622
 *      - Juan Jose Jimenez Guardo          | T00068278
 * 
 *  Published on
 *  https://github.com/MauroGonzalez51/Java/tree/master/Code/Parciales/PrimerParcial/V2
 * 
 *  
 * 
 * 
 * 
 * 
 */

package Code.Parciales.PrimerParcial.V2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    // ! Methods that clean up the console output :D
    private static void CleanOutputStream() {
        try { new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); } 
        catch (Exception e) { }
    }

    // ! Method to print a "line" in console ==> Output format : - - - - - - -
    private static void printlnInConsole(Integer amountOfCaracters) {
        System.out.println();
        for (Integer i = 0; i < amountOfCaracters; i++)
            System.out.print("- ");
        System.out.println();
    }

    // ! Method who follows the given order and then launches the other classes methods
    public static void defaultLaunchOrder(Nomina nomina) {
        printlnInConsole(25);
        System.out.format("[1] Ingresando los datos de nomina%n");

        // * Default (Modified) Constructor
        nomina = new Nomina();

        printlnInConsole(25);
        System.out.format("%n[2] Fecha de liquidacion%n");

        // * Initializing the Date object of the "Nomina" class
        // * Is also viable, to create a Date object (With the constructor)
        // * And then comunicate both classes via @params but this way is easier :D
        nomina.datosFecha();

        printlnInConsole(25);
        System.out.format("%n[3] Ingresando los datos de los empleados%n");

        // * Method a.k.a Loop to initializate each "Empleado"
        nomina.llenarDatosEmpleados();

        printlnInConsole(25);
        String buscarEmpleado = "";

        // ! Try-with-resources built in block > This way there's no resource leak
        try (Scanner scanner = new Scanner(System.in)) {

            // * Here's just to validate that the InsertedString isn't empty()
            do {
                System.out.format("%nDesea buscar los datos de un empleado (Si/No)? ");
                buscarEmpleado = (scanner.hasNext()) ? scanner.next() : "";
            } while (buscarEmpleado.isEmpty());

            // * If the user says: "Si", then this code block is executed
            if (buscarEmpleado.equalsIgnoreCase("Si")) {
                String nombreEmpleadoBuscar = "";
                
                // ! Ternary Operator > var whatever = (Condition) ? trueValue : falseValue ;
                System.out.format("%nIngrese el nombre del empleado a buscar: ");
                nombreEmpleadoBuscar = (scanner.hasNext()) ? scanner.next() : "";
                
                // * Method that does all that search of the "Empleado" thing
                nomina.buscarEmpleado(nombreEmpleadoBuscar);
            }           
        }

        printlnInConsole(25);
        System.out.format("%nImprimiendo todos los datos de la nomina%n%n");

        // * Method that prints all the info stored :D
        nomina.imprimirNomina();
    }

    // ! Main method > That's it :>
    public static void main(String[] args) throws FileNotFoundException {
        CleanOutputStream();

        System.out.format("%nClase Nomina%n%n");

        System.out.format("Lanzando el programa en orden por defecto%n%n");

        // ! Initializes the "Nomina" object as null so the constructor is not called (yet)
        // * Besides, this way the Object can be send as @params to any part of the code
        Nomina nomina = null;
        defaultLaunchOrder(nomina);
        File.writeToFile(new Empleado(0), 1);
    }
}        
