package Code.RandomStuff.Test.ClaseCuenta;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String userOption = "";

        System.out.println("Clase cuenta");

        System.out.print("Desea ingresar el saldo? (Si/No): ");
        if (scanner.hasNext()) userOption = scanner.next();

        Boolean askBalance = (userOption.equalsIgnoreCase("Si")) ? true : false;

        Cuenta userAccount = new Cuenta(askBalance);

        System.out.println(userAccount.getBalance());

        userAccount.accountDashboard();
        
        scanner.close();
    }
}
