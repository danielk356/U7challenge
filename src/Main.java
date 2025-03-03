import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Rectangle mainRectangle = new Rectangle(20, 10, 10, 15);

        ArrayList <Rectangle> rectangles = new ArrayList<Rectangle>();

        for (int i = 0; i < 1000000; i++) {
            rectangles.add(new Rectangle(generateLength(), generateWidth(), generateTopLeftX(), generateTopLeftY()));
        }

        System.out.println(findPercentage(rectangles, mainRectangle));
    }
    public static int generateLength() {
        int length = (int) (Math.random() * 41) + 10;
        return length;
    }

    public static  int generateWidth() {
        int width = (int) (Math.random() * 6) + 5;
        return width;
    }

    public static int generateTopLeftX() {
        int topLeftX = (int) (Math.random() * 51);
        return topLeftX;
    }

    public static int generateTopLeftY() {
        int topLeftY = (int) (Math.random() * 51);
        return topLeftY;
    }

    public static double findPercentage(ArrayList<Rectangle> rectangles, Rectangle mainRectangle) {
        int mainRectangleTopRightX = mainRectangle.getLength() + mainRectangle.getTopLeftX();
        int mainRectangleTopRightY = mainRectangle.getTopLeftY();

        int mainRectangleBottomLeftX = mainRectangle.getTopLeftX();
        int mainRectangleBottomLeftY = mainRectangle.getTopLeftY() - mainRectangle.getWidth();

        int mainRectangleBottomRightX = mainRectangleTopRightX;
        int mainRectangleBottomRightY = mainRectangleBottomLeftY;

        int count = 0;
        for (Rectangle rectangle : rectangles) {
            int rectangleTopRightX = rectangle.getLength() + rectangle.getTopLeftX();
            int rectangleTopRightY = rectangle.getTopLeftY();

            int rectangleBottomLeftX = rectangle.getTopLeftX();
            int rectangleBottomLeftY = rectangle.getTopLeftY() - rectangle.getWidth();

            int rectangleBottomRightX = rectangleTopRightX;
            int rectangleBottomRightY = rectangleBottomLeftY;

            if (rectangle.getTopLeftX() >= mainRectangle.getTopLeftX() && rectangle.getTopLeftX() <= mainRectangleTopRightX && rectangle.getTopLeftY() <= mainRectangle.getTopLeftY() && rectangle.getTopLeftY() >= mainRectangleBottomLeftY) {
                    count++;
            }
            else if (rectangleTopRightX >= mainRectangle.getTopLeftX() && rectangleTopRightX <= mainRectangleTopRightX && rectangleTopRightY <= mainRectangle.getTopLeftY() && rectangleTopRightY >= mainRectangleBottomLeftY) {
                    count++;
            }
            else if (rectangleBottomLeftX >= mainRectangle.getTopLeftX() && rectangleBottomLeftX <= mainRectangleTopRightX && rectangleBottomLeftY <= mainRectangle.getTopLeftY() && rectangleBottomLeftY >= mainRectangleBottomLeftY) {
                    count++;
            }
            else if (rectangleBottomRightX >= mainRectangle.getTopLeftX() && rectangleBottomRightX <= mainRectangleTopRightX && rectangleBottomRightY <= mainRectangle.getTopLeftY() && rectangleBottomRightY >= mainRectangleBottomLeftY) {
                    count++;
            }
        }

        double percentage = (double) count/rectangles.size() * 100;
        double percentageRounded = Math.round(percentage * 10.0) / 10.0;
        return percentageRounded;
    }
}
