package Code.Parciales.PrimerParcial.V3;

import java.io.IOException;
import java.util.Scanner;

public class Employee {
    private String employeeName;
    private Integer hoursOfWork;
    private Integer employeeAge;
    private Double baseSalary;
    private Double totalSalary;

    public Employee(Integer flagN) throws IOException {
        System.out.println();

        try (Scanner scannerIn = new Scanner(System.in)) {
            do {
                System.out.format("[%d] Ingrese el nombre del empleado: ", flagN + 1);
                this.employeeName = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (this.employeeName.isEmpty());

            do {
                System.out.format("[%d] Ingrese las horas de trabajo del empleado: ", flagN + 1);
                this.hoursOfWork = (scannerIn.hasNextInt()) ? scannerIn.nextInt() : -1;
            } while (this.hoursOfWork < 0);

            do {
                System.out.format("[%d] Ingrese la edad del empleado: ", flagN + 1);
                this.employeeAge = (scannerIn.hasNextInt()) ? scannerIn.nextInt() : -1;
            } while (this.employeeAge < 0);

            do {
                System.out.format("[%d] Ingrese el salario base del empleado: ", flagN + 1);
                this.baseSalary = (scannerIn.hasNextDouble()) ? scannerIn.nextDouble() : -1.0;
            } while (this.baseSalary < 0.0);
        }

        this.totalSalary();
    }

    private void totalSalary() { this.totalSalary = this.hoursOfWork * this.baseSalary; }
}
