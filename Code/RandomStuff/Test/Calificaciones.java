/**
 *  @autor: MauroGonzalez
 *  œcode: T00067622
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


import java.util.Scanner;

public class Calificaciones {
    public static void ArraysVersion(Integer grade) {
        String valoracion[] = {"Insuficiente", "Deficiente", "Regular", "Buena", "Excelente"};
        try {
            System.out.println(valoracion[grade - 1]);
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido: " + e);
        } 
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Integer notaIngresada = 0;

        do {
            System.out.print("Ingrese una nota: ");
            if (scanner.hasNextInt()) {
                notaIngresada = scanner.nextInt();
                break;
            }
            else System.out.println("El numero ingresado debe ser un entero");
        } while (true);

        String mensaje = "";
        switch (notaIngresada) {
            case 1: { mensaje = "Insuficiente"; break; }
            case 2: { mensaje = "Deficiente"; break; }
            case 3: { mensaje = "Regular"; break; }
            case 4: { mensaje = "Buena"; break; }
            case 5: { mensaje = "Excelente"; break; }
            default:
                System.out.println("Opcion no valida");
        }
        System.out.println(mensaje);
        ArraysVersion(notaIngresada);
        scanner.close();
    }
}