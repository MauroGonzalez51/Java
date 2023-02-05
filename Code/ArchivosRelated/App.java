package Code.ArchivosRelated;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        PrintWriter salida = null;

        try {
            salida = new PrintWriter("C:/Users/Mauro Gonzalez/Documents/Java/Code/ArchivosRelated/file.txt");
            String cadena;
            System.out.println("Introduce Texto. Para acabar introduce la cadena FIN: ");
            cadena = scanner.next();

            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);
                cadena = scanner.next();
            }
        } catch (FileNotFoundException e) { 
            System.out.println(e.getMessage());
        } finally { salida.close(); }

        scanner.close();
    }
}
