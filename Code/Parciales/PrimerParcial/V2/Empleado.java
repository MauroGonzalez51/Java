package Code.Parciales.PrimerParcial.V2;

import java.util.Scanner;

public class Empleado {

    // ! All classAttributes are private ==> Encapsulation, therefore they're only accessible 
    // ! Inside this class
    private String nombreEmpleado;
    private Integer horasTrabajadas;
    private Integer edadEmpleado;
    private Double salarioBase;
    private Double sueldoTotal;

    // * Scanner Object is defined as a ClassAtribute ==> NO resource leak
    private Scanner scanner = new Scanner(System.in);

    // ! Constructor of the class
    // * Prototye (@param Integer n) ==> It comes from a loop, so it's more visible if there's
    // * A list || Count || Whatever
    public Empleado(Integer n) {
        System.out.println();

        // ! Each of these blocks all they do, is to validate a userEntry and .then() processing it
        // ! Clearly all ain't validated the same way

        // * String  ==> It can't be empty, so using the String.isEmpty() method
        // * Integer ==> It can't be lower than Zero, Integer < 0, inside a do-while loop
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

    // ! Method that calculates the totalSalary using the formula given [...]
    public void calcularSueldoTotal() { this.sueldoTotal = this.horasTrabajadas * this.salarioBase; }

    // * "Extra" methods of the class ==> Getters && Setters : If necessary

    // ! ---------- Getters --------------------------------|>
    // * PrivateAttributes > Can't be 'called' outside > Using a methods that returns the value

    public String getNombreEmpleado() { return this.nombreEmpleado; }
    public Integer getHorasTrabajadas() { return this.horasTrabajadas; }
    public Integer getEdadEmpleado() { return this.edadEmpleado; }
    public Double getSalarioBase() { return this.salarioBase; }
    public Double getSueldoTotal() { return this.sueldoTotal; }
    
    // ! ---------- Setters -------------------------------|>
    // * PrivateAttributes > Can't be 'modified' outside > Using a method that modifies it
    // * Prototype (@param var newValue) > Changes the Attribute to the newValue given

    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }
    public void setHorasTrabajadas(Integer horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }
    public void setEdadEmpleado(Integer edadEmpleado) { this.edadEmpleado = edadEmpleado; }
    public void setSalarioBase(Double salarioBase) { this.salarioBase = salarioBase; }
    public void setSueldoTotal(Double sueldoTotal) { this.sueldoTotal = sueldoTotal; }
}
