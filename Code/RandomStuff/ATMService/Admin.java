package Code.RandomStuff.ATMService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

class Admin implements ATM {
    private String username, password;
    private Double balance;
    private Scanner scannerIn;
    private Path adminFilePath = Paths.get("Code/RandomStuff/ATMService/Users/AdminProfiles.txt");
    private Path folderPath = Paths.get("Code/RandomStuff/ATMService/Users/");

    // * 1. Create the implementation of the interface ATM
    // * 2. Working on the options of the main menu
    // * 3. Re-built a little bit the App.java

    public Admin(String username, String password, Double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public Boolean createUserInstance(final Path folderPath) throws IOException {
        return null;
    }

    public void checkAdminStatus() throws IOException {
    }

    private void cleanScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
    }

    private void handleCase(String optionIngresed) {
        switch (optionIngresed) {
            case "1": {
                this.deleteAccount(false);
                break;
            }

            case "2": {
                this.deleteAccount(true);
                break;
            }

            case "3": {
                try {
                    User user = new User(this.folderPath);
                } catch (IOException e) {}
                break;
            }

            case "4": {
                this.withdrawMoney();
                break;
            }

            case "5": {
                this.addMoney();
                break;
            }

            case "6": {
                this.showCurrentMoney();
                break;
            }

            default: System.exit(0);
        }
    }

    public void adminMainMenu() {
        String optionIngresed = null;
        List<String> adminActions = List.of(
                "1) Delete an account",
                "2) Clear all files",
                "3) Create a new 'user'",
                "4) Withdraw money",
                "5) Add money",
                "6) See current money",
                "7) Exit");

        do {
            this.cleanScreen();
            try {
                this.scannerIn = new Scanner(System.in);

                adminActions.forEach((action) -> {
                    System.out.format("%s%n", action);
                });

                do {
                    System.out.format("-> ");
                    optionIngresed = (this.scannerIn.hasNext()) ? this.scannerIn.next() : "7";
                } while (optionIngresed.isEmpty());

            } catch (Exception e) {
            } finally {
                this.handleCase(optionIngresed);
            }
        } while (!optionIngresed.equals("7"));
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
        } catch (InterruptedException e) {
        }
    }

    public Boolean deleteAccount(Boolean deleteAllAcounts) {
        Boolean fileDeleted = false;
        String accountNameToDelete = "";
        this.scannerIn = new Scanner(System.in);

        if (!deleteAllAcounts) {
            do {
                System.out.format("Type the name of the account to delete: ");
                accountNameToDelete = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (accountNameToDelete.isEmpty());
        }
        if (!this.adminFilePath.toFile().getName().equals(accountNameToDelete + ".txt") || deleteAllAcounts) {
            System.out.format("Are u sure (Yes/No)?: ");
            if (scannerIn.next().equalsIgnoreCase("Yes")) {
                if (!deleteAllAcounts) {
                    File userFile = this.folderPath.resolve(accountNameToDelete + ".txt").toFile();

                    if (userFile.isFile()) {
                        userFile.delete();
                        fileDeleted = true;
                    }
                } else {
                    File folder = folderPath.toFile();
                    File[] files = folder.listFiles();

                    if (files != null) {
                        for (File file : files) {
                            if (!file.getName().equals(this.adminFilePath.toFile().getName())) {
                                file.delete();
                            }
                        }

                        fileDeleted = true;
                    }
                }
            }
        }

        return fileDeleted;
    }
}
