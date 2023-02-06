package Code.RandomStuff.RandomExercises;

import java.util.ArrayList;

public class RandomFromArray {
    public static void main(String[] args) throws Exception {
        ArrayList <Integer> numbers = new ArrayList <Integer>();

        for (Integer i = 0; i < 100; i++)
            numbers.add(i);
            
        System.out.println(numbers.size());

        System.out.println(numbers.get((int) Math.floor(Math.random() * numbers.size())));
        


    }
}