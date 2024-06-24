import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensionsFirst = scanner.nextLine().split("\\s+");
        int R1 = Integer.parseInt(dimensionsFirst[0]);
        int C1 = Integer.parseInt(dimensionsFirst[1]);

        int[][] matrix1 = new int[R1][C1];
        for (int row = 0; row < matrix1.length; row++) {
            matrix1[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        String[] dimensionsSecond = scanner.nextLine().split("\\s+");
        int R2 = Integer.parseInt(dimensionsSecond[0]);
        int C2 = Integer.parseInt(dimensionsSecond[1]);

        int[][] matrix2 = new int[R2][C2];
        for (int row = 0; row < matrix2.length; row++) {
            matrix2[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        boolean areEqual = areEqual(matrix1, matrix2);

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    public static boolean areEqual(int[][] matrix1, int[][] matrix2) {

        if (matrix1.length != matrix2.length) {
            return false;
        } else {
            for (int row = 0; row < matrix1.length; row++) {
                if (matrix1[row].length != matrix2[row].length) {
                    return false;
                }
                for (int col = 0; col < matrix1[row].length; col++) {
                    if (matrix1[row][col] != matrix2[row][col]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
