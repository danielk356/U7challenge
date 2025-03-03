import java.util.ArrayList;

public class Rectangle {
    private int length;
    private int width;
    private int topLeftX;
    private int topLeftY;

    public Rectangle(int length, int width, int topLeftX, int topLeftY) {
        this.length = length;
        this.width = width;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getTopLeftX() {
        return topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }
}
