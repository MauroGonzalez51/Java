package Code.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LoopArray {
    public static void main(String[] args) throws Exception {
        ArrayList <Integer> numeros = new ArrayList <Integer>();
        Random random = new Random();

        // * Agregando datos [1-5]
        for (int i = 1; i < 6; i++) 
            numeros.add(random.nextInt(50));
        
        // * Mostrando todos los elementos del array
        // ! forEach loop
        for (Integer i : numeros) 
            System.out.println(i);
        
        
        System.out.println();

        // * Los organiza alfabetica o numericamente
        Collections.sort(numeros);

        for (Integer i : numeros) 
            System.out.println(i);
        
    }
}
