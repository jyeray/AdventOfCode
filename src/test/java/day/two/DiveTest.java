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

    @Test
    void start_with_depth_zero() {
        int depth = new Dive().getDepth();
        assertThat(depth, is(0));
    }

    @Test
    void move_forward() {
        Dive dive = new Dive();
        String plannedCourse = "forward 5";

        dive.applyCurse(plannedCourse);
        
        assertThat(dive.getHorizontalPosition(), is(5));
    }
}