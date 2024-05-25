package multidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        fillMatrix(matrix, scanner);

        String[] tokens = scanner.nextLine().split(" ");
        int rowIndex = Integer.parseInt(tokens[0]);
        int colIndex = Integer.parseInt(tokens[1]);

        int elementToReplace = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {

                int element = matrix[rowIndex][colIndex];

                if (rowIndex >= 0 && colIndex >= 0) {
                    int upperElement = matrix[rowIndex - row][colIndex];
                    System.out.println(upperElement);
                }
                if (rowIndex > 0 && colIndex > 0) {
                    int leftElement = matrix[rowIndex][colIndex - 1];
                    System.out.println(leftElement);
                }
                if (rowIndex > 0 && colIndex > 0) {
                    int rightElement = matrix[rowIndex][colIndex + 1];
                    System.out.println(rightElement);
                }
                if (rowIndex > 0 && colIndex > 0) {
                    int downElement = matrix[rowIndex + row][colIndex];
                    System.out.println(downElement);
                }

            }
        }

    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
