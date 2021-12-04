package day.one;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class SonarSweepTest {

    @Test
    public void ignore_first_measure() {
        String measures = "300";
        int numberOfIncreases = new SonarSweep().countIncreases(measures);
        assertThat(numberOfIncreases, is(0));
    }

    @Test
    public void increase_when_a_measure_is_deeper_than_previous_one() {
        String measures = """
                300
                301""";

        int numberOfIncreases = new SonarSweep().countIncreases(measures);

        assertThat(numberOfIncreases, is(1));
    }

    @Test
    public void do_not_increment_when_a_measure_is_more_superficial_than_previous_one() {
        String measures = """
                300
                299""";

        int numberOfIncreases = new SonarSweep().countIncreases(measures);

        assertThat(numberOfIncreases, is(0));
    }

    @Test
    public void count_several_deeper_measures() {
        String measures = """
                300
                301
                400
                567
                568""";

        int numberOfIncreases = new SonarSweep().countIncreases(measures);

        assertThat(numberOfIncreases, is(4));
    }

    @Test
    public void count_several_deeper_measures_ignoring_superficial_ones() {
        String measures = """
                300
                301
                250
                200
                203
                567""";

        int numberOfIncreases = new SonarSweep().countIncreases(measures);

        assertThat(numberOfIncreases, is(3));
    }
}