/*
import java.util.Scanner;

public class Beesy1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] beePosition = beePosition(matrix);
        int row = beePosition[0];
        int col = beePosition[1];

        int initialEnergy = 15;
        int collectedNectar = 0;
        int outOfEnergyCounter = 0;

        String command = scanner.nextLine();

        while (true) {

            matrix[row][col] = '-';

            switch (command) {
                case "up" -> row--;
                case "down" -> row++;
                case "left" -> col--;
                case "right" -> col++;
            }

            if (row < 0) {
                row = matrix.length - 1;
            } else if (row > matrix.length - 1) {
                row = 0;
            }
            if (col < 0) {
                col = matrix.length - 1;
            } else if (col > matrix.length - 1) {
                col = 0;
            }

            initialEnergy--;

            if (Character.isDigit(matrix[row][col])) {
                collectedNectar += Integer.parseInt(String.valueOf(matrix[row][col]));
            }

            if (matrix[row][col] == 'H') {
                matrix[row][col] = 'B';
                if (collectedNectar >= 30) {
                    System.out.printf("Great job, Beesy! The hive is full. Energy left: %d%n", initialEnergy);
                    printMatrix(matrix);
                } else {
                    System.out.println("Beesy did not manage to collect enough nectar.");
                    printMatrix(matrix);
                }
                break;
            }

            if (initialEnergy <= 0) {
                if (collectedNectar <= 30) {
                    matrix[row][col] = 'B';
                    System.out.println("This is the end! Beesy ran out of energy.");
                    printMatrix(matrix);
                    break;
                } else {
                    if (outOfEnergyCounter == 0) {
                        int diff = collectedNectar - 30;
                        collectedNectar = 30;
                        initialEnergy += diff;
                        outOfEnergyCounter++;
                    } else {
                        matrix[row][col] = 'B';
                        System.out.println("This is the end! Beesy ran out of energy.");
                        printMatrix(matrix);
                        break;
                    }
                }
            }

            matrix[row][col] = 'B';
            command = scanner.nextLine();
        }

    }

    public static int[] beePosition(char[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        return position;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int c = 0; c < matrix[row].length; c++) {
                System.out.print(matrix[row][c]);
            }
            System.out.println();
        }
    }

}
*/
