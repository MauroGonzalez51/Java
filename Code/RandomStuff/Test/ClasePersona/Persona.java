package Code.RandomStuff.Test.ClasePersona;

public class Persona {
    private String nombre, apellido;
    private Integer edad, telefono;

    public Persona(String nombre, String apellido, Integer edad, Integer telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
    }

    public void saludar() { System.out.format("Hola, %s %n", this.nombre); }
    public void despedirse() { 
        System.out.format("Adios, %s %n", this.nombre); 
        if (this.edad >= 18) System.out.println("Soy mayor de edad");
        else System.out.println("Soy menor de edad");
    }

    public String getNombre() { return this.nombre; }
    public String getApellido() { return this.apellido; }
    public Integer getEdad() { return this.edad; }
    public Integer getTelefono() { return this.telefono; }
}