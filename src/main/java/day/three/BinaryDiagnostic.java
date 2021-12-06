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
        Pattern firstPosition = Pattern.compile("1\\d\\n?");
        Pattern secondPosition = Pattern.compile("\\d1\\n?");
        return new StringBuilder()
                .append(getMostCommonValueAt(firstPosition, diagnosisReport))
                .append(getMostCommonValueAt(secondPosition, diagnosisReport))
                .toString();
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
        return Byte.parseByte(diagnosisReport, 2);
    }
}
