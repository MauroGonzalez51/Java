
public class App {
    public static void main(String[] args) {
        MoneyCounter moneyCounter = new MoneyCounter(72000);
        moneyCounter.printFormat(moneyCounter.findResult());
    }
}
