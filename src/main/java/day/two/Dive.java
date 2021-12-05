package day.two;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dive {
    private int horizontalPosition = 0;
    private int depth = 0;

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public void applyCurse(String course) {
        String[] courseCommands = course.split(System.getProperty("line.separator"));
        for (String courseCommand : courseCommands) {
            String[] commandParameters = courseCommand.split(" ");
            String commandMoves = commandParameters[1];
            String commandOrder = commandParameters[0];
            if (commandOrder.equals("forward")) {
                horizontalPosition += Integer.parseInt(commandMoves);
            }
            depth = Integer.parseInt(commandMoves);
        }
    }
}
