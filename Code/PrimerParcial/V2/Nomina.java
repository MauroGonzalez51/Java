package Code.PrimerParcial.V2;

import java.util.Scanner;
import java.util.ArrayList;

public class Nomina {
    private String nombreEmpresa;
    private String NIT;

    // ------- While testing, change the value below ----- |>
    private Integer cantidadEmpleados = 1;

    public ArrayList <Empleado> empleados = new ArrayList <Empleado>();
    public Fecha fecha = null;

    private Scanner scanner = new Scanner(System.in);

    public Nomina() {
        System.out.println();

        do {
            System.out.format("Ingrese el nombre de la empresa: ");
            this.nombreEmpresa = (this.scanner.hasNext()) ? this.scanner.next() : "";
        } while (this.nombreEmpresa.isEmpty());

        do {
            System.out.format("Ingrese el NIT de la empresa: ");
            this.NIT = (this.scanner.hasNext()) ? this.scanner.next() : "";
        } while (this.NIT.isEmpty());
    }

    public void llenarDatosEmpleados() {
        for (Integer i = 0; i < cantidadEmpleados; i++)
            this.empleados.add(new Empleado(i));
    }

    public void datosFecha() { this.fecha = new Fecha(); }

    private void datosEmpleados(Integer n) {
        System.out.println();

        System.out.format("Datos del empleado [%d]%n", n + 1);
        System.out.format("Nombre del empleado: %s%n", empleados.get(n).getNombreEmpleado());
        System.out.format("Horas trabajadas:  %d%n", empleados.get(n).getHorasTrabajadas());
        System.out.format("Edad: %d%n", empleados.get(n).getEdadEmpleado());
        System.out.format("Sueldo total: %f%n", empleados.get(n).getSueldoTotal());
    }

    public void buscarEmpleado(String empleadoBuscar) {
        
        Boolean datosEncontrados = false;

        if (this.empleados != null) {
            for (Integer i = 0; i < this.empleados.size(); i++) {
                if (this.empleados.get(i).getNombreEmpleado().equalsIgnoreCase(empleadoBuscar)) {
                    datosEncontrados = !datosEncontrados;
                    datosEmpleados(i);
                }
            }
    
            if (!datosEncontrados) { System.out.format("No se encontraron datos [%s]", empleadoBuscar); }
        } else System.out.format("No se encuentras datos de [Empleado] en el sistema%n");
    }

    public void imprimirNomina() {
        System.out.format("Nombre de la empresa: %s%n", this.nombreEmpresa);
        System.out.format("NIT de la empresa: %s%n", this.NIT);

        System.out.format("%nDatos de los empleados [...] %n");

        for (Integer i = 0; i < empleados.size(); i++) 
            this.datosEmpleados(i);
    }
}
