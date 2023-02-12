package Code.ArchivosRelated.ReadingCSV;

import java.nio.file.Path;
import java.io.File;
// import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadingFile {
    public static void readFile(Path filePath, ArrayList <Double> rawDataReaded) {
        try {
            File file = new File(filePath.toRealPath().toString());
            Scanner fileScanner = new Scanner(file);
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");

                while (lineScanner.hasNext()) {
                    String valueReaded = lineScanner.next();
                    rawDataReaded.add(Double.parseDouble(valueReaded));
                }

                lineScanner.close();
            }
            
            fileScanner.close();
        } catch (Exception e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }
}
