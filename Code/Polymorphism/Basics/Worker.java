package Code.Polymorphism.Basics;

public class Worker extends Person {
    private Integer hoursOfWork;

    // * @params (String, String, Integer, String, Integer)
    public Worker(String name, String lastName, Integer age, String phone, Integer hoursOfWork) {
        super(name, lastName, age, phone);
        this.hoursOfWork = hoursOfWork;
    }

    public void showHoursOfWork() { this.sayHi(); System.out.format("Hours of Work: %d%n", this.hoursOfWork); }

    public Integer getHoursOfWork() { return this.hoursOfWork; }
    public void setHoursOfWork(Integer hoursOfWork) { this.hoursOfWork = hoursOfWork; }

    @Override 
    public void mostrarDeudas() { System.out.format("Deudas de menos de un millon de pesos%n"); }
}
