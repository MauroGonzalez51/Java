package Code.ArchivosRelated.ReadingCSV;

import java.nio.file.Path;
import java.nio.file.Paths;
import Code.ArchivosRelated.ReadingCSV.ReadingFile;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList <Double> rawDataReaded = new ArrayList <Double> ();
        final Path filePath = Paths.get("./Code/ArchivosRelated/ReadingCSV/Files/standard-3dZ.csv");
        ReadingFile.readFile(filePath, rawDataReaded);
    }
}