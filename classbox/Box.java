package classbox;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        nameChecker(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        nameChecker(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        nameChecker(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * (length * width) + 2 * (length * height) + 2 * (width * height);
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (length * height) + 2 * (width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }

    public void nameChecker(double value, String prefix) {
        if (value <= 0) {
            throw new IllegalArgumentException(prefix + " cannot be zero or negative.");
        }
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f\n" +
                "Lateral Surface Area - %.2f\n" +
                "Volume – %.2f", calculateSurfaceArea(),
                calculateLateralSurfaceArea(),
                calculateVolume());
    }
}
