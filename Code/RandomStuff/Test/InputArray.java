package Code.RandomStuff.Test;

import java.util.Scanner;
import java.util.ArrayList;

public class InputArray {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Integer> numbers = new ArrayList <Integer>();
        Integer amountOfData = 0;
        
        System.out.print("Cantidad de datos: ");
        if (scanner.hasNextInt()) {
            amountOfData = scanner.nextInt();

            if (amountOfData < 0) System.out.println("Error: El numero debe ser positivo");
        }
        else System.out.println("El dato ingresado debe ser un entero");

        for (Integer i = 0; i < amountOfData; i++) {
            System.out.print("Ingrese un valor {" + (i  + 1) + "}: ");
            if (scanner.hasNextInt()) numbers.add(scanner.nextInt());
            else System.out.println("Error: El dato ingresado debe ser entero");
        }

        System.out.println();
        System.out.println("Imprimiendo los datos ...");
        for (var i : numbers) System.out.print(i + " ");
        System.out.println();

        Integer sumatory = 0;
        for (var i : numbers) sumatory += i;
        System.out.println("Sumatoria de los valores: " + sumatory);

        scanner.close();
    }
}
