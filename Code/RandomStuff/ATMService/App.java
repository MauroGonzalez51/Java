package Code.RandomStuff.ATMService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    private static void printlnInConsole(String charOut, Integer n){  
        System.out.println();
        for (Integer i = 0; i < n; i++)
            System.out.format("%s", charOut);
    }

    private static void loop(final Path userFolderPath) throws IOException {
        printlnInConsole("-", 40);

        User user = new User(userFolderPath);

        if (user.getAdminStatus()) {
            System.out.format("[INFO] Switching to Admin%n");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
            Admin admin = new Admin(user.getUsername(), user.getPassword(), user.getBalance());
            admin.adminMainMenu();
        } else 
            user.userMainMenu();

    }

    public static void main(String[] args) throws IOException {
        final Path userFolderPath = Paths.get("Code/RandomStuff/ATMService/Users/");
        loop(userFolderPath);
    }
}
