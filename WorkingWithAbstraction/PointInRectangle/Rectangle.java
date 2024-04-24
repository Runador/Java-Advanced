package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {

    private int bottomLeftX;
    private int bottomLeftY;
    private int topRightX;
    private int topRightY;

    public int getBottomLeftX() {
        return bottomLeftX;
    }

    public int getBottomLeftY() {
        return bottomLeftY;
    }

    public int getTopRightX() {
        return topRightX;
    }

    public int getTopRightY() {
        return topRightY;
    }

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeftX = bottomLeftX;
        this.bottomLeftY = bottomLeftY;
        this.topRightX = topRightX;
        this.topRightY = topRightY;
    }

    public boolean contains(Point point) {

        return bottomLeftX <= point.getX() && bottomLeftY <= point.getY()
                && topRightX >= point.getX() && topRightY >= point.getY();

    }

}
