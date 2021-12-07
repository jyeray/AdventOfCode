package day.three;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BinaryDiagnosticTest {

    @Test
    void calculate_power_consumption() {
        String diagnosisReport = """
                00100
                11110
                10110
                10111
                10101
                01111
                00111
                11100
                10000
                11001
                00010
                01010""";

        int powerConsumption = new BinaryDiagnostic(diagnosisReport).powerConsumption();

        assertThat(powerConsumption, is(198));
    }

    @Test
    void calculate_power_with_just_one_report_of_five_bits() {
        String diagnosisReport = "01010";

        int powerConsumption = new BinaryDiagnostic(diagnosisReport).powerConsumption();

        assertThat(powerConsumption, is(210));
    }

    @Test
    void calculate_power_several_reports_of_five_bits() {
        String diagnosisReport = """
            10110
            01000
            01010""";

        int powerConsumption = new BinaryDiagnostic(diagnosisReport).powerConsumption();

        assertThat(powerConsumption, is(210));
    }

    @Test
    void calculate_power_several_reports_for_more_bits() {
        String diagnosisReport = """
            0010110
            0101000
            1101010""";

        int powerConsumption = new BinaryDiagnostic(diagnosisReport).powerConsumption();

        assertThat(powerConsumption, is(3570));
    }

    @Test
    void calculate_life_support_rating() {
        String diagnosisReport = """
                00100
                11110
                10110
                10111
                10101
                01111
                00111
                11100
                10000
                11001
                00010
                01010""";

        int lifeSupportRating = new BinaryDiagnostic(diagnosisReport).lifeSupportRating();

        assertThat(lifeSupportRating, is(230));
    }

    @Test
    void given_two_numbers_of_one_bit_oxygen_generator_rating_is_1() {
        String diagnosisReport = """
            1
            0""";

        int powerConsumption = new BinaryDiagnostic(diagnosisReport).oxygenGeneratorRating();

        assertThat(powerConsumption, is(1));
    }
}