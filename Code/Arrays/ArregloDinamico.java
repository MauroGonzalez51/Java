package Code.Arrays;

import java.util.ArrayList;

public class ArregloDinamico {
    // * Usando la clase ArrayList

    public static void main(String[] args) throws Exception {
        // ! Metodos

        // ! nombreArrayList.get(posicion);

        // ! nombreArrayList.add("ElementoNuevo");

        // ! nombreArrayList.add(posicion, "ElementoNuevo") > Agregar un elemento en una posicon

        // ! nombreArrayList.set(posicion, "Elemento") > Cambiar un elemento en una posicion en especifico

        // ! nombreArrayList.size();

        // ! nombreArrayList.get(posicion);

        // ! nombreArrayList.exists("Elemento") > return Boolean

        // ! nombreArrayList.indexOf("Elemento") > return Integer

        // ! nombreArrayList.lastIndexOf("Elemento") > return Integer

        // ! nombreArrayList.remove("Elemento") 

        // ! nombreArrayList.remove(posicion)

        // ! nombreArrayList.clear();

        // ! nombreArrayList.isEmpty() > return Boolean
        
        // * Format > ArrayList <tipoDato> nombreArray = new ArrayList <tipoDato>();
        ArrayList <Integer> names = new ArrayList <Integer>();
        names.add(1);
        names.add(2);
        names.add(3);
        names.add(4);
        names.add(5);

        System.out.println(names.get(0));

    }
}
