package Code.RandomStuff.Test.ClaseCuenta;

import java.util.Scanner;

public class Cuenta {
    private String ownerName;
    private Double balance;

    public Cuenta(String ownerName, Double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public Cuenta(Boolean getBalance) {
        Scanner scanner = new Scanner(System.in);

        System.out.format("Ingrese el nombre de la cuenta: ");
        if (scanner.hasNext())
            this.ownerName = scanner.next();

        if (getBalance) {
            System.out.format("Ingrese el saldo de la cuenta: ");
            if (scanner.hasNextDouble())
                this.balance = scanner.nextDouble();
        } else this.balance = 0.0;
    }

    // ! ---------- Getters ----------|>
    public String getOwnerName() {
        return this.ownerName;
    }

    public Double getBalance() {
        return this.balance;
    }

    // ! ---------- Setters ----------|>
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // * ---------- ClassMethods ---------- |>
    public String insertBalance(Double amount) {
        String returnMessage = "";

        if (amount < 0.0)
            returnMessage = "Cantidad Ingresada negativa - No se agregara a la cuenta";
        else {
            this.balance += amount;
            returnMessage = String.format("Se agrego %s a la cuenta", amount);
        }

        return returnMessage;
    }

    public String withdrawBalance(Double amount) {
        String returnMessage = "";

        if (amount > this.balance)
            returnMessage = "No hay suficiente saldo en la cuenta";
        else {
            this.balance -= amount;
            returnMessage = String.format("Se retiro %s de la cuenta", amount);
        }

        return returnMessage;
    }

    private void checkCases(String optionIngresed) {
        Scanner scanner = new Scanner(System.in);
        switch (optionIngresed) {
            case "1": {
                System.out.format("Saldo actual: %s%n", this.getBalance());
                break;
            }

            case "2": {
                Double amount = 0.0;
                System.out.print("Ingrese la cantidad a agregar: ");
                if (scanner.hasNextDouble()) amount = scanner.nextDouble();

                System.out.println(insertBalance(amount));
                break;
            }

            case "3": {
                Double amount = 0.0;
                System.out.print("Ingrese la cantidad a retirar: ");
                if (scanner.hasNextDouble()) amount = scanner.nextDouble();

                System.out.println(withdrawBalance(amount));
                break;
            }

            default:
                System.exit(0);
        
        }
    }

    public void accountDashboard() {
        Scanner scanner = new Scanner(System.in);
       
        String optionIngresed = "";
        do {
            System.out.println();
            System.out.println("Acciones de la cuenta");
            System.out.println("1. Ver saldo actual");
            System.out.println("2. Agregar saldo");
            System.out.println("3. Retirar saldo");
            System.out.println("4. Salir");
    
    
            System.out.print("-> ");
            optionIngresed = scanner.next();

            this.checkCases(optionIngresed);
        } while (!optionIngresed.equals("4")); 
    }

}
