package Code.RandomStuff.RandomExercises;

import java.util.Scanner;

public class IMC {
    public static float calculateIMC(float weight, float height) {
        return (weight / (float) Math.pow(height, 2));
    }

    public static String categorizeIMC(float userIMC) {
        String userClasification = "";

        float[] breakpoints = {18.5f, 24.9f, 29.9f, 30, 
            34.9f, 39.5f, 40};

        String[] clasification = {"Bajo Peso", "Normal", "Sobrepeso", 
            "Obesidad", "Obesidad I", "Obesidad II", "Obesidad III"};

        for (Integer i = 0; i < breakpoints.length; i++) {
            if (i != (breakpoints.length - 1)) {
                if (userIMC < breakpoints[i]) {
                    userClasification = clasification[i];
                    break;
                }
            } else {
                if (userIMC > breakpoints[breakpoints.length - 1]) {
                    userClasification = clasification[i];
                    break;
                }
            }
        }

        return userClasification;
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

        System.out.println();
        float userIMC = calculateIMC(weight, height);
        System.out.println("IMC: " + userIMC);
        System.out.println("Clasificacion: " + categorizeIMC(userIMC));
        
        scanner.close();
    }
}
