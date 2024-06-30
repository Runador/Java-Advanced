import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] pPosition = getPosition(matrix);
        int pRow = pPosition[0];
        int pCol = pPosition[1];

        String[] commands = scanner.nextLine().split("\\s+");

        while (initialEnergy > 0) {

            matrix[pRow][pCol] = '-';

            String command = commands[0];
            int enemyRow = Integer.parseInt(commands[1]);
            int enemyCol = Integer.parseInt(commands[2]);
            matrix[enemyRow][enemyCol] = 'S';

            switch (command) {
                case "up" -> pRow--;
                case "down" -> pRow++;
                case "left" -> pCol--;
                case "right" -> pCol++;
            }

            if (pRow < 0) {
                pRow++;
                initialEnergy--;
            } else if (pRow > matrix.length - 1) {
                pRow--;
                initialEnergy--;
            } else if (pCol < 0) {
                pCol++;
                initialEnergy--;
            } else if (pCol > matrix.length - 1) {
                pCol--;
                initialEnergy--;
            } else {
                initialEnergy--;
            }

            if (initialEnergy <= 0) {
                matrix[pRow][pCol] = 'X';
                System.out.printf("Paris died at %d;%d.\n", pRow, pCol);
                printMatrix(matrix);
                break;
            }

            if (matrix[pRow][pCol] == 'S') {
                initialEnergy -= 2;
                if (initialEnergy <= 0) {
                    matrix[pRow][pCol] = 'X';
                    System.out.printf("Paris died at %d;%d.\n", pRow, pCol);
                    printMatrix(matrix);
                    break;
                }
            }

            if (matrix[pRow][pCol] == 'H') {
                matrix[pRow][pCol] = '-';
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d\n", initialEnergy);
                printMatrix(matrix);
                break;
            }

            matrix[pRow][pCol] = 'P';
            commands = scanner.nextLine().split("\\s+");
        }
    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
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
