import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;



public class MoneyCounterTest {
    // ArrayList <Integer> validTickets = new ArrayList<>(Arrays.asList(
    // 1000,
    // 5000,
    // 10000,
    // 20000,
    // 50000,
    // 100000
    // ));

    @Test
    void valueInputEquals70000() {
        Integer valueInput = 70000;
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(
                0, 0, 0, 1, 1, 0));
        MoneyCounter moneyCounter = new MoneyCounter(valueInput);
        assertEquals(expectedResult, moneyCounter.findResult());
    }
    
    @Test
    void valueInputEquals54000() {
        Integer valueInput = 54000;
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(
            4, 0, 0, 0, 1, 0));
            MoneyCounter moneyCounter = new MoneyCounter(valueInput);
            assertEquals(expectedResult, moneyCounter.findResult());
    }
    
    @Test
    void valueInputEquals34000() {
        Integer valueInput = 34000;
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(
            4, 0, 1, 1, 0, 0));
            MoneyCounter moneyCounter = new MoneyCounter(valueInput);
            assertEquals(expectedResult, moneyCounter.findResult());
    }

    @Test
    void valueInputEquals156000() {
        Integer valueInput = 156000;
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(
            1, 1, 0, 0, 1, 1));
            MoneyCounter moneyCounter = new MoneyCounter(valueInput);
            assertEquals(expectedResult, moneyCounter.findResult());
    }

    @Test
    void valueInputEquals592000() {
        Integer valueInput = 592000;
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(
            2, 0, 0, 2, 1, 5));
            MoneyCounter moneyCounter = new MoneyCounter(valueInput);
            assertEquals(expectedResult, moneyCounter.findResult());
    }

    @Test
    void valueInputEquals500() {
        Integer valueInput = 500;
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(
            0, 0, 0, 0, 0, 0));
            MoneyCounter moneyCounter = new MoneyCounter(valueInput);
            assertEquals(expectedResult, moneyCounter.findResult());
    }
}
