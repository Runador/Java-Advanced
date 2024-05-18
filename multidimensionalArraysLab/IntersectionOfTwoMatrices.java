package multidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];
        char[][] thirdMatrix = new char[rows][cols];

        fillMatrix(firstMatrix, scanner);
        fillMatrix(secondMatrix, scanner);

        System.arraycopy(firstMatrix, 0, thirdMatrix, 0, firstMatrix.length );

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                char firstElement = firstMatrix[row][col];
                char secondElement = secondMatrix[row][col];
                if (firstElement != secondElement) {
                    thirdMatrix[row][col] = '*';
                }
            }
        }

        for (char[] row : thirdMatrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }

}
