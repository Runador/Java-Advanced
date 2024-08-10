import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] sPosition = getPosition(matrix);
        int sRow = sPosition[0];
        int sCol = sPosition[1];

        int[] secondBorrowPosition = getSecondBorrowPosition(matrix);
        int secondBorrowPositionRow = secondBorrowPosition[0];
        int secondBorrowPositionCol = secondBorrowPosition[1];

        int foodCounter = 0;
        boolean isOutOfBounds = false;
        boolean isSnakeCollected10Foods = false;

        String command = scanner.nextLine();

        while (true) {

            matrix[sRow][sCol] = '.';

            switch (command) {
                case "up" -> sRow--;
                case "down" -> sRow++;
                case "left" -> sCol--;
                case "right" -> sCol++;
            }

            if (sRow < 0 || sRow > matrix.length - 1 ||
                    sCol < 0 || sCol > matrix.length - 1) {
                isOutOfBounds = true;
                break;
            }

            if (matrix[sRow][sCol] == '*') {
                foodCounter++;
                if (foodCounter == 10) {
                    isSnakeCollected10Foods = true;
                    matrix[sRow][sCol] = 'S';
                    break;
                }
            }

            if (matrix[sRow][sCol] == 'B') {
                matrix[sRow][sCol] = '.';
                sRow = secondBorrowPositionRow;
                sCol = secondBorrowPositionCol;
                matrix[sRow][sCol] = 'S';
            }

            matrix[sRow][sCol] = 'S';

            command = scanner.nextLine();
        }

        if (isOutOfBounds) {
            System.out.println("Game over!");
        }
        if (isSnakeCollected10Foods) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", foodCounter);
        printMatrix(matrix);
    }

    private static int[] getSecondBorrowPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    counter++;
                    if (counter == 2) {
                        coordinates[0] = row;
                        coordinates[1] = col;
                        break;
                    }
                }
            }
        }
        return coordinates;
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

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
