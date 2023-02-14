package Code.ArchivosRelated.ReadingCSV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class CategorizeData {
    private static void deleteOldFiles(Path folderPath, ArrayList <Double> breakpoints) {
        for (var fileName : breakpoints) {
            File file = new File(folderPath + "/" + fileName.toString() + ".txt");
            if (file.exists()) file.delete();
        }
    }

    private static void createNewFiles(Path folderPath, ArrayList <Double> breakpoints) throws IOException {
        for (var fileName : breakpoints) {
            File file = new File(folderPath + "/" + fileName.toString() + ".txt");
            file.createNewFile();
        }
    }

    private static void writeToFile(Double valueToWrite, Path folderPath, String fileName) throws IOException {
        FileWriter writer = new FileWriter(folderPath + "/" + fileName.toString() + ".txt", true);
        writer.write(valueToWrite.toString() + ", ");
        writer.close();
    }

    public static Long categorizeValues(ArrayList <Double> rawDataReaded, ArrayList <Double> breakpoints, Path resultPath) throws IOException {
        deleteOldFiles(resultPath, breakpoints);
        createNewFiles(resultPath, breakpoints);

        long startTime = System.currentTimeMillis();
        for (var valueManager : rawDataReaded) {
            for (var breakpointManager : breakpoints) {
                if (valueManager <= breakpointManager) {
                    writeToFile(valueManager, resultPath, breakpointManager.toString());
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
}
