package Code.RandomStuff.Test;

/**
 *  @autor: Mauro Gonzalez
 *  @code: T00067622
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class NotasEstudiantes {
    public static Boolean validateGrade(Double studentGrade) {
        return ((studentGrade >= 3.0) ? true : false);
    }

    public static double generalAverage(ArrayList <Double> finalGrades) {
        double generalAverageValue = 0.0;
        for (var i : finalGrades) { generalAverageValue += i; }
        return (generalAverageValue /= finalGrades.size());
    }

    public static void readInfo(Integer amountsOfStudents) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Double> finalGrades = new ArrayList <Double>();
        for (Integer indexStudents = 0; indexStudents < amountsOfStudents; indexStudents++) {
            System.out.println();
            System.out.println("Estudiante " + (indexStudents + 1));
            String msgOutput[] = {"Taller", "Quiz", "Parcial"};
            ArrayList <Double> studentsGrades = new ArrayList <Double> ();

            for (Integer indexGrades = 0; indexGrades < 3; indexGrades++) {
                do {
                    System.out.print(msgOutput[indexGrades] + ": ");
                    if (scanner.hasNextDouble()) { studentsGrades.add(scanner.nextDouble()); break; }
                    else System.out.println("Ingrese una opcion valida");
                } while (true);
            }

            Double studentFinalNote = 0.0;
            for (var grade : studentsGrades) { studentFinalNote += grade; }
            studentFinalNote /= studentsGrades.size();

            System.out.println("Nota Final: " + studentFinalNote);
            if (validateGrade(studentFinalNote)) System.out.println("Aprobaste");
            else System.out.println("Reprobaste");

            finalGrades.add(studentFinalNote);
            System.out.println();
        }
        scanner.close();
        System.out.println("Promedio General: " + generalAverage(finalGrades));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer amountOfStudents = 0;

        do {
            System.out.print("Ingrese la cantidad de estudiantes: ");
            if (scanner.hasNextInt()) {
                amountOfStudents = scanner.nextInt();
                break;
            } else System.out.println("Ingrese un valor valido");
        } while (true);
        readInfo(amountOfStudents);
        scanner.close();
    }
}
