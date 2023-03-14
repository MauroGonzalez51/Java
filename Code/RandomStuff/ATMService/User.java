package Code.RandomStuff.ATMService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class User extends ATM {
    private String username, password;
    private Boolean AdminStatus = false;

    private Scanner scannerIn;

    public User(Path userFolderPath) throws IOException {
        this.scannerIn = new Scanner(System.in);

        try {
            do {
                System.out.format("%nIngrese su nombre de usuario: ");
                this.username = (this.scannerIn.hasNext()) ? this.scannerIn.next() : "";
            } while (this.username.isEmpty());

            do {
                System.out.format("Ingrese su contraseña: ");
                this.password = (this.scannerIn.hasNext()) ? this.scannerIn.next() : "";
            } while (this.password.isEmpty());
        } catch (Exception e) {
        }

        this.createUserInstance(userFolderPath);
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ! Body Methods from ATM

    @Override
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

}
