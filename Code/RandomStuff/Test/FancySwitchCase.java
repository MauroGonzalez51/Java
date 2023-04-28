package Code.RandomStuff.Test;

import java.util.HashMap;

public class FancySwitchCase {
    private static void handleCase(String optionIngresed) {
        HashMap <String, Runnable> options = new HashMap <> () {{
            put("1", () -> { System.out.println("Caso 1"); });
            put("2", () -> { System.out.println("Caso 2"); });
            put("3", () -> { System.out.println("Caso 3"); });
            put("4", () -> { System.out.println("Caso 4"); });
            put("default", () -> { System.out.println("Caso 5"); });
        }};

        options.getOrDefault(optionIngresed, options.get("default")).run();
    }

    public static void main(String[] args) throws Exception {
        handleCase("1");
    }
}