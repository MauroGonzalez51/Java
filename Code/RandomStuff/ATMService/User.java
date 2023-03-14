package Code.RandomStuff.ATMService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements ATM {
    private String username, password;
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
}
