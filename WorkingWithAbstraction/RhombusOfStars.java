package WorkingWithAbstraction;

import java.util.Scanner;

public class RhombusOfStars {

    public static void printUpperPart(int n) {
        int colsCount = 1;
        for (int row = 0; row < n - 1; row++) {
            for (int i = 0; i < n - colsCount; i++) {
                System.out.print(" ");
            }
            for (int col = 0; col < colsCount; col++) {
                System.out.print("* ");
            }
            System.out.println();
            colsCount++;
        }
    }

    public static void printMiddlePart(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public static void printLowerPart(int n) {
        int colsCount = n - 1;

        for (int row = 0; row < n - 1; row++) {
            for (int i = 0; i < n - colsCount; i++) {
                System.out.print(" ");
            }
            for (int col = 0; col < colsCount; col++) {
                System.out.print("* ");
            }
            System.out.println();
            colsCount--;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printUpperPart(n);
        printMiddlePart(n);
        printLowerPart(n);
    }

}

