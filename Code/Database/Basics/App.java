package Code.Database.Basics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class App {
    private static void writeLineInConsole(Integer n) {
        System.out.println();
        for (Integer i = 0; i < n; i++) 
            System.out.format("- ");
        System.out.println();
    }

    private static String getLocalDate() { LocalDate today = LocalDate.now(); return (today.toString()); }

    private static String getLocalHour() {
        LocalTime localTime = LocalTime.now();
        String toReturn = String.format("%s-%s-%s", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        return toReturn;
    }

    private static Boolean writeToLogFile(Path logFilePath, String workerName) throws IOException {
        Boolean success = false;
        String localTime = String.format("%s-%s", getLocalDate(), getLocalHour());

        File logFile = new File(logFilePath.toString());

        if (!logFile.exists()) logFile.createNewFile();

        try (FileWriter writer = new FileWriter(logFile, true)) {
            String temp = String.format(
                "[ INFO ] [ %s ] Data recieved -> Sending to DataBase [ WorkerName: %s ]%n", localTime, workerName);
            writer.write(temp); 

            success = !success;
        }

        return success;
    }

    private static void dataLoop(Worker worker) throws IOException {
        String userInput = "";

        Integer userIntegerCount = 0;
        Scanner scannerIn = new Scanner(System.in);

        Path logFilePath = Paths.get("Code/Database/Basics/Files/logFile.txt");

        try (scannerIn) {
            
            do {
                writeLineInConsole(25);
                
                worker = new Worker(userIntegerCount, userIntegerCount);
                
                do {
                    System.out.format("%nRepetir el proceso (Si/No)?: ");
                    userInput = (scannerIn.hasNext()) ? scannerIn.next() : "";
                } while (userInput.isEmpty());
                
                if (userInput.equalsIgnoreCase("No")) break;
                else {
                    userIntegerCount++;
                    if (writeToLogFile(logFilePath, worker.getWorkerName())) { 
                        System.out.format("[ INFO ] Sending info to Database%n");
                    } else System.out.format("[ INFO ] Error during sending the info%n");
                }
                
            } while (true);
        } catch (Exception e) {}
    }

    public static void main(String[] args) throws Exception {
        Worker worker = null;
        dataLoop(worker);
    }
}
