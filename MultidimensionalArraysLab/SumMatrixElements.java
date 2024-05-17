package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(",\\s+"))
                                .mapToInt(Integer::parseInt).toArray();

        int rows = tokens[0];
        int cols = tokens[1];
        int sum = 0;

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = Arrays.stream(scanner.nextLine().split(",\\s+"))
                                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
