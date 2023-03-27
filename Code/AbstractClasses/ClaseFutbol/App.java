package Code.AbstractClasses.ClaseFutbol;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList <SeleccionFutbol> integrantes = new ArrayList <>();

        integrantes.add(new Futbolista());
        integrantes.add(new Entrenador());
        integrantes.add(new Masajista());

        integrantes.forEach((integrante) -> {
            System.out.format("%s%n", integrante.getClass());
            integrante.viajar();
            integrante.concentrarse();
            integrante.entrenamiento();
            integrante.partidoFutbol();
            System.out.println();
        });
    }
}