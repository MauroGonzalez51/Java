package Code.Enums.Basics;

public enum DaysOfTheWeek {
     MONDAY(10), 
     TUESDAY(20), 
     WEDNESDAY(30), 
     THURSDAY(40), 
     FRIDAY(100), 
     SATURDAY(40), 
     SUNDAY(20);

    final Integer levelOfTiredness;

     DaysOfTheWeek(Integer levelOfTiredness) {
        this.levelOfTiredness = levelOfTiredness;
     }
}
