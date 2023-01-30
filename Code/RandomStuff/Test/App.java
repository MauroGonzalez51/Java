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
        // * scanner.nextBoolean() > Boolean


        // * But what if we use scanner.nextInt() and the next value isn't an integer
        // * It throws an Exception :V
        // * So ...
        // * 
        // * This next methods return a boolean for each case
        // * scanner.hasNextBoolean()
        // * scanner.hasNextInt()
        // * scanner.hasNextFloat()
        // * scanner.hasNextDouble()
        // * scanner.hasNextLong()

        System.out.println(number);
    }
}