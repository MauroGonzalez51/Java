package Code.RandomStuff.Test;

import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // ! Seems to be like the 'Arrow' functions in JS
        numbers.forEach((n) -> {
            System.out.format("%d%n", n);
        });
    }
}
