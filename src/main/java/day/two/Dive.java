package day.two;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dive {
    private int horizontalPosition = 0;

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return 0;
    }

    public void applyCurse(String course) {
        String[] courseCommands = course.split(System.getProperty("line.separator"));
        for (String courseCommand : courseCommands) {
            String commandMoves = courseCommand.split(" ")[1];
            horizontalPosition += Integer.parseInt(commandMoves);
        }
    }
}
