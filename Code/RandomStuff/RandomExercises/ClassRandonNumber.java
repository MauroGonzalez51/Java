package Code.RandomStuff.RandomExercises;

import java.util.Random;

public class ClassRandonNumber {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        // * This generates a random number from 0 to .nextInt(@param)
        int maxRange = 30;
        int intRandom = rand.nextInt(maxRange);


        // * Generates a random from 0.0 to 1.0 (Float)
        float floatRandom = rand.nextFloat();


        // * Generates a random from 0.0 to 1.0 (Double)
        double doubleRandom = rand.nextDouble();

        System.out.println("Int Random: " + intRandom);
        System.out.println("Float Random: " + floatRandom);
        System.out.println("Double Random: " + doubleRandom);
    }
}
