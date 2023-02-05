package Code.RandomStuff.BankManagement;

import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BankAccount {
    private double userBalance = 0;
    private String customerName;
    private String customerID;

    public BankAccount(String userName, String userID) {
        this.customerName = userName;
        this.customerID = userID;
    }

    public void depositMoney(double amount) {
        if (amount != 0) this.userBalance += amount;
    }

    public String retireMoney(double amountToRetire) {
        String returnMessage = "";
        if (amountToRetire > this.userBalance) returnMessage = "Dinero Insuficiente";
        else {
            userBalance -= amountToRetire;
            returnMessage = "Transaccion realizada correctamente";
        }

        return returnMessage;
    }

    private void printLineInConsole(Integer amountOfCharacters) {
        System.out.println();
        for (Integer i = 0; i < amountOfCharacters; i++) 
            System.out.print("* ");
        
        System.out.println();
    }

    public void caseChecker(final String optionIngresed) {
        Scanner scanner = new Scanner(System.in);
        switch (optionIngresed) {
            case "1": {
                this.printLineInConsole(20);
                System.out.println("Balance Actual: " + this.userBalance);
                break;
            }

            case "2": {
                this.printLineInConsole(20);

                double tempValue = 0.0;
                do {
                    System.out.print("Digite la cantidad de dinero a ingresar: ");
                    if (scanner.hasNextDouble()) {
                        tempValue = scanner.nextDouble();
                        break;
                    } else System.out.println("Error: El valor ingresado debe ser un numero");

                } while (true);

                this.depositMoney(tempValue);
                break;
            }

            case "3": {
                this.printLineInConsole(20);

                double tempValue = 0.0;
                do {
                    System.out.print("Digite la cantidad de dinero a retirar: ");
                    if (scanner.hasNextDouble()) {
                        tempValue = scanner.nextDouble();
                        break;
                    } else System.out.println("Error: El valor ingresado debe ser un numero");
                } while (true);

                System.out.println("Resultado de la operacion: " + this.retireMoney(tempValue));
                break;
            }

            default: {
                System.out.println("Ingrese una opcion correcta para continuar");
                break;
            }
        }
        scanner.close();
    }

    public void mainMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenid@, " + this.customerName);
        System.out.println("ID: " + this.customerID);
        System.out.println("\n");
        
        System.out.println("1) Revisar balance actual");
        System.out.println("2) Ingresar Dinero");
        System.out.println("3) Retirar Dinero");
        System.out.println("4) Salir");

        String optionIngresed;
        do {
            this.printLineInConsole(30);
            
            System.out.print("Ingrese una opcion: ");
            optionIngresed = scanner.next();
            
            caseChecker(optionIngresed);

            if (optionIngresed.equals("4")) break;

        } while (true);
        scanner.close();
    }
}
