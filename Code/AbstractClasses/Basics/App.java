import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        
        // ! Clases abstractas

        // * NO se pueden crear objetos de la clase 
        // * Los metodos abstractos (Solo se pueden declaran dentro de clases abstractas) no tienen un cuerpo
        // * El cuerpo lo reciben de la clase Heredada

        ArrayList <Animal> animales = new ArrayList <>();
        animales.add(new Perro());
        animales.add(new Gato());
        animales.add(new Leon());
        animales.add(new Lobo());

        animales.forEach((animal) -> {
            System.out.format("%s%n", animal.getClass());
            System.out.format("%s%n", animal.getNombreCientifico());
            System.out.format("%s%n", animal.getSonidos());
            System.out.format("%s%n", animal.getAlimentos());
            System.out.format("%s%n", animal.getHabitat());
            System.out.println();
        });
    }
}