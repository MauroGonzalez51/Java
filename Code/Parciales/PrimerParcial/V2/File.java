package Code.Parciales.PrimerParcial.V2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class File {
    private static String getLocalDate() {
        LocalDate today = LocalDate.now();
        return (today.toString());
    }

    private static void writeLineInFile(String path, Integer n) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(path + getLocalDate())) {
            writer.println();
            for (Integer i = 0; i < n; i++) 
                writer.print("- ");
            writer.println();
        }
    }

    public static void writeToFile(Empleado empleado, Integer i) throws FileNotFoundException {
        String resultFolder = "Files/";
        Integer workerCount = 0;

        try (PrintWriter writer = new PrintWriter(resultFolder + getLocalDate())) {
            writeLineInFile(resultFolder, 44);
            writer.println();
            writer.format("Datos encontrados [%s]%n", getLocalDate());
            
            writeLineInFile(resultFolder, 25);
            writer.format("[%d]%n", workerCount + 1);
            
            writer.format("Datos del empleado [%d]%n", i + 1);
            writer.format("Nombre del empleado: %s%n", empleado.getNombreEmpleado());
            writer.format("Horas trabajadas:  %d%n", empleado.getHorasTrabajadas());
            writer.format("Edad: %d%n", empleado.getEdadEmpleado());
            writer.format("Sueldo total: %f%n", empleado.getSueldoTotal());
        }
    }
}
