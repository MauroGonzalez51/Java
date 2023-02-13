package Code.RandomStuff.Test;

/**
 *  @autor: MauroGonzalez
 *  @code: T00067622
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.util.Scanner;

public class Factorial {
    public static Integer factorial(Integer valueIngresed) {
        Integer returnValue = 1;
        for (Integer i = 1; i <= valueIngresed; i++) returnValue *= i;
        return returnValue;
    }

    public static Integer factorialRecursion(Integer valueIngresed) {
        if (valueIngresed <= 1) return 1;
        else return (valueIngresed * factorialRecursion(valueIngresed - 1));
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Integer valueIngresed = 0;
        do {
            System.out.print("Ingrese un valor: ");
            if (scanner.hasNextInt()) {
                valueIngresed = scanner.nextInt();
                break;
            } else System.out.println("Ingrese un valor valido");
        } while (valueIngresed < 1);
        System.out.println("Factorial: " + factorial(valueIngresed));
        System.out.println("Factorial Recursion: " + factorialRecursion(valueIngresed));
        scanner.close();
    }    
}
