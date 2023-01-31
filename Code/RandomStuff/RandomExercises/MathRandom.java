package Code.RandomStuff.RandomExercises;

public class MathRandom {
    public static void main(String[] args) throws Exception {
        int minValue = 50;
        int maxValue = 100;

        //! Format (int) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue)
        int randomNumber = (int) Math.floor(Math.random() * (maxValue - minValue + 1) + minValue);
        System.out.println(randomNumber);
    }
}
