package Code.Enums.Basics;

public class App {
    public static void main(String[] args) {
        DaysOfTheWeek days = DaysOfTheWeek.THURSDAY;

        // if (days.equals(DaysOfTheWeek.THURSDAY)) {
        //     System.out.println("It's almost Friday!");
        // }

        // for (var day: DaysOfTheWeek.values()) {
        //     System.out.println(day);
        // }

        System.out.println(days.levelOfTiredness);

        System.out.println(DaysOfTheWeek.FRIDAY.levelOfTiredness);
    }
}