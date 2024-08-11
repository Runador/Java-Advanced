import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] pPosition = getPosition(matrix);
        int pRow = pPosition[0];
        int pCol = pPosition[1];

        boolean areReachedFinish = false;

        for (int i = 0; i < m; i++) {
            String command = scanner.nextLine();

            matrix[pRow][pCol] = '-';

            switch (command) {
                case "up" -> pRow--;
                case "down" -> pRow++;
                case "left" -> pCol--;
                case "right" -> pCol++;
            }

            if (pRow < 0) {
                pRow = matrix.length - 1;
            } else if (pRow > matrix.length - 1) {
                pRow = 0;
            } else if (pCol < 0) {
                pCol = matrix.length - 1;
            } else if (pCol > matrix.length - 1) {
                pCol = 0;
            }

            if (matrix[pRow][pCol] == 'B') {
                switch (command) {
                    case "up" -> pRow--;
                    case "down" -> pRow++;
                    case "left" -> pCol--;
                    case "right" -> pCol++;
                }
            }

            if (pRow < 0) {
                pRow = matrix.length - 1;
            } else if (pRow > matrix.length - 1) {
                pRow = 0;
            } else if (pCol < 0) {
                pCol = matrix.length - 1;
            } else if (pCol > matrix.length - 1) {
                pCol = 0;
            }

            if (matrix[pRow][pCol] == 'T') {
                switch (command) {
                    case "up" -> pRow++;
                    case "down" -> pRow--;
                    case "left" -> pCol++;
                    case "right" -> pCol--;
                }
            }

            if (matrix[pRow][pCol] == 'F') {
                areReachedFinish = true;
                matrix[pRow][pCol] = 'f';
                break;
            }

            matrix[pRow][pCol] = 'f';
        }

        if (areReachedFinish) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'f') {
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
