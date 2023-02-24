package Code.PrimerParcial.V2;

import java.util.Scanner;

public class App {
    private static void printlnInConsole(Integer amountOfCaracters) {
        System.out.println();
        for (Integer i = 0; i < amountOfCaracters; i++)
            System.out.print("- ");
        System.out.println();
    }

    public static void defaultLaunchOrder(Nomina nomina) {
        printlnInConsole(25);
        System.out.format("[1] Ingresando los datos de nomina%n");
        nomina = new Nomina();

        printlnInConsole(25);
        System.out.format("%n[2] Fecha de liquidacion%n");
        nomina.datosFecha();

        printlnInConsole(25);
        System.out.format("%n[3] Ingresando los datos de los empleados%n");
        nomina.llenarDatosEmpleados();

        printlnInConsole(25);
        String buscarEmpleado = "";
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.format("%nDesea buscar los datos de un empleado (Si/No)? ");
                buscarEmpleado = (scanner.hasNext()) ? scanner.next() : "";
            } while (buscarEmpleado.isEmpty());

            if (buscarEmpleado.equalsIgnoreCase("Si")) {
                String nombreEmpleadoBuscar = "";
    
                System.out.format("%nIngrese el nombre del empleado a buscar: ");
                nombreEmpleadoBuscar = (scanner.hasNext()) ? scanner.next() : "";
            
                nomina.buscarEmpleado(nombreEmpleadoBuscar);
            }           
        }

        printlnInConsole(25);
        System.out.format("%nImprimiendo todos los datos de la nomina%n%n");
        nomina.imprimirNomina();
    }

    public static void main(String[] args) {
        System.out.flush();
        System.out.format("%nClase Nomina%n%n");

        System.out.format("Lanzando el programa en orden por defecto%n%n");
        Nomina nomina = null;
        defaultLaunchOrder(nomina);
    }
}        
