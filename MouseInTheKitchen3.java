import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int m = dimensions[0];
        int n = dimensions[1];

        char[][] matrix = new char[m][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] mPosition = getPosition(matrix);
        int mRow = mPosition[0];
        int mCol = mPosition[1];

        boolean isOutOfBounds = false;
        int getCountOfCheese = getCountOfCheese(matrix);
        int counter = 0;
        boolean isDangerBefore = false;

        String command = scanner.nextLine();

        while (!command.equals("danger")) {

            matrix[mRow][mCol] = '*';

            int previousRow = mRow;
            int previousCol = mCol;

            switch (command) {
                case "up" -> mRow--;
                case "down" -> mRow++;
                case "left" -> mCol--;
                case "right" -> mCol++;
            }

            if (!isInBounds(mRow, mCol, matrix)) {
                isOutOfBounds = true;
                matrix[previousRow][previousCol] = 'M';
                break;
            }

            if (matrix[mRow][mCol] == 'C') {
                counter++;
                if (getCountOfCheese == counter) {
                    System.out.println("Happy mouse! All the cheese is eaten, good night!");
                    matrix[mRow][mCol] = 'M';
                    isDangerBefore = false;
                    break;
                } else {
                    isDangerBefore = true;
                }
            }

            if (matrix[mRow][mCol] == '@') {
                mRow = previousRow;
                mCol = previousCol;
                matrix[previousRow][previousCol] = 'M';
                command = scanner.nextLine();
                continue;
            }

            if (matrix[mRow][mCol] == 'T') {
                System.out.println("Mouse is trapped!");
                matrix[mRow][mCol] = 'M';
                break;
            }

            matrix[mRow][mCol] = 'M';

            command = scanner.nextLine();
        }

        if (isOutOfBounds) {
            System.out.println("No more cheese for tonight!");
        }
        if (isDangerBefore) {
            System.out.println("Mouse will come back later!");
        }
        printMatrix(matrix);
    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'M') {
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

    private static boolean isInBounds(int playerRow, int playerCol, char[][] matrix) {
        return playerRow >= 0 && playerRow < matrix.length &&
                playerCol >= 0 && playerCol < matrix[playerRow].length;
    }

    private static int getCountOfCheese(char[][] matrix) {
        int counter = 0;
        for (char[] row : matrix) {
            for (char col : row) {
                if (col == 'C') {
                    counter++;
                }
            }
        }
        return counter;
    }
}
