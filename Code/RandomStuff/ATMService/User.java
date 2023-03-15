package Code.RandomStuff.ATMService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements ATM {
    private String username, password;
    private Double balance;
    private Boolean adminStatus = false;

    private Scanner scannerIn;

    public User(Path userFolderPath) throws IOException {
        this.scannerIn = new Scanner(System.in);

        try {
            do {
                System.out.format("%nWrite your [Username]: ");
                this.username = (this.scannerIn.hasNext()) ? this.scannerIn.next() : "";
            } while (this.username.isEmpty());

            do {
                System.out.format("Write your [Password]: ");
                this.password = (this.scannerIn.hasNext()) ? this.scannerIn.next() : "";
            } while (this.password.isEmpty());

            do {
                System.out.format("Write your [Balance][Initial]: ");
                this.balance = (this.scannerIn.hasNextDouble()) ? this.scannerIn.nextDouble() : -1.0;
            } while (this.balance < 0.0);
        } catch (Exception e) {}

        this.checkAdminStatus();

        if (!this.adminStatus)
            this.createUserInstance(userFolderPath);
    }

    public String getUsername() { return this.username; }
    public String getPassword() { return this.password; }
    public Boolean getAdminStatus() { return this.adminStatus; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

    private void cleanScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {}
    }

    private void handleCase(String optionIngresed) {
        switch (optionIngresed) {
            case "1": {
                this.withdrawMoney();
                break;
            }

            case "2": {
                this.addMoney();
                break;
            }

            case "3": {
                this.showCurrentMoney();
                break;
            }

            case "4": {
                System.out.format("[INFO] Account Deleted: %b%n", this.deleteAccount());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {}
                break;
            }
        }
    }

    public void userMainMenu() {
        String optionIngresed = null;
        List <String> adminActions = List.of(
            "1) Withdraw money",
            "2) Add money",
            "3) Show current money",
            "4) Delete the account",
            "5) Exit"
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
                    optionIngresed = (this.scannerIn.hasNext()) ? this.scannerIn.next() : "5";
                } while (optionIngresed.isEmpty());
                
            } catch (Exception e) {}
            finally {
                this.handleCase(optionIngresed);
            }
        } while (!optionIngresed.equals("5"));
    }

    // ! Body Methods from ATM
    public Boolean createUserInstance(final Path folderPath) throws IOException {
        boolean fileCreated = false;
        Path filePath = folderPath.resolve(this.username + ".txt");

        try {
            File file = filePath.toFile();
            if (file.createNewFile()) {
                FileWriter writer = null;
                try {
                    writer = new FileWriter(file, true);
                    
                    String stringToFile = String.format("%s%n%s%n", this.username, this.password);
                    writer.write(stringToFile);

                    writer.flush();
                    fileCreated = true;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (writer != null) {
                        writer.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileCreated;
    }

    public void checkAdminStatus() throws FileNotFoundException {
        Path filePath = Paths.get("Code/RandomStuff/ATMService/Users/AdminProfiles.txt");

        File file = filePath.toFile(); 

        ArrayList <String> adminUsernames = new ArrayList <String>();
        ArrayList <String> adminPasswords = new ArrayList <String>();

        try (Scanner scannerFile = new Scanner(file)) {
            while (scannerFile.hasNextLine()) {
                String fileLine = scannerFile.nextLine();

                if (!fileLine.startsWith("//")) {
                    try (Scanner scannerLine = new Scanner(fileLine)) {
                        scannerLine.useDelimiter(",");

                        while (scannerLine.hasNext()) {
                            adminUsernames.add(scannerLine.next());
                            adminPasswords.add(scannerLine.next());
                        }
                    }
                }
            }
        }
        
        for (Integer i = 0; i < adminUsernames.size(); i++) {
            if (this.username.equals(adminUsernames.get(i)) && this.password.equals(adminPasswords.get(i))) {
                this.adminStatus = true;
                break;
            }
        }
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

    public Boolean deleteAccount() {
        Boolean fileDeleted = false;
        Path folderPath = Paths.get("Code/RandomStuff/ATMService/Users/");
        File userFile = folderPath.resolve(this.username + ".txt").toFile();

        this.scannerIn = new Scanner(System.in);

        System.out.format("Are u sure (Yes/No)?: ");
        if (scannerIn.next().equalsIgnoreCase("Yes")) {
            if (userFile.isFile()) { 
                userFile.delete(); 
                fileDeleted = true; 
            }
        }
        
        return fileDeleted;
    }
}
