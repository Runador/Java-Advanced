import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dollarsCollected = 0;

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] sPosition = getPosition(matrix);
        int sRow = sPosition[0];
        int sCol = sPosition[1];

        int[] secondPillarPosition = getSecondPillarPosition(matrix);
        int secondPillarRow = secondPillarPosition[0];
        int secondPillarCol = secondPillarPosition[1];

        String command = scanner.nextLine();

        while (true) {

            matrix[sRow][sCol] = '-';

            int previousRow = sRow;
            int previousCol = sCol;

            switch (command) {
                case "up" -> sRow--;
                case "down" -> sRow++;
                case "left" -> sCol--;
                case "right" -> sCol++;
            }

            if (sRow < 0 || sRow > matrix.length - 1 ||
                    sCol < 0 || sCol > matrix.length - 1) {
                matrix[previousRow][previousCol] = '-';
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }

            if (Character.isDigit(matrix[sRow][sCol])) {
                dollarsCollected += Integer.parseInt(String.valueOf(matrix[sRow][sCol]));
                if (dollarsCollected >= 50) {
                    matrix[sRow][sCol] = 'S';
                    System.out.println("Good news! You succeeded in collecting enough money!");
                    break;
                }
            }

            if (matrix[sRow][sCol] == 'P') {
                matrix[sRow][sCol] = '-';
                sRow = secondPillarRow;
                sCol = secondPillarCol;
                matrix[sRow][sCol] = 'S';
            }

            matrix[sRow][sCol] = 'S';
            command = scanner.nextLine();
        }

        System.out.printf("Money: %d\n", dollarsCollected);
        printMatrix(matrix);
    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }

    private static int[] getSecondPillarPosition(char[][] matrix) {
        int counter = 0;
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    counter++;
                }
                if (counter == 2) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    break;
                }
            }
        }
        return coordinates;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
