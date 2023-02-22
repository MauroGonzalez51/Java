package Code.PrimerParcial.V2;

import java.util.Scanner;

public class Empleado {
    private String nombreEmpleado;
    private Integer horasTrabajadas;
    private Integer edadEmpleado;
    private Double salarioBase;
    private Double sueldoTotal;

    private Scanner scanner = new Scanner(System.in);

    public Empleado() {
        System.out.println();
        do {
            System.out.format("Ingrese el nombre del empleado: ");
            this.nombreEmpleado = (this.scanner.hasNext()) ? this.scanner.nextLine() : "";
        } while (this.nombreEmpleado.isEmpty());

        do {
            System.out.format("Ingrese la cantidad de horas trabajadas: ");
            this.horasTrabajadas = (this.scanner.hasNextInt()) ? this.scanner.nextInt() : -1;
        } while (this.horasTrabajadas < 0);

        do {
            System.out.format("Ingrese la edad del empleado: ");
            this.edadEmpleado = (this.scanner.hasNextInt())? this.scanner.nextInt() : -1;
        } while (this.edadEmpleado < 0);

        do {
            System.out.format("Ingrese el salario base del empleado: ");
            this.salarioBase = (this.scanner.hasNextDouble())? this.scanner.nextDouble() : -1.0;
        } while (this.salarioBase < 0.0);

        this.calcularSueldoTotal();
    }

    public void calcularSueldoTotal() { this.sueldoTotal = this.horasTrabajadas * this.salarioBase; }
}
