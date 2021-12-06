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
    void start_with_zero_aim() {
        int depth = new Dive().getAim();
        assertThat(depth, is(0));
    }

    @Test
    void move_forward() {
        Dive dive = new Dive();
        String plannedCourse = "forward 5";

        dive.applyCurse(plannedCourse);
        
        assertThat(dive.getHorizontalPosition(), is(5));
    }

    @Test
    void move_forward_increases_depth_multiplied_by_aim() {
        Dive dive = new Dive();
        String plannedCourse = """
                down 3
                forward 5""";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getHorizontalPosition(), is(5));
        assertThat(dive.getDepth(), is(15));
    }

    @Test
    void move_forward_several_times() {
        Dive dive = new Dive();
        String plannedCourse = """
                forward 5
                forward 3""";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getHorizontalPosition(), is(8));
    }

    @Test
    void move_forward_far_away() {
        Dive dive = new Dive();
        String plannedCourse = "forward 5756";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getHorizontalPosition(), is(5756));
    }

    @Test
    void do_not_change_depth_when_moving_forward() {
        Dive dive = new Dive();
        String plannedCourse = "forward 57";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getDepth(), is(0));
    }

    @Test
    void do_not_change_horizontal_position_when_going_deeper() {
        Dive dive = new Dive();
        String plannedCourse = "down 57";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getHorizontalPosition(), is(0));
    }

    @Test
    void execute_a_complete_course() {
        Dive dive = new Dive();
        String plannedCourse = """
                forward 5
                down 5
                forward 8
                up 3
                down 8
                forward 2""";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getDepth(), is(60));
        assertThat(dive.getHorizontalPosition(), is(15));
    }

    @Test
    void multiply_depth_and_horizontal_position() {
        Dive dive = new Dive();
        String plannedCourse = """
                forward 5
                down 5
                forward 8
                up 3
                down 8
                forward 2""";

        dive.applyCurse(plannedCourse);

        assertThat(dive.multiply(), is(900));
    }

    @Test
    void go_down_increases_aim() {
        Dive dive = new Dive();
        String plannedCourse = "down 3";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getAim(), is(3));
    }

    @Test
    void increase_aim_several_times() {
        Dive dive = new Dive();
        String plannedCourse = """
            down 3
            down 456
            down 4""";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getAim(), is(463));
    }

    @Test
    void do_not_change_aim_when_moving_forward() {
        Dive dive = new Dive();
        String plannedCourse = "forward 57";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getAim(), is(0));
    }

    @Test
    void decrease_aim_with_up_command() {
        Dive dive = new Dive();
        String plannedCourse = """
            down 3
            up 2""";

        dive.applyCurse(plannedCourse);

        assertThat(dive.getAim(), is(1));
    }

}