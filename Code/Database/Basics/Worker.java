package Code.Database.Basics;

import java.io.IOException;
import java.util.Scanner;

public class Worker extends Company {
    private String workerName;
    private Integer hoursOfWork;
    private Integer workerAge;
    private Double baseSalary;
    private Double totalSalary;

    private Scanner scannerIn;

    // ! Constructor 
    // * Prototype (@param flag, @param flag) > Just to print more UserFriendly output messages
    public Worker(Integer flagWorker, Integer flagCompany) throws IOException {
        super(flagCompany);

        this.scannerIn = new Scanner(System.in);

        try  {
            // * Block to validate that the given UserInput isn't empty > .isEmpty() method
            do  {
                System.out.format("[%d] Ingrese el nombre del trabajador: ", flagWorker + 1);
                this.workerName = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (this.workerName.isEmpty());
            
            // * Block to validate a given Integer ==> not < 0
            do  {
                System.out.format("[%d] Ingrese la cantidad de horas Trabajadas: ", flagWorker + 1);
                this.hoursOfWork = (scannerIn.hasNextInt()) ? scannerIn.nextInt() : -1;
            } while (this.hoursOfWork < 0);
    
            do  {
                System.out.format("[%d] Ingrese la edad del trabajador: ", flagWorker + 1);
                this.workerAge = (scannerIn.hasNextInt()) ? scannerIn.nextInt() : -1;
            } while (this.workerAge < 0);
    
            do  {
                System.out.format("[%d] Ingrese el salario base: ", flagWorker + 1);
                this.baseSalary = (scannerIn.hasNextDouble()) ? scannerIn.nextDouble() : -1.0;
            } while (this.baseSalary < 0.0);
        } catch (Exception e) {}

        this.calculateBaseSalary();
    }

    private void calculateBaseSalary() { this.totalSalary = this.baseSalary * this.hoursOfWork; }

    public String getWorkerName() { return this.workerName; }
    public Integer getHoursOfWork() { return this.hoursOfWork; }
    public Integer getWorkerAge() { return this.workerAge; }
    public Double getBaseSalary() { return this.baseSalary; }
    public Double getTotalSalary() { return this.totalSalary; }
}
