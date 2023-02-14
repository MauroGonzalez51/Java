package Code.ArchivosRelated.ReadingCSV;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        final Path filePath = Paths.get("./Code/ArchivosRelated/ReadingCSV/Files/standard-3dZ.csv");
        final Path resultPath = Paths.get("./Code/ArchivosRelated/ReadingCSV/Files/");

        ArrayList <Double> rawDataReaded = new ArrayList <Double> ();
        ArrayList <Double> breakpoints = new ArrayList <Double> ();
        ReadingFile.readFile(filePath, rawDataReaded);
        Breakpoints.createBreakpoints(rawDataReaded, breakpoints);
        long elapsedTime = CategorizeData.categorizeValues(rawDataReaded, breakpoints, resultPath.toRealPath());
        System.out.println("Elapsed time [Categorize Values]: ");
        System.out.println("Milliseconds: " + elapsedTime);
        System.out.println("Seconds: " + (int) Math.floorDiv(elapsedTime, 1000));
    }
}