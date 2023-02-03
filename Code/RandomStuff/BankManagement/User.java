package Code.RandomStuff.BankManagement;

import java.util.Scanner;

public class User {
    private String userName;
    private String userID;

    // * Here the constructor is called when an object is created
    public User() {
        Scanner scanner = new Scanner(System.in);

        // ! Getting the userName |>
        do {
            System.out.print("Ingrese su nombre de usuario: ");
            if (scanner.hasNext()) {
                this.userName = scanner.next();
                break;
            } else System.out.println("Error: Debe ingresar al menos una letra");
        } while (true);
        
        // ! Getting the userID |>
        do {
            System.out.print("Ingrese su ID: ");
            if (scanner.hasNext()) {
                this.userID = scanner.next();
                break;
            } else System.out.println("Error: Debe ingresar al menos una letra");
        } while (true);

        scanner.close();
    }

    public String getUserName() { return this.userName; }
    public String getUserID() { return this.userID; }
}
