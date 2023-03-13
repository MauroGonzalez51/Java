package Code.Herencia.ClasePersona;

public class Freelancer extends Person {
    private String businessType;

    // * @params (String, String, Integer, String, String)
    public Freelancer(String name, String lastName, Integer age, String phone, String businessType) {
        super(name, lastName, age, phone);
        this.businessType = businessType;
    }

    public void showBusinessType() { this.sayHi(); System.out.format("Business Type: %s%n", this.businessType); }

    public String getBusinessType() { return this.businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }
}
