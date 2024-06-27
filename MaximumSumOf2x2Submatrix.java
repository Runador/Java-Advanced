import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        int[][] matrix = new int[rows][cols];
        int[][] biggestMatrix = new int[2][2];
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int topLeft = matrix[row][col];
                int topRight = matrix[row][col + 1];
                int bottomLeft = matrix[row + 1][col];
                int bottomRight = matrix[row + 1][col + 1];
                sum = topLeft + topRight + bottomLeft + bottomRight;
                if (sum > max) {
                    max = sum;
                    biggestMatrix[0][0] = topLeft;
                    biggestMatrix[0][1] = topRight;
                    biggestMatrix[1][0] = bottomLeft;
                    biggestMatrix[1][1] = bottomRight;
                }
            }
        }

        printBiggestMatrix(biggestMatrix);
        System.out.println(max);
    }

    private static void printBiggestMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
