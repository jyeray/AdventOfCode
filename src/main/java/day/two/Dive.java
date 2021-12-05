package day.two;

import java.util.Arrays;
import java.util.Map;

public class Dive {
    private Integer horizontalPosition = 0;
    private int depth = 0;
    private int aim = 0;
    private final Map<String, CommandExecutor> commandMap = Map.of(
            "forward", moves -> {
                horizontalPosition += moves;
                depth += moves * aim;
            },
            "down", moves -> aim += moves,
            "up", moves -> aim -= moves
    );

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public void applyCurse(String course) {
        Arrays.stream(getCommands(course)).forEach(this::apply);
    }

    private String[] getCommands(String course) {
        return course.split(System.getProperty("line.separator"));
    }

    private void apply(String courseCommand) {
        String[] commandParameters = courseCommand.split(" ");
        String commandOrder = commandParameters[0];
        int moves = Integer.parseInt(commandParameters[1]);
        commandMap.get(commandOrder).apply(moves);
    }

    public int multiply() {
        return depth * horizontalPosition;
    }

    public int getAim() {
        return aim;
    }
}
