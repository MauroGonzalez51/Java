package Code.Parciales.PrimerParcial.V1;

import java.util.Scanner;

public class Empleado {
    private String nombreEmpleado;
    private Integer horasTrabajadas;
    private Integer edad;
    private Double salarioBase;
    private Double sueldoBase;
    public Scanner scanner = new Scanner(System.in);

    public Empleado(String nombreEmpleado, Integer horasTrabajadas, Integer edad, Double salarioBase) {
        super();
        this.nombreEmpleado = nombreEmpleado;
        this.horasTrabajadas = horasTrabajadas;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.calcularSalarioBase();
    }

    public Empleado() {
        System.out.format("Ingrese el nombre del empleado: ");
        if (this.scanner.hasNext()) this.nombreEmpleado = this.scanner.next();
    
        System.out.format("Ingrese la cantidad de horas trabajadas: ");
        if (this.scanner.hasNextInt()) this.horasTrabajadas = this.scanner.nextInt();
    
        System.out.format("Ingrese la edad del empleado: ");
        if (this.scanner.hasNextInt()) this.edad = this.scanner.nextInt();
    
        System.out.format("Ingrese el salario base del empleado: ");
        if (this.scanner.hasNextDouble()) this.salarioBase = this.scanner.nextDouble();
    
        this.calcularSalarioBase();
    }

    public void calcularSalarioBase() { this.sueldoBase = this.salarioBase * this.horasTrabajadas; }

    //! --------- Setters ------------->
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }
    public void setHorasTrabajadas(Integer horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }
    public void setEdad(Integer edad) { this.edad = edad; }
    public void setSalarioBase(Double salarioBase) { this.salarioBase = salarioBase; }

    // ! --------- Getters ------------->
    public String getNombreEmpleado() { return this.nombreEmpleado; }
    public Integer getHorasTrabajadas() { return this.horasTrabajadas; }
    public Integer getEdad() { return this.edad; }
    public Double getSalarioBase() { return this.salarioBase; }
    public Double getSueldoBase() { return this.sueldoBase; }
}
