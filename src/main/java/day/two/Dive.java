package day.two;

import java.util.Map;

public class Dive {
    private Integer horizontalPosition = 0;
    private int depth = 0;

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public int getDepth() {
        return depth;
    }

    public void applyCurse(String course) {
        Map<String, CommandExecutor> commandMap = Map.of(
                "forward", (moves) -> horizontalPosition += moves,
                "down", (moves) -> depth += moves
        );
        String[] courseCommands = course.split(System.getProperty("line.separator"));
        for (String courseCommand : courseCommands) {
            String[] commandParameters = courseCommand.split(" ");
            String commandOrder = commandParameters[0];
            int moves = Integer.parseInt(commandParameters[1]);
            commandMap.get(commandOrder).apply(moves);
        }
    }
}
