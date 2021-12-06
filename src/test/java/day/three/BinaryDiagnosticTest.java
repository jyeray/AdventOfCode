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

        int powerConsumption = new BinaryDiagnostic().powerConsumption(diagnosisReport);

        assertThat(powerConsumption, is(198));
    }
}