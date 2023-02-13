package Code.RandomStuff.Test.ClasePersona;

public class Persona {
    private String nombre, apellido;
    private Integer edad, telefono;



    public void saludar() { System.out.format("Hola, %s %n", this.nombre); }
    public void despedirse() { 
        System.out.format("Adios, %s %n", this.nombre); 
        if (this.edad >= 18) System.out.println("Soy mayor de edad");
        else System.out.println("Soy menor de edad");
    }
}