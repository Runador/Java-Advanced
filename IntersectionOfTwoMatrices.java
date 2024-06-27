import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         int M = Integer.parseInt(scanner.nextLine());
         int N = Integer.parseInt(scanner.nextLine());

         char[][] matrix1 = new char[M][N];
         char[][] matrix2 = new char[M][N];

        fillMatrix(matrix1, scanner);
        fillMatrix(matrix2, scanner);

        char[][] matrix3 = intersectionOfTwoMatrices(matrix1, matrix2);

        printMatrix(matrix3);

    }

    public static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[row] = arr;
        }
    }

    public static char[][] intersectionOfTwoMatrices(char[][] matrix1, char[][] matrix2) {
        char[][] matrix3 = Arrays.copyOf(matrix1, matrix1.length);
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                if (matrix1[row][col] != matrix2[row][col]) {
                    matrix3[row][col] = '*';
                }
            }
        }
        return matrix3;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
