package Code.Polymorphism.Basics;

abstract class Person {
    private String name;
    private String lastName;
    private Integer age;
    private String phone;

    // * @params (String, String, Integer, String)
    public Person(String name, String lastName, Integer age, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    public void sayHi() { System.out.format("Hi, %s%n", this.name); }

    public String getName() { return this.name; }
    public String getLastName() { return this.lastName; }
    public Integer getAge() { return this.age; }
    public String getPhone() { return this.phone; }

    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(Integer age) { this.age = age; }
    public void setPhone(String phone) { this.phone = phone; }

    public void showCollegeName() { }

    public void mostrarDeudas() { System.out.format("Deudas [...]%n"); }
    
}

