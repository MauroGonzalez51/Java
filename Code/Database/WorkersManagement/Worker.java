package Code.Database.WorkersManagement;

import java.util.Scanner;

// TODO 

/*
 * > Take all the prompts from the 'App' class, make'em static and public so in case of Taking an UserInput, just call them
 * > Create the UPDATE Method using the SELECT Method
 *     If the request throws more than one condicence (ArrayList.size() > 1) then asks the User, which one want us to modify
 *     If no, just create a new Worker() Object and send it to the database (WITH AND UPDATE QUERY)  
 * 
 */

public class Worker {
    private String companyName;
    private String NIT;
    private String workerName;
    private Integer hoursOfWork;
    private Integer workerAge;
    private Double baseSalary;
    private Double totalSalary;

    Scanner scanner = null;

    private Integer ID;

    // ! -----------------------------------------------------------------------------------------------------|>

    public Worker(String companyName, String NIT, String workerName, Integer hoursOfWork, Integer workerAge,
            Double baseSalary, Double totalSalary, Integer ID) {
        this.companyName = companyName;
        this.NIT = NIT;
        this.workerName = workerName;
        this.hoursOfWork = hoursOfWork;
        this.workerAge = workerAge;
        this.baseSalary = baseSalary;

        // this.calculateTotalSalary();

        this.totalSalary = totalSalary;
        this.ID = ID;
    
        App.logFile(String.format("Getting info of [ %s ]", this.workerName));
    }

    // ! -----------------------------------------------------------------------------------------------------|>

    public Worker() {
        App.printlnInConsole("-", 30);

        this.companyName = App.promptUserForString("Enter the name of your company");
        this.NIT = App.promptUserForString("Enter the NIT (Tax Identification Number) for the worker");
        this.workerName = App.promptUserForString("Enter your name");
        this.hoursOfWork = App.promptUserForInteger("Enter the number of hours worked this month: ");
        this.workerAge = App.promptUserForInteger("Enter your age");
        this.baseSalary = App.promptUserForDouble("Enter your base salary (per hour)");

        this.calculateTotalSalary();

        App.logFile(String.format("New user created [ %s ]", this.workerName));
    }

    // ! -----------------------------------------------------------------------------------------------------|>

    private void calculateTotalSalary() {
        this.totalSalary = this.baseSalary * this.hoursOfWork;
        if (this.hoursOfWork > 40) { this.totalSalary += (this.hoursOfWork - 40) * (this.baseSalary * 1.5); }
    }

    // ! -----------------------------------------------------------------------------------------------------|>

    public void printInfo() {
        App.printlnInConsole("-", 30);

        try {
            System.out.format("ID: %s%n", this.ID);
            System.out.format("Company Name: %s%n", this.companyName);
            System.out.format("NIT: %s%n", this.NIT);
            System.out.format("Worker Name: %s%n", this.workerName);
            System.out.format("Worker Age: %d%n", this.workerAge);
            System.out.format("Base Salary: %f%n", this.baseSalary);
            System.out.format("Total Salary: %f%n", this.totalSalary);

        } catch (Exception e) { System.out.format("Error during printing the info: %s%n", e.getMessage()); }
    }

    // ! -----------------------------------------------------------------------------------------------------|>

    public String getCompanyName() { return this.companyName; }

    public String getNIT() { return this.NIT; }

    public String getWorkerName() { return this.workerName; }

    public Integer getHoursOfWork() { return this.hoursOfWork; }

    public Integer getWorkerAge() { return this.workerAge; }

    public Double getBaseSalary() { return this.baseSalary; }

    public Double getTotalSalary() { return this.totalSalary; }

    // ! -----------------------------------------------------------------------------------------------------|>
    
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public void setNIT(String NIT) { this.NIT = NIT; }
    
    public void setWorkerName(String workerName) { this.workerName = workerName; }
    
    public void setHoursOfWork(Integer hoursOfWork) { this.hoursOfWork = hoursOfWork; }
    
    public void setWorkerAge(Integer workerAge) { this.workerAge = workerAge; }
    
    public void setBaseSalary(Double baseSalary) { this.baseSalary = baseSalary; }
    
    // ! -----------------------------------------------------------------------------------------------------|>
    
    public Integer getID() { return this.ID; }
    
    public void setID(Integer id) { this.ID = id; }

    // ! -----------------------------------------------------------------------------------------------------|>
}
