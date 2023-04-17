package Code.MetodosEstaticos.ClasePersona;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public static Persona edadMayor (ArrayList <Persona> personas) {
        final Integer[] flagMayor = { 0 };
        final Integer[] indexToReturn = { null };

        personas.forEach((persona) -> {
            if (persona.getEdad() > flagMayor[0]) {
                flagMayor[0] = persona.getEdad();
                indexToReturn[0] = personas.indexOf(persona);
            }
        });

        return personas.get(indexToReturn[0]);
    }

    public Integer getEdad() { return this.edad; }
    public void printInfo() {
        System.out.format("Nombre: %s%n", this.nombre);
        System.out.format("Edad: %s%n", this.edad.toString());
    }
}