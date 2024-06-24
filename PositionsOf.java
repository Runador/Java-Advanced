import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int R = Integer.parseInt(dimensions[0]);
        int C = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[R][C];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int n = Integer.parseInt(scanner.nextLine());


        checkPosition(matrix, n);

    }

    public static void checkPosition(int[][] matrix, int n) {
        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == n) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
