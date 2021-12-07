package day.three;

import java.util.regex.Pattern;

public class BinaryDiagnostic {
    public int powerConsumption(String diagnosisReport) {
        String gammaAsString = getGamma(diagnosisReport);
        String epsilonAsString = getEpsilon(gammaAsString);
        int gamma = getDecimalValue(gammaAsString);
        int epsilon = getDecimalValue(epsilonAsString);
        return gamma * epsilon;
    }

    private String getGamma(String diagnosisReport) {
        int lengthOfReports = diagnosisReport.split(System.getProperty("line.separator"))[0].length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = lengthOfReports-1; i >= 0; i--) {
            String regex = String.format("1\\d{%s}(\\n|$)", i);
            Pattern pattern = Pattern.compile(regex);
            stringBuilder.append(getMostCommonValueAt(pattern, diagnosisReport));
        }
        return stringBuilder.toString();
    }

    private int getMostCommonValueAt(Pattern secondPosition, String diagnosisReport) {
        int numberOfReports = diagnosisReport.split(System.getProperty("line.separator")).length;
        long numberOfOnes = secondPosition.matcher(diagnosisReport).results().count();
        return numberOfOnes > numberOfReports /2 ? 1 : 0;
    }

    private String getEpsilon(String gammaValue) {
        return gammaValue.chars()
                .mapToObj(x -> (char) x)
                .map(x ->  x == '1' ? '0' : '1')
                .map(Object::toString)
                .reduce("", (concatenatedString, character) -> concatenatedString + character);
    }

    private int getDecimalValue(String diagnosisReport) {
        return Integer.parseInt(diagnosisReport, 2);
    }

    public int lifeSupportRating(String diagnosisReport) {
        return 0;
    }
}
