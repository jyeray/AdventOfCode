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
        horizontalPosition = 5;
    }
}
