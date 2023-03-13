package Code.Herencia.ClasePersona;

public class Student extends Person {
    private String collegeName;
    
    // * @params (String, String, Integer, String, String)
    public Student(String name, String lastName, Integer age, String phone, String collegeName) {
        super(name, lastName, age, phone);
        this.collegeName = collegeName;
    }

    @Override
    public void showCollegeName() { this.sayHi(); System.out.format("College Name: %s%n", this.collegeName); }

    public String getCollegeName() { return this.collegeName; }
    public void setCollegeName(String val) { this.collegeName = val; }

}
