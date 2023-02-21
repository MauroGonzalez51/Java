package Code.RandomStuff.Test.Constructores;

public class App {
    public static void main(String[] args) throws Exception {
        Date date_1 = new Date();
        System.out.format("Date format: %s", date_1.dateFormat());

        Date date_2 = new Date(13, 12, 2004);
        System.out.format("Date format: %s", date_2.dateFormat());

        Date date_3 = new Date("13/12/2004");
        System.out.format("Date3.day: %d", date_3.getDay());
    }
}
