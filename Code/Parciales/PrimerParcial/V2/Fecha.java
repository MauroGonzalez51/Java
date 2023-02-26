package Code.Parciales.PrimerParcial.V2;

import java.util.Scanner;

public class Fecha {

    // ! ClassAttributes > Private
    private Integer day, month, year;

    // ! ScannerObject ==> NO resource leak
    private Scanner scanner = new Scanner(System.in);

    // * Constructor [1] > In case of needed
    // * Prototype (@param Integer, @param Integer, @param Integer)
    public Fecha(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // * Constructor [2] 
    // * Prototype (@param 'void')
    public Fecha() {
        System.out.println();

        // * Each block validates 'somethin'
        // * this.case : Integer : It can't be Negative or Zero

        do {
            System.out.format("Ingrese el dia: ");
            this.day = (this.scanner.hasNextInt()) ? this.scanner.nextInt() : -1;
        } while (this.day <= 0);

        do {
            System.out.format("Ingrese el mes: ");
            this.month = (this.scanner.hasNextInt()) ? this.scanner.nextInt() : -1;
        } while (this.month <= 0);

        do {
            System.out.format("Ingrese el año: ");
            this.year = (this.scanner.hasNextInt()) ? this.scanner.nextInt() : -1;
        } while (this.year <= 0);
    }

    // * -------- Getters && Setters --------------------------|>

    // ! ---------- Getters ----------|>
    public Integer getDay() { return this.day; }
    public Integer getMonth() { return this.month; }
    public Integer getYear() { return this.year; }

    // ! ---------- Setters ----------|>
    public void setDay(Integer day) { this.day = day; }
    public void setMonth(Integer month) { this.month = month; }
    public void setYear(Integer year) { this.year = year; }

    public String dateFormat() { String temp = String.format("%d/%d/%d%n", this.day, this.month, this.year); return temp; }
}
