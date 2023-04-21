package Code.Database.WorkersManagement;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static Scanner scanner = null;

    // ! --------------------------------------------------------------------------------------------------------------------------|>

    public static void printlnInConsole(String charToPrint, Integer amount) {
        System.out.println();
        for (Integer i = 0; i < amount; i++)
        System.out.print(charToPrint);
        System.out.println();
    }
    
    // ! --------------------------------------------------------------------------------------------------------------------------|>
    
    private static Path logFilePath = Paths.get("Code/Database/WorkersManagement/files/logFile.txt");
    
    // * ------------------------------------------------------------------------------|>
    
    private static String getLocalDate() {
        LocalDate today = LocalDate.now();
        return (today.toString());
    }
    
    // * ------------------------------------------------------------------------------|>
    
    private static String getLocalHour() {
        LocalTime localTime = LocalTime.now();
        String toReturn = String.format("%s-%s-%s", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        return toReturn;
    }

    // * ------------------------------------------------------------------------------|>
    
    private static void logFile() {
        FileWriter writer = null;
        try {
            File logFile = logFilePath.toRealPath().toFile();
            writer = new FileWriter(logFile, true);
            
            writer.write(String.format("%n"));
            for (Integer i = 0; i < 80; i++)
            writer.write("-");
            writer.write(String.format("%n"));
            
            String stringFormat = String.format("[ INFO ] [ %s ] [ %s ] Session started%n", getLocalDate(),
            getLocalHour());
            writer.write(stringFormat);
            writer.flush();
        } catch (Exception e) { System.out.format("Error during initializating logFile: %s%n", e.getMessage()); }
    }
    
    // * ------------------------------------------------------------------------------|>
    
    public static void logFile(String message) {
        FileWriter writer = null;
        try {
            File logFile = logFilePath.toRealPath().toFile();
            writer = new FileWriter(logFile, true);
            String stringFormat = String.format("[ INFO ] [ %s ] [ %s ] %s%n", getLocalDate(), getLocalHour(), message);
            writer.write(stringFormat);
            writer.flush();
        } catch (Exception e) { System.out.format("Error during writing to log: %s%n", e.getMessage()); }
    }

    // ! --------------------------------------------------------------------------------------------------------------------------|>
    
    private static String mainMenu() {
        final String[] optionIngresed = { null };
        ArrayList<String> listOptions = new ArrayList<>(
            Arrays.asList("Add a new Worker", "Search by ID","Update a previous register", "Delete a Worker", "Exit"
            ));
            
        listOptions.forEach((option) -> {
            System.out.format("%s) %s%n", listOptions.indexOf(option) + 1, option);
        });
        
        optionIngresed[0] = promptUserForString("Enter an option");

        return optionIngresed[0];
    }
        
    // ! --------------------------------------------------------------------------------------------------------------------------|>
    
    private static void handleCase(String optionIngresed) {
        switch (optionIngresed) {
            case "1": {
                addWorker();
                break;
            }

            case "2": {
                searchByParameters();
                break;
            }

            case "3": {
                updateInDatabase();
                break;
            }

            case "4": {
                deleteInDatabase();
                break;
            }
            
            default: System.exit(0);
        }
    }
    
    // ! --------------------------------------------------------------------------------------------------------------------------|>
    
    private static void mainMenuLoop() {
        do {
            printlnInConsole("-", 30);
            handleCase(mainMenu());
        } while (true);
    }
    
    // ! --------------------------------------------------------------------------------------------------------------------------|>
    
    private static void addWorker() {
        try {
            SQLConnection sqlConnection = new SQLConnection("javatesting", "root", "", "localhost", "3306");
            Worker worker = new Worker();
            if (sqlConnection.insertUsers(new ArrayList <Worker> (Arrays.asList(worker))))
            logFile(String.format("Successfully inserted into database [ %s ]", worker.getWorkerName()));
        } catch (Exception e) { System.out.format("Error during creating a new Worker: %s%n", e.getMessage()); }
    }
    
    // * ------------------------------------------------------------------------------|>

    private static void searchByParameters() {
        try {
            SQLConnection sqlConnection = new SQLConnection("javatesting", "root", "", "localhost", "3306");
            
            ArrayList <Worker> resultArrayListFromSearch = sqlConnection.searchByParam(promptUserForInteger("Enter the ID"));

            if (resultArrayListFromSearch.size() > 0) {
                resultArrayListFromSearch.forEach((worker) -> {
                    worker.printInfo();
                });
            } else { System.out.format("There's no data in the database for this worker"); }
            
            
        } catch (Exception e) { System.out.format("Error during gattering the info: %s%n", e.getMessage()); }
    }

    // * ------------------------------------------------------------------------------|>
    
    private static void updateInDatabase() {
        try {
            SQLConnection sqlConnection = new SQLConnection("javatesting", "root", "", "localhost", "3306");
            
            final Integer[] idToModify = { promptUserForInteger("Enter the ID from the user to modify") };

            ArrayList <Worker> resultArrayListFromSearch = sqlConnection.searchByParam(idToModify[0]);

            if (resultArrayListFromSearch.size() > 0) {
                resultArrayListFromSearch.forEach((worker) -> {
                    worker.printInfo();
                });

                if (promptUserForString("Wanna modify them?").equalsIgnoreCase("Yes")) {
                    Worker worker = new Worker();

                    sqlConnection.updateInDatabase(idToModify[0], worker).forEach((operation, rows) -> {
                        System.out.format("Success: %b%n", operation);
                        System.out.format("Rows updated: %d%n", rows);
                    });
                }

            } else { System.out.format("There's no data in the database for this worker"); }
            
        } catch (Exception e) { System.out.format("Error during taking input: %s%n", e.getMessage()); }
    }

    // * ------------------------------------------------------------------------------|>

    private static void deleteInDatabase() {
        try {
            SQLConnection sqlConnection = new SQLConnection("javatesting", "root", "", "localhost", "3306");

            Integer idToDelete = promptUserForInteger("Enter the ID to delete");

            if (promptUserForString("Are you sure?").equalsIgnoreCase("Yes")) {
                if (sqlConnection.deleteInDatabase(idToDelete)) {
                    System.out.format("[ Worker ] deleted successfully%n");
                    logFile(String.format("Worker deleted [ %d ]", idToDelete));
                }
            }

        } catch (Exception e) { System.out.format("Error during taking input: %s%n", e.getMessage()); }
    }
    
    // ! --------------------------------------------------------------------------------------------------------------------------|>
    
    public static String promptUserForString(String message) {
        final String[] userInput = { null };
        try {
            do {
                scanner = new Scanner(System.in);
                System.out.format("%s: ", message);
                userInput[0] = (scanner.hasNext()) ? scanner.nextLine() : "";
            } while (userInput[0].isEmpty());
        } catch (Exception e) { System.out.format("Error during data insertion: %s%n", e.getMessage()); }

        return userInput[0];
    }

    // * ------------------------------------------------------------------------------|>
    
    public static Integer promptUserForInteger(String message) {
        final Integer[] userInput = { null };
        try {
            scanner = new Scanner(System.in);
            do {
                System.out.format("%s: ", message);
                userInput[0] = (scanner.hasNextInt()) ? scanner.nextInt() : 0;
            } while (userInput[0] <= 0);
        } catch (Exception e) { System.out.format("Error during data insertion: %s%n", e.getMessage()); }
        
        return userInput[0];
    }

    // * ------------------------------------------------------------------------------|>

    public static Double promptUserForDouble(String message) {
        final Double[] userInput = { null };
        try {
            scanner = new Scanner(System.in);
            do {
                System.out.format("%s: ", message);
                userInput[0] = (scanner.hasNextDouble()) ? scanner.nextDouble() : null;
                if (userInput[0] != null && userInput[0] <= 0.0) {
                    userInput[0] = null;
                }
            } while (userInput[0] == null);
        } catch (Exception e) { System.out.format("Error during insertion: %s%n", e.getMessage()); }
        return userInput[0];
    }

    // ! --------------------------------------------------------------------------------------------------------------------------|>
    
    public static void main(String[] args) {
        logFile();
        mainMenuLoop();
    }
}
