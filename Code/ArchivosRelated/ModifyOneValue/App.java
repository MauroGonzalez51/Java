package Code.ArchivosRelated.ModifyOneValue;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static <T> void mainMenu(ArrayList <T> mainMenuOptions) {
        mainMenuOptions.forEach((option) -> {
            System.out.format("[%d] %s%n", mainMenuOptions.indexOf(option) + 1, option);
        });
    }
    
    private static void dataLoop(FileManagement file) {
        String idToModify = "";
        String fieldToModify = "";
        String newValue = "";
        Scanner scannerIn = null;
        
        ArrayList <String> mainMenuOptions = new ArrayList <>(Arrays.asList(
            "First name", 
            "Last name", 
            "Email address",
            "Gender", 
            "IP address"
        ));
        
        try {
            scannerIn = new Scanner(System.in);
            do {
                System.out.format("ID to modify: ");
                idToModify = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (idToModify.isEmpty());    
        } catch (Exception e) { e.printStackTrace(); }

        mainMenu(mainMenuOptions);

        try {
            scannerIn = new Scanner(System.in);

            do {
                System.out.format("[ ID: %s ] Field to modify: ", idToModify);
                fieldToModify = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (fieldToModify.isEmpty());
        } catch (Exception e) { e.printStackTrace(); }
        
        try {
            scannerIn = new Scanner(System.in);

            do {
                System.out.format("[ ID: %s ] New Value: ", idToModify);
                newValue = (scannerIn.hasNext()) ? scannerIn.next() : "";
            } while (newValue.isEmpty());
        } catch (Exception e) { e.printStackTrace(); }

        if(file.modifyValue(idToModify, fieldToModify, newValue,mainMenuOptions)) {
            file.writeToLog(String.format(
                "Value Changed in [ ID: %s ] : NEW [ %s ] = { %s }", 
                idToModify, 
                mainMenuOptions.get(Integer.parseInt(fieldToModify) - 1), 
                newValue
            ));
        }
    }

    public static void main(String[] args) {
        final Path folderPath = Paths.get("Code/ArchivosRelated/ModifyOneValue/Files");
        final String fileName = "MOCK_DATA.csv";
        FileManagement file = new FileManagement(folderPath, fileName, "//");
        dataLoop(file);
    }
}