package day.three;

public class BinaryDiagnostic {
    public int powerConsumption(String diagnosisReport) {
        int decimalValue = getDecimalValue(diagnosisReport);
        int bitwiseComplement = getBitwiseComplement(decimalValue);
        return decimalValue * bitwiseComplement;
    }

    private int getBitwiseComplement(int decimalValue) {
        return -~decimalValue;
    }

    private int getDecimalValue(String diagnosisReport) {
        return Integer.parseInt(diagnosisReport, 2);
    }
}
