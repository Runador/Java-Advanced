package classbox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        Box box = new Box(length, width, height);
        box.calculateSurfaceArea();
        box.calculateLateralSurfaceArea();
        box.calculateVolume();
        System.out.println(box);
    }
}
