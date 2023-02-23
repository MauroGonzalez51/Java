package Code.PrimerParcial.V2;

import java.util.Scanner;

public class Empleado {
    private String nombreEmpleado;
    private Integer horasTrabajadas;
    private Integer edadEmpleado;
    private Double salarioBase;
    private Double sueldoTotal;

    private Scanner scanner = new Scanner(System.in);

    public Empleado(Integer n) {
        System.out.println();
        do {
            System.out.format("[%d] Ingrese el nombre del empleado: ", n + 1);
            this.nombreEmpleado = (this.scanner.hasNext()) ? this.scanner.nextLine() : "";
        } while (this.nombreEmpleado.isEmpty());

        do {
            System.out.format("[%d] Ingrese la cantidad de horas trabajadas: ", n + 1);
            this.horasTrabajadas = (this.scanner.hasNextInt()) ? this.scanner.nextInt() : -1;
        } while (this.horasTrabajadas < 0);

        do {
            System.out.format("[%d] Ingrese la edad del empleado: ", n + 1);
            this.edadEmpleado = (this.scanner.hasNextInt()) ? this.scanner.nextInt() : -1;
        } while (this.edadEmpleado < 0);

        do {
            System.out.format("[%d] Ingrese el salario base del empleado: ", n + 1);
            this.salarioBase = (this.scanner.hasNextDouble()) ? this.scanner.nextDouble() : -1.0;
        } while (this.salarioBase < 0.0);

        this.calcularSueldoTotal();
    }

    public void calcularSueldoTotal() { this.sueldoTotal = this.horasTrabajadas * this.salarioBase; }

    // ! ---------- Getters --------------------------------|>
    public String getNombreEmpleado() { return this.nombreEmpleado; }
    public Integer getHorasTrabajadas() { return this.horasTrabajadas; }
    public Integer getEdadEmpleado() { return this.edadEmpleado; }
    public Double getSalarioBase() { return this.salarioBase; }
    public Double getSueldoTotal() { return this.sueldoTotal; }
    
    // ! ---------- Setters -------------------------------|>
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }
    public void setHorasTrabajadas(Integer horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }
    public void setEdadEmpleado(Integer edadEmpleado) { this.edadEmpleado = edadEmpleado; }
    public void setSalarioBase(Double salarioBase) { this.salarioBase = salarioBase; }
    public void setSueldoTotal(Double sueldoTotal) { this.sueldoTotal = sueldoTotal; }
}
