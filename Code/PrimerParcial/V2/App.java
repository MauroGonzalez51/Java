package Code.PrimerParcial.V2;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void caseHandler(String optionIngresed, Nomina nomina) {
        try (Scanner scanner = new Scanner(System.in)) {
            switch (optionIngresed) {
                case "1": {
                    if (nomina.fecha == null) { 
                        System.out.format("%nNo hay datos de fecha registrados%n"); 
                        System.out.format("Procediento a agregarlos [...]%n");
                        nomina.datosFecha();
                    } else {
                        System.out.format("Datos de fecha registrados en el sistema: [%s]%n", nomina.fecha.dateFormat());

                        System.out.format("Desea modificarlos (Si/no)? %n");
                        System.out.format("-> ");
                        String tempOptionIngresed = (scanner.hasNext()) ? scanner.next() : "No";

                        if (tempOptionIngresed.equalsIgnoreCase("Si")) nomina.datosFecha();
                    }

                    break;
                }
                
                case "2": {
                    System.out.format("%nDesea modificar los datos de [Nomina] (Si/No)? %n");
                    System.out.format("-> ");
                    String tempOptionIngresed = (scanner.hasNext()) ? scanner.next() : "No";

                    if (tempOptionIngresed.equalsIgnoreCase("Si")) nomina = new Nomina();

                    break;
                }
                case "3": { nomina.llenarDatosEmpleados(); break; }

                case "4": {
                    String employerName = "";

                    do {
                        System.out.format("%nIngrese el nombre del empleado a buscar: ");
                        employerName = (scanner.hasNext()) ? scanner.next() : "";
                    } while (employerName.isEmpty());

                    nomina.buscarEmpleado(employerName);

                    break;
                }

                default:
                    System.exit(0);
            }
        } 
    }

    public static void mainMenu(Nomina nomina) throws IOException {
        String optionIngresed = "";

        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println();
    
                System.out.format("1. (Agregar/Modificar) fecha de luquidacion%n");
                System.out.format("2. (Agregar/Modificar) datos de la nomina%n");
                System.out.format("3. (Agregar/Modificar) datos de los empleados%n");
                System.out.format("4. Buscar un empleado%n");
                System.out.format("5. Ver todos los datos guardados%n");
                System.out.format("6. Salir%n");
    
                System.out.format("-> ");
                if (scanner.hasNext()) optionIngresed = scanner.next();

                caseHandler(optionIngresed, nomina);

                if (optionIngresed.equals("6")) break;
            } while (true);
        }
    }

    public static void main(String[] args) throws IOException {
        Nomina nomina = new Nomina();
        mainMenu(nomina);
        // nomina.datosFecha();
        // nomina.llenarDatosEmpleados();
        // nomina.buscarEmpleado();

        // nomina.imprimirNomina();

    }
}
