package day.one;

import java.util.Arrays;

public class SonarSweep {

    public int countIncreases(String measuresAsString) {
        String newLine = System.getProperty("line.separator");
        Integer[] measures = Arrays.stream(measuresAsString.split(newLine))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        int count = 0;
        Integer lastMeasure = null;
        for (Integer measure : measures) {
            if (lastMeasure == null){
                lastMeasure = measure;
                continue;
            }
            if (measure > lastMeasure) count++;
            lastMeasure = measure;
        }
        return count;
    }
}
