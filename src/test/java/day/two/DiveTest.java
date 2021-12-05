package day.two;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DiveTest {

    @Test
    void start_with_horizontal_position_zero() {
        int horizontalPosition = new Dive().getHorizontalPosition();
        assertThat(horizontalPosition, is(0));
    }
}