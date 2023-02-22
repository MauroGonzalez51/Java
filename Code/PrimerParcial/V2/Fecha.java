package Code.PrimerParcial.V2;

import java.util.Scanner;

public class Fecha {
    private Integer day, month, year;

    private Scanner scanner = new Scanner(System.in);

    public Fecha(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Fecha() {
        System.out.println();

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
