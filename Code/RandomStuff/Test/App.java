import javax.swing.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // * Testing the scanner stuff, this way is "easier" to input values

        // This is the way to setup the scanner class > Yep, it's a class
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un numero: ");

        // * There's a way to enter every type of data
        Integer number = sc.nextInt();

        // * scanner.nextLine() > String's
        // * scanner.nextInt() > Integers
        // * scanner.next().charAt(0) > Char
        // * scanner.nextDouble() > Double
        // * scanner.nextLong() > Long

        System.out.println(number);
    }
}