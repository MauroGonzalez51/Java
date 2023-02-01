package Code.RandomStuff.RandomExercises;

import java.util.Scanner;

public class IMC {
    public static double calculateIMC(float weight, float height) {
        return (weight / (float) Math.pow(height, 2));
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        float weight = 0, height = 0;

        do {
            System.out.print("Ingrese su peso en KG: ");
            if (scanner.hasNextFloat()) weight = scanner.nextFloat();
            else System.out.println("Error al momento de ingresar los datos");
        } while (weight < 0.0);

        do {
            System.out.print("Ingrese su estatura en M: ");
            if (scanner.hasNextFloat()) height = scanner.nextFloat();
            else System.out.println("Error al momento de ingresar los datos");
        } while (height < 0.0);

        System.out.println("Resultado: " + calculateIMC(weight, height));

        scanner.close();
    }
}
