package exercisesMultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimension][dimension];

        fillIntegerMatrix(matrix, scanner);

        int[] firstDiagonal = new int[dimension];
        int[] secondDiagonal = new int[dimension];

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal[i] = matrix[i][i];
            firstDiagonalSum += firstDiagonal[i];
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            secondDiagonal[i] = matrix[matrix.length - 1 - i][i];
            secondDiagonalSum += secondDiagonal[i];
        }

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }

    private static void fillIntegerMatrix(int[][] integerMatrix, Scanner scanner) {
        for (int row = 0; row < integerMatrix.length; row++) {
            integerMatrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
