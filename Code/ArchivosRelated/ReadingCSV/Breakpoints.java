package Code.ArchivosRelated.ReadingCSV;

import java.util.ArrayList;

public class Breakpoints {
    public static Double findMinValue(ArrayList <Double> rawDataReaded) {
        Double minValue = 10000000.0;
        for (var data : rawDataReaded) { if (data < minValue) minValue = data; }
        return minValue;
    }

    public static Double findMaxValue(ArrayList <Double> rawDataReaded) {
        Double maxValue = 0.0;
        for (var data : rawDataReaded) { if (data > maxValue) maxValue = data; }
        return maxValue;
    }

    public static void createBreakpoints(ArrayList <Double> rawDataReaded, ArrayList <Double> breakpoints) {
        Double minValue = findMinValue(rawDataReaded), maxValue = findMaxValue(rawDataReaded);
        Double range = maxValue - minValue;
        Integer intervalsNumber = (int) Math.floor(1 + (3.322 * Math.log10(range)));
        if (intervalsNumber % 2 == 0) intervalsNumber++;
        Double amplitude = range / intervalsNumber;

        for (Integer interval = 0; interval < intervalsNumber; interval++) 
            breakpoints.add((Double) (minValue) + (amplitude * (interval + 1)));
    }
}
