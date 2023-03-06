package Code.RandomStuff.Test.ClaseCuenta;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Clase cuenta");
        Boolean getBalance = null;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.format("Desea ingresar el saldo de la cuenta? (Si/No): ");
            getBalance = (scanner.next().equalsIgnoreCase("Si")) ? true : false;
        } catch (Exception e) { System.out.println(e.getMessage()); }

        Cuenta userAccount = new Cuenta(getBalance);
    }
}
