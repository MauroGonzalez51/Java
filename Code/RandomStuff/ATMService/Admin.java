package Code.RandomStuff.ATMService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

class Admin implements ATM {
    private String username, password;
    private Double balance;
    private Scanner scannerIn;

    // * 1. Create the implementation of the interface ATM
    // * 2. Working on the options of the main menu
    // * 3. Re-built a little bit the App.java

    public Admin(String username, String password, Double balance) {
        this.username = username; 
        this.password = password;
        this.balance = balance;
    }

    public Boolean createUserInstance(final Path folderPath) throws IOException { return null; }
    public void checkAdminStatus() throws IOException {}

    private void cleanScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {}
    }

    private void handleCase(String optionIngresed) {
        switch (optionIngresed) {
            
        }
    }

    public void adminMainMenu() {
        String optionIngresed = null;
        List <String> adminActions = List.of(
            "1) Delete an account",
            "2) Clear all files",
            "3) Create a new 'user'",
            "4) Exit"
            );
        
        do {
            this.cleanScreen();
            try {
                this.scannerIn = new Scanner(System.in);

                adminActions.forEach((action) -> {
                    System.out.format("%s%n", action);
                });
    
                do {
                    System.out.format("-> ");
                    optionIngresed = (this.scannerIn.hasNext()) ? this.scannerIn.next() : "4";
                } while (optionIngresed.isEmpty());
                
            } catch (Exception e) {}
            finally {
                this.handleCase(optionIngresed);
            }
        } while (!optionIngresed.equals("4"));
    }

    public void withdrawMoney() {
        this.cleanScreen();
        this.scannerIn = new Scanner(System.in);

        do {
            System.out.format("Amount to withdraw: ");
            Double amountToWithdraw = (scannerIn.hasNextDouble()) ? scannerIn.nextDouble() : 0.0;

            if (amountToWithdraw <= this.balance) {
                this.balance -= amountToWithdraw;
                break;
            }
        } while (true);
    }

    public void addMoney() {
        this.cleanScreen();
        this.scannerIn = new Scanner(System.in);

        do {
            System.out.format("Amount to add: ");
            Double amountToAdd = (scannerIn.hasNextDouble()) ? scannerIn.nextDouble() : 0.0;

            if (amountToAdd >= 0.0) {
                this.balance += amountToAdd;
                break;
            }
        } while (true);
    }

    public void showCurrentMoney() {
        this.cleanScreen();
        System.out.format("Current Money [%s]: %f%n", this.username, this.balance);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {}
    }
}
