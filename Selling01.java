import java.util.Scanner;

public class Selling01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] playerCoordinates = getPlayerPosition(matrix);
        int pRow = playerCoordinates[0];
        int pCol = playerCoordinates[1];

        boolean isOutOfBoundaries = false;
        boolean areMoneyCollected = false;
        int collectedMoney = 0;

        int[] secondPillarPosition = getSecondPillarPosition(matrix);
        int sRow = secondPillarPosition[0];
        int sCol = secondPillarPosition[1];

        String command = scanner.nextLine();

        while (command != null) {

            matrix[pRow][pCol] = '-';

            switch (command) {
                case "up" -> pRow--;
                case "down" -> pRow++;
                case "left" -> pCol--;
                case "right" -> pCol++;
            }

            if (pRow < 0 || pRow > matrix.length - 1 || pCol < 0 || pCol > matrix.length - 1) {
                isOutOfBoundaries = true;
                break;
            }

            if (matrix[pRow][pCol] == 'O') {
                matrix[pRow][pCol] = '-';
                pRow = sRow;
                sRow = sCol;
                matrix[pRow][pCol] = 'S';
            }

            if (Character.isDigit(matrix[pRow][pCol])) {
                collectedMoney += Integer.parseInt(String.valueOf(matrix[pRow][pCol]));
                matrix[pRow][pCol] = 'S';
                if(collectedMoney >= 50) {
                    areMoneyCollected = true;
                    break;
                }
            }

            command = scanner.nextLine();
        }

        if (areMoneyCollected) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        if (isOutOfBoundaries) {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.printf("Money: %d\n", collectedMoney);
        printMatrix(matrix);
    }

    public static int[] getPlayerPosition(char[][] matrix) {
        int[] playerCoordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    playerCoordinates[0] = row;
                    playerCoordinates[1] = col;
                }
            }
        }
        return playerCoordinates;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println( );
        }
    }

    private static int[] getSecondPillarPosition(char[][] matrix) {
        int[] secondPillarPosition = new int[2];
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'O') {
                    counter++;
                    if (counter == 2) {
                        secondPillarPosition[0] = row;
                        secondPillarPosition[1] = col;
                        break;
                    }
                }
            }
        }
        return secondPillarPosition;
    }
}
