import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .mapToInt(Integer::parseInt).toArray();
        }

        int[] firstDiagonal = new int[n];
        int[] secondDiagonal = new int[n];

        for (int i = 0; i < matrix.length; i++) {
             firstDiagonal[i] = matrix[i][i];
        }

        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                secondDiagonal[col] = matrix[row][col];
                row--;
            }
        }

    }
}
