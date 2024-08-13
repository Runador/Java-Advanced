import java.util.Scanner;

public class CollectingStarsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();
        }

        int collectedStarsCounter = 2;
        boolean isWonTheGame = false;
        boolean isFailed = false;
        int lastRowPosition = 0;
        int lastColPosition = 0;

        int[] pPosition = getPosition(matrix);
        int pRow = pPosition[0];
        int pCol = pPosition[1];

        String command = scanner.nextLine();

        while (true) {

            matrix[pRow][pCol] = '.';

            switch (command) {
                case "up" -> pRow--;
                case "down" -> pRow++;
                case "left" -> pCol--;
                case "right" -> pCol++;
            }

            if (pRow < 0 || pRow > matrix.length - 1 ||
                    pCol < 0 || pCol > matrix.length - 1) {
                pRow = 0;
                pCol = 0;
                matrix[pRow][pCol] = 'P';
            }

            if (matrix[pRow][pCol] == '#') {
                switch (command) {
                    case "up" -> pRow++;
                    case "down" -> pRow--;
                    case "left" -> pCol++;
                    case "right" -> pCol--;
                }
                collectedStarsCounter--;
                if (!isInBounds(pRow, pCol, matrix)) {
                    pRow = 0;
                    pCol = 0;
                    matrix[pRow][pCol] = 'P';
                }
                if (collectedStarsCounter == 0) {
                    matrix[pRow][pCol] = 'P';
                    isFailed = true;
                    break;
                }
            }

            if (matrix[pRow][pCol] == '*') {
                matrix[pRow][pCol] = '.';
                collectedStarsCounter++;
                if (collectedStarsCounter >= 10) {
                    isWonTheGame = true;
                    matrix[pRow][pCol] = 'P';
                    lastRowPosition = pRow;
                    lastColPosition = pCol;
                    break;
                }
            }

            lastRowPosition = pRow;
            lastColPosition = pCol;

            matrix[pRow][pCol] = 'P';

            command = scanner.nextLine();
        }

        if (isWonTheGame) {
            System.out.println("You won! You have collected 10 stars.");
        }
        if (isFailed){
            System.out.println("Game over! You are out of any stars.");
        }
        System.out.printf("Your final position is [%d, %d]%n", lastRowPosition, lastColPosition);
        printMatrix(matrix);
    }

    public static boolean isInBounds(int playerRow, int playerCol, char[][] matrix) {
        return playerRow >= 0 && playerRow < matrix.length &&
                playerCol >= 0 && playerCol < matrix[playerRow].length;
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
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
