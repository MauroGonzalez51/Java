package Code.ArchivosRelated.ModifyOneValue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement {
    private Path folderPath;
    private Path filePath;
    private String fileName;
    private File fileObj;
    private String charToIgnore;
    private File resultFileObj;

    public Runnable createRunnable(final String processToRun) {
        Runnable handleCase = new Runnable() {
            public void run() {
                switch (processToRun) {
                    case "1": {
                        readingValues();
                        break;
                    }

                    default: System.exit(1);
                }
            }
        };

        return handleCase;
    }

    public FileManagement(Path folderPath, String fileName, String charToIgnore) {
        this.folderPath = folderPath;
        this.fileName = fileName;
        this.charToIgnore = charToIgnore;

        this.filePath = this.folderPath.resolve(fileName);
        this.fileObj = this.filePath.toFile();

        this.resultFileObj = this.folderPath.resolve(fileName).toFile();
    }

    private static String getLocalDate() { LocalDate today = LocalDate.now(); return (today.toString()); }

    private static String getLocalHour() {
        LocalTime localTime = LocalTime.now();
        String toReturn = String.format("%s-%s-%s", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        return toReturn;
    }

    public void writeToLog(final String msgToLog) {
        Path logFilePath = this.folderPath.resolve("LogFile.txt");
        FileWriter writer = null;

        try {
            File logFile = logFilePath.toRealPath().toFile();
            writer = new FileWriter(logFile, true);
            String stringFormat = String.format("[ INFO ] [ %s ] [ %s ] %s%n", getLocalDate(), getLocalHour(), msgToLog);
            writer.write(stringFormat);
            writer.flush();
        } catch (Exception e) { e.printStackTrace(); }
    }

    private ArrayList <String> readingValues() {
        ArrayList <String> readedValues = new ArrayList <>();
        Scanner scannerFile = null;

        try {
            scannerFile = new Scanner(this.fileObj);

            while (scannerFile.hasNextLine()) { readedValues.add(scannerFile.nextLine()); }
        } catch (Exception e) { e.printStackTrace(); }
        scannerFile.close();

        return readedValues;
    }

    private ArrayList <String> separateIdToModify(ArrayList <String> readedValues, String idToModify) {
        // ! [0] > IndexOf(ID) in the list
        ArrayList <String> userToModifyData = new ArrayList <>();
        
        readedValues.forEach((value) -> {
            if (!value.startsWith(this.charToIgnore)) {
                Scanner scannerIndex = null;

                String tempID = "";

                try {
                    scannerIndex = new Scanner(value);
                    scannerIndex.useDelimiter(",");

                    if (scannerIndex.hasNext()) tempID = scannerIndex.next();
                } catch (Exception e) { e.printStackTrace(); }

                if (tempID.equals(idToModify)) userToModifyData.add(Integer.toString(readedValues.indexOf(value)));
            }
        });

        Scanner scannerLine;

        try {
            scannerLine = new Scanner(readedValues.get(Integer.parseInt(userToModifyData.get(0))));
            scannerLine.useDelimiter(",");

            while (scannerLine.hasNext()) { userToModifyData.add(scannerLine.next()); }
        } catch (Exception e) { e.printStackTrace(); }

        return userToModifyData;
    }

    private <T> void createCopyOfFile(ArrayList <T> readedValues, Integer indexToIgnore) {
        try {
            Files.deleteIfExists(this.filePath);
        } catch (IOException e) { e.printStackTrace(); }

        try {
            if (this.resultFileObj.createNewFile()) {
                try {
                    try (FileWriter writer = new FileWriter(this.resultFileObj, true)) {
                        readedValues.forEach((value) -> {
                            try {
                                if (readedValues.indexOf(value) != indexToIgnore)
                                    writer.write(String.format("%s%n", value));
                            } catch (Exception e) { e.printStackTrace();}
                        });
                    }
                } catch (Exception e) { e.printStackTrace(); }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public <T> Boolean modifyValue(String idToModify, String fieldToModify, String newValue, ArrayList <T> dataFields) {
        Boolean success = false;
        this.writeToLog(String.format("Getting the file: %s", this.fileName));
        
        ArrayList <String> readedValues = this.readingValues();
        
        ArrayList <String> userToModifyData = this.separateIdToModify(readedValues, idToModify);
        
        this.createCopyOfFile(readedValues, Integer.parseInt(userToModifyData.get(0)));
        
        userToModifyData.remove(0);
        userToModifyData.set(Integer.parseInt(fieldToModify), newValue);

        String stringFormat = "";

        for (var data : userToModifyData) {
            if (userToModifyData.indexOf(data) != (userToModifyData.size() - 1))
                stringFormat += (data + ",");
        }

        stringFormat += userToModifyData.get(userToModifyData.size() - 1);

        FileWriter writer = null;

        try {
            writer = new FileWriter(this.resultFileObj, true);
            writer.write(String.format("%s%n", stringFormat));
            writer.flush();
            success = true;
        } catch (Exception e) { e.printStackTrace(); }

        return success;
    }
}
