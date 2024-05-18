package multidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2SubMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixTokens = readArray(scanner);

        int rows = matrixTokens[0];
        int cols = matrixTokens[1];

        int biggestSum = Integer.MIN_VALUE;

        int[][] matrix = new int[rows][cols];
        int[][] subMatrix = new int[2][2];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(scanner);
        }

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int firstLeft = matrix[row][col];
                int firstRight = matrix[row][col + 1];
                int secondLeft = matrix[row + 1][col];
                int secondRight = matrix[row + 1][col + 1];

                int thisSum = firstLeft + firstRight + secondLeft + secondRight;

                if (thisSum > biggestSum) {
                    biggestSum = thisSum;

                    subMatrix[0][0] = firstLeft;
                    subMatrix[0][1] = firstRight;
                    subMatrix[1][0] = secondLeft;
                    subMatrix[1][1] = secondRight;
                }

            }
        }

        for (int[] row : subMatrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        System.out.println(biggestSum);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

}
