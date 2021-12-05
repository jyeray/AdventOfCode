package day.two;

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
            horizontalPosition += Integer.parseInt(courseCommand.substring(courseCommand.length() - 1));
        }
    }
}
