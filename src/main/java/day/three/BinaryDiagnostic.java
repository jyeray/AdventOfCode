package day.three;

public class BinaryDiagnostic {
    public int powerConsumption(String diagnosisReport) {
        String gammaAsString = diagnosisReport;
        String epsilonAsString = getEpsilon(gammaAsString);
        int gamma = getDecimalValue(gammaAsString);
        int epsilon = getDecimalValue(epsilonAsString);
        return gamma * epsilon;
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
