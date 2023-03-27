
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MoneyCounter {
    private ArrayList <Integer> validTickets = new ArrayList<>(Arrays.asList(
        1000,
        5000,
        10000,
        20000,
        50000,
        100000 
    ));

    private Integer moneyToCount;

    public MoneyCounter(Integer moneyToCount) {
        this.moneyToCount = moneyToCount;
    }

    public ArrayList <Integer> findResult() {
        Integer remainingMoney = Integer.valueOf(this.moneyToCount);
        
        // ! [0, 0, 0, 0, 0, 0] ... As many as this.validTickets.size()
        ArrayList <Integer> resultTickets = new ArrayList<> (
            Collections.nCopies(this.validTickets.size(), 0)
        );

        while (this.isStillDivisible(remainingMoney)) {
            Integer toSubstract = this.findIntegerToDivide(remainingMoney);
            Integer modifiedValue = resultTickets.get(toSubstract) + 1;

            remainingMoney -= (validTickets.get(toSubstract));
            resultTickets.set(toSubstract, modifiedValue);
        }
        
        return resultTickets;
    }

    private Boolean isStillDivisible(Integer remainingMoney) {
        final Boolean[] toReturn = { false };
        
        this.validTickets.forEach((value) -> {
            if (remainingMoney >= value) toReturn[0] = true;
        });

        return toReturn[0];
    }

    private Integer findIntegerToDivide(Integer remainingMoney) {
        final Integer[] toReturn = { null };

        this.validTickets.forEach((value) -> {
            if (remainingMoney >= value) toReturn[0] = this.validTickets.indexOf(value);
        });

        return toReturn[0];
    }

    public <T> void printFormat(ArrayList <T> resultTickets) {
        for (Integer i = 0; i < resultTickets.size(); i++) {
            if (!resultTickets.get(i).toString().equals("0"))
                System.out.format("%d x %d%n", resultTickets.get(i), this.validTickets.get(i));
        }
    }
}
