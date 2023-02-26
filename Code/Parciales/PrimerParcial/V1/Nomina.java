package Code.Parciales.PrimerParcial.V1;

public class Nomina extends Fecha {
    private String nombreEmpresa;
    private String NIT;
    private Empleado[] empleados = new Empleado[5];

    public Nomina(Integer day, Integer month, Integer year) {
        super(day, month, year);
        this.llenarDatosEmpresa();
        this.registrarEmpleados();
    }

    public Nomina(String day, String month, String year) {
        super(day, month, year);
        this.llenarDatosEmpresa();
        this.registrarEmpleados();
    }

    public Nomina(String date) {
        super(date);
        this.llenarDatosEmpresa();
        this.registrarEmpleados();
    }
    
    public void llenarDatosEmpresa() {
        System.out.println();
    
        System.out.format("%nIngrese el nombre de la empresa: ");
        if (scanner.hasNext()) this.nombreEmpresa = scanner.nextLine();
    
        System.out.format("%nIngrese el NIT: ");
        if (scanner.hasNext()) this.NIT = scanner.next();
    }

    public void registrarEmpleados() {
        for (Integer i = 0; i < empleados.length; i++) {
            // empleados[i].llenarDatos(i);
            empleados[i] = new Empleado();
        }

    } 

    public void datosEmpleado(Integer i) {
        System.out.format("Empleado [%d]%n", i + 1);
        System.out.format("Nombre del empleado: %s%n", empleados[i].getNombreEmpleado());
        System.out.format("Horas trabajadas: %d%n", empleados[i].getHorasTrabajadas());
        System.out.format("Edad: %d$n", empleados[i].getEdad());
        System.out.format("Salario base: %f%n", empleados[i].getSalarioBase());
        System.out.format("Sueldo base: %f%n", empleados[i].getSueldoBase());
    }
    
    public void buscarEmpleado() {
        System.out.format("Ingrese el nombre del empleado que desea buscar: ");
        String nombreEmpleadoBuscar = this.scanner.nextLine();

        Boolean empleadoEncontrado = false;
        for (Integer i = 0; i < this.empleados.length; i++) {
            if (nombreEmpleadoBuscar.equalsIgnoreCase(empleados[i].getNombreEmpleado())) {
                System.out.format("Datos del empleado encontrado: %n");
                this.datosEmpleado(i);
                empleadoEncontrado = true;
            }
        }

        if (!empleadoEncontrado) { System.out.format("Datos del empleado no encontrados [%s]", nombreEmpleadoBuscar); }
    }

    public void imprimirNomina() {
        System.out.format("Nombre empresa: [%s] %n NIT: [%s] %n", this.nombreEmpresa, this.NIT);

        System.out.format("Imprimiendo los datos de los empleados: %n");

        for (Integer i = 0; i < this.empleados.length; i++) { this.datosEmpleado(i); }
    }
}
