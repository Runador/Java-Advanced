package exercisesMultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = Integer.parseInt(scanner.nextLine().split(" ")[1]);

        int[][] matrix = new int[rows][cols];
        int[][] matrix3x3 = new int[3][3];
        fillMatrix(matrix, scanner);
        int biggestSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {

                int topLeft = matrix[row][col];
                int topMiddle = matrix[row][col + 1];
                int topRight = matrix[row][col + 2];
                int middleLeft = matrix[row + 1][col];
                int middleMiddle = matrix[row + 1][col + 1];
                int middleRight = matrix[row + 1][col + 2];
                int bottomLeft = matrix[row + 2][col];
                int bottomMiddle = matrix[row + 2][col + 1];
                int bottomRight = matrix[row + 2][col + 2];

                int sum = topLeft + topMiddle + topRight
                        + middleLeft + middleMiddle + middleRight
                        + bottomLeft + bottomMiddle + bottomRight;

                if (sum > biggestSum) {
                    biggestSum = sum;

                    matrix3x3[0][0] = topLeft;
                    matrix3x3[0][1] = topMiddle;
                    matrix3x3[0][2] = topRight;
                    matrix3x3[1][0] = middleLeft;
                    matrix3x3[1][1] = middleMiddle;
                    matrix3x3[1][2] = middleRight;
                    matrix3x3[2][0] = bottomLeft;
                    matrix3x3[2][1] = bottomMiddle;
                    matrix3x3[2][2] = bottomRight;
                }

            }
        }

        System.out.printf("Sum = %d%n", biggestSum);
        for (int[] row : matrix3x3) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .mapToInt(Integer::parseInt).toArray();
            matrix[row] = array;
        }
    }
}
