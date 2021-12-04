package day.one;

public class SonarSweep {

    public int countIncreases(String measuresAsString) {
        String newLine = System.getProperty("line.separator");
        String[] measures = measuresAsString.split(newLine);
        if (measures.length == 1) return 0;
        if (Integer.parseInt(measures[1].trim()) > Integer.parseInt(measures[0].trim())) return 1;
        return 0;
    }
}
