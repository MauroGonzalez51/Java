package Code.Async.Basics;

import java.util.concurrent.CompletableFuture;

public class App {
    private static void elevarAlCuadrado(Double n) {
        CompletableFuture <Double> result = CompletableFuture.supplyAsync(() -> {
            Double response = Math.pow(n, 2); return response;
        });

        while(!result.isDone()) {
            System.out.format("Tarea en ejecucion ...%n");
        }
        result.thenAccept(response -> { 
            System.out.format("Resultado: %f%n", response);
        });

    }

    public static void main(String[] args) {
        elevarAlCuadrado(5.0);
    }
}
