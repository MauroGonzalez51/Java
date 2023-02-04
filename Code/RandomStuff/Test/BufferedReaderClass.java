import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BufferedReaderClass {
    public static void main(String[] args) throws IOException { 
        // * Inicializando el objeto de la clase
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese su nombre: ");

        // ! La wea solo puede leer Strings, despues se usan los Parse's para cambiar de tipo de dato
        String nombre = bf.readLine();
        System.out.println(nombre);
    }
}
