package multidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];
        String[][] thirdMatrix = new String[rows][cols];

        for (int row = 0; row < firstMatrix.length; row++) {
            firstMatrix[row] = readArray(scanner);
        }
        for (int row = 0; row < secondMatrix.length; row++) {
            secondMatrix[row] = readArray(scanner);
        }

        System.arraycopy(firstMatrix, 0, thirdMatrix, 0, firstMatrix.length );

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                String firstElement = firstMatrix[row][col];
                String secondElement = secondMatrix[row][col];
                if (!firstElement.equals(secondElement)) {
                    thirdMatrix[row][col] = "*";
                }
            }
        }

        for (String[] row : thirdMatrix) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
