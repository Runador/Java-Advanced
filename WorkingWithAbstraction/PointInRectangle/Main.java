package WorkingWithAbstraction.PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int bottomLeftX = Integer.parseInt(input[0]);
        int bottomLeftY = Integer.parseInt(input[1]);
        int topRightX = Integer.parseInt(input[2]);
        int topRightY = Integer.parseInt(input[3]);
        Rectangle rectangle = new Rectangle(bottomLeftX, bottomLeftY, topRightX, topRightY);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            int first = Integer.parseInt(tokens[0]);
            int second = Integer.parseInt(tokens[1]);
            Point point = new Point(first, second);
            System.out.println(rectangle.contains(point));
        }
    }
}
