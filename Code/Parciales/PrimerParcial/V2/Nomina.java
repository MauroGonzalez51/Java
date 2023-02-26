package Code.Parciales.PrimerParcial.V2;

import java.util.Scanner;
import java.util.ArrayList;

public class Nomina {

    // ! ClassAttributes > Private
    private String nombreEmpresa;
    private String NIT;

    // ! ------- While testing, change the value below ----- |>
    private Integer cantidadEmpleados = 5;

    // * Creating an ArrayList <Object> to store the data given
    // * This way it resizes automatically and doesn't throw an IOException
    public ArrayList <Empleado> empleados = new ArrayList <Empleado>();

    // * Creating a 'Fecha' object and then setting it to null
    public Fecha fecha = null;

    private Scanner scanner = new Scanner(System.in);

    // * Constructor [1] > Default 
    // * Prototype (@param 'void')
    public Nomina() {
        System.out.println();

        // ! Validating each input
        // * String > It can't be empty, so using the String.isEmpty() method
        do {
            System.out.format("Ingrese el nombre de la empresa: ");
            this.nombreEmpresa = (this.scanner.hasNext()) ? this.scanner.next() : "";
        } while (this.nombreEmpresa.isEmpty());

        do {
            System.out.format("Ingrese el NIT de la empresa: ");
            this.NIT = (this.scanner.hasNext()) ? this.scanner.next() : "";
        } while (this.NIT.isEmpty());
    }

    // ! Method that loops through each 'Empleado' and creates an Object
    public void llenarDatosEmpleados() {
        for (Integer i = 0; i < cantidadEmpleados; i++)
            // * Each time the ArrayList is resized, and then the new 'Empleado' is added
            this.empleados.add(new Empleado(i));
    }

    // ! Method that initializes the 'Fecha' Object > Constructor()
    public void datosFecha() { this.fecha = new Fecha(); }

    // * Print the info of an 'Empleado' > Also with the <Index>
    private void datosEmpleados(Integer n) {
        System.out.println();

        System.out.format("Datos del empleado [%d]%n", n + 1);
        System.out.format("Nombre del empleado: %s%n", empleados.get(n).getNombreEmpleado());
        System.out.format("Horas trabajadas:  %d%n", empleados.get(n).getHorasTrabajadas());
        System.out.format("Edad: %d%n", empleados.get(n).getEdadEmpleado());
        System.out.format("Sueldo total: %f%n", empleados.get(n).getSueldoTotal());
    }

    // ! Method that tryes to find an 'Empleado', using an String (name) given by the user
    public void buscarEmpleado(String empleadoBuscar) {
        
        // * Boolean > Verify if the info were found or not
        Boolean datosEncontrados = false;

        // * Just to verify if the 'Empleado' <ArrayList> were initialized
        if (this.empleados != null) {
            // * .then() it loops through each Instance of 'Empleado'
            for (Integer i = 0; i < this.empleados.size(); i++) {
                // * And finally, if the 'nombreEmpleado' equals the String given
                if (this.empleados.get(i).getNombreEmpleado().equalsIgnoreCase(empleadoBuscar)) {
                    // * Just prints the info
                    datosEncontrados = !datosEncontrados;
                    datosEmpleados(i);
                }
            }
            
            // ! Messages in case of error [...]
            if (!datosEncontrados) { System.out.format("No se encontraron datos [%s]", empleadoBuscar); }
        } else System.out.format("No se encuentran datos de [Empleado] en el sistema%n");
    }

    // ! Methods that prints 'All' the info stored
    public void imprimirNomina() {
        System.out.format("Nombre de la empresa: %s%n", this.nombreEmpresa);
        System.out.format("NIT de la empresa: %s%n", this.NIT);

        System.out.format("%nDatos de los empleados [...] %n");

        // * Using the same loop and function again :>
        for (Integer i = 0; i < empleados.size(); i++) 
            this.datosEmpleados(i);
    }
}
