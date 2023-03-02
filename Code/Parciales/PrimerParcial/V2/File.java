package Code.Parciales.PrimerParcial.V2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class File {

    // ! Method to get the LocalDate as the name suggests
    private static String getLocalDate() { LocalDate today = LocalDate.now(); return (today.toString()); }

    // ! Method to get the LocalDate > Hours > Minutes > Seconds 
    private static String getLocalHour() {
        LocalTime localTime = LocalTime.now();
        String toReturn = String.format("%s-%s-%s", localTime.getHour(), localTime.getMinute(), localTime.getSecond());
        return toReturn;
    }

    // ! Method that does all the WritingToFile stuff
    public static String writeToFile(Empleado empleado, Integer i) throws FileNotFoundException {
        String resultFolder = "Code/Parciales/PrimerParcial/V2/Files/";

        // * Just to count in the file ==> More visible
        Integer workerCount = 0;

        // * NameOfTheFile so the user knows in which file is the info
        String fileNameToReturn = String.format("%s-%s", getLocalDate(), getLocalHour());

        // ! Try-with-resources block :D
        try (PrintWriter writer = new PrintWriter(resultFolder + getLocalDate() + "-" + getLocalHour() + ".txt")) {

            // * And then prints everything into the file
            writer.println();
            writer.format("Datos encontrados [%s]%n", getLocalDate());
            
            writer.format("[%d]%n", workerCount + 1);
            
            writer.format("Datos del empleado [%d]%n", i + 1);
            writer.format("Nombre del empleado: %s%n", empleado.getNombreEmpleado());
            writer.format("Horas trabajadas:  %d%n", empleado.getHorasTrabajadas());
            writer.format("Edad: %d%n", empleado.getEdadEmpleado());
            writer.format("Sueldo total: %f%n", empleado.getSueldoTotal());
        }

        return fileNameToReturn;
    }
}
