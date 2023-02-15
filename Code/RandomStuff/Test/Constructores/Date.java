package Code.RandomStuff.Test.Constructores;

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
