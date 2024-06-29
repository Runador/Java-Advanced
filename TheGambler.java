import java.util.Scanner;

public class TheGambler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialAmount = 100;
        boolean isLostEverything = false;
        boolean isJackpotWin = false;

        int n = Integer.parseInt(scanner.nextLine());

        char[][] gameBoard = new char[n][n];

        for (int row = 0; row < gameBoard.length; row++) {
            String line = scanner.nextLine();
            gameBoard[row] = line.toCharArray();
        }

        int[] playerPosition = getPosition(gameBoard);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];

        String direction = scanner.nextLine();

        while (!direction.equals("end")) {

            gameBoard[playerRow][playerCol] = '-';

            switch (direction) {
                case "up" -> playerRow--;
                case "down" -> playerRow++;
                case "left" -> playerCol--;
                case "right" -> playerCol++;
            }

            if (playerRow < 0 || playerRow > gameBoard.length - 1 ||
                    playerCol < 0 || playerCol > gameBoard.length - 1) {
                isLostEverything = true;
                break;
            }

            if (gameBoard[playerRow][playerCol] == 'W') {
                initialAmount += 100;
            }

            if (gameBoard[playerRow][playerCol] == 'P') {
                if (initialAmount > 200) {
                    initialAmount -= 200;
                } else {
                    isLostEverything = true;
                    break;
                }
            }

            if (gameBoard[playerRow][playerCol] == 'J') {
                gameBoard[playerRow][playerCol] = 'G';
                initialAmount += 100000;
                isJackpotWin = true;
                break;
            }

            gameBoard[playerRow][playerCol] = 'G';
            direction = scanner.nextLine();
        }

        if (isLostEverything) {
            System.out.println("Game over! You lost everything!");
        } else if (isJackpotWin) {
            System.out.printf("You win the Jackpot!\nEnd of the game. Total amount: %d$\n",
                    initialAmount);
            printMatrix(gameBoard);
        } else {
            System.out.printf("End of the game. Total amount: %d$\n", initialAmount);
            printMatrix(gameBoard);
        }

    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'G') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
