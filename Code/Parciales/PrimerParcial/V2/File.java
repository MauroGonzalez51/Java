package Code.Parciales.PrimerParcial.V2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class File {
    private static String getLocalDate() {
        LocalDate today = LocalDate.now();
        return (today.toString());
    }

    public static Boolean writeToFile(Empleado empleado, Integer i) throws FileNotFoundException {
        Boolean success = false;
        String resultFolder = "Files/";
        PrintWriter writer = new PrintWriter(resultFolder + getLocalDate());






        return success;
    }
}
