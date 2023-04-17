package Code.MetodosEstaticos.ClasePersona;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ArrayList <Persona> personas = new ArrayList <>(Arrays.asList(
            new Persona("Mauro", 17), 
            new Persona("Jose", 21)
        ));

        Persona.edadMayor(personas).printInfo();
    }
}
