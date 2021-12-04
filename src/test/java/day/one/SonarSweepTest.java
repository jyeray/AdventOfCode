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
}