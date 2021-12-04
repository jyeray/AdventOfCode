package day.one;

import java.util.Arrays;

public class SonarSweep {

    public int countIncreases(String measuresAsString) {
        Integer[] measures = Arrays.stream(measuresAsString.split(System.getProperty("line.separator")))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        int count = 0;
        for (int index = 1; index < measures.length; index++) {
            if (measures[index] > measures[index-1]) count++;
        }
        return count;
    }
}
