package Code.RandomStuff.Test.ClaseCuenta;

import java.util.Scanner;

public class Cuenta {
    private String ownerName;
    private Double balance;

    public Cuenta(Boolean getBalance) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.format("Ingrese el nombre de la cuenta: ");
            if (scanner.hasNext())
                this.ownerName = scanner.next();

            if (getBalance) {
                System.out.format("Ingrese el saldo de la cuenta: ");
                if (scanner.hasNextDouble())
                    this.balance = scanner.nextDouble();
            } else this.balance = 0.0;
        }
    
    }
}
