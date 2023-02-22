package Code.Parcial_I;

public class Nomina extends Fecha {
    private String nombreEmpresa;
    private String NIT;
    private Empleado[] empleados = new Empleado[5];

    public void registrarEmpleados() {
        for (Integer i = 0; i < empleados.length; i++) {
            empleados[i].llenarDatos(i);
        }
    } 
    
    public void buscarEmpleado() {
        System.out.format("Ingrese el nombre del empleado que desea buscar: ");
        String nombreEmpleadoBuscar = this.scanner.nextLine();

        Boolean empleadoEncontrado = false;
        for (Integer i = 0; i < empleados.length; i++) {
            if (nombreEmpleadoBuscar.equals(empleados[i].getNombreEmpleado())) {
                System.out.format("Datos encontrados");
                System.out.format("Nombre del empleado: %s%n", empleados[i].getNombreEmpleado());
                System.out.format("Horas trabajadas: %d%n", empleados[i].getHorasTrabajadas());
                System.out.format("Edad: %d$n", empleados[i].getEdad());
                System.out.format("Salario base: %f%n", empleados[i].getSalarioBase());
                System.out.format("Sueldo base: %f%n", empleados[i].getSueldoBase());

                empleadoEncontrado = true;
            }
        }

        if (!empleadoEncontrado) { System.out.format("Datos del empleado no encontrados [%s]", nombreEmpleadoBuscar); }
    }
}
