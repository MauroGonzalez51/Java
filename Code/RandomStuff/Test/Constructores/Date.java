package Code.RandomStuff.Test.Constructores;

import java.util.Scanner;
import java.util.ArrayList;

public class Date {
    private Integer day, month, year;
    
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }
    
    public Date(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date(String day, String month, String year) {
        this.day = Integer.parseInt(day);
        this.month = Integer.parseInt(month);
        this.year = Integer.parseInt(year);
    }

    // * Prototype (day/month/year)
    public Date(String date) {
        Scanner scanner = new Scanner(date);
        scanner.useDelimiter("/");
        ArrayList <String> dateParts = new ArrayList <String>();

        while (scanner.hasNext()) {
            dateParts.add(scanner.next());
        }

        this.day = Integer.parseInt(dateParts.get(0));
        this.month = Integer.parseInt(dateParts.get(1));
        this.year = Integer.parseInt(dateParts.get(2));
        scanner.close();
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
