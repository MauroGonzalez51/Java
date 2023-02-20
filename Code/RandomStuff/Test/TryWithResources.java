package Code.RandomStuff.Test;

import java.util.Scanner;

public class TryWithResources {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Text output: ");
            String input = scanner.next();
            System.out.format("%s%n", input);

        } catch (Exception e) { System.out.println(e.getMessage()); }
    }
}
