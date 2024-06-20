import java.util.Scanner;

public class EscapeTheMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int initialHealth = 100;
        int[] playerPosition = getPlayerPosition(matrix);
        int playerRow = playerPosition[0];
        int playerCol = playerPosition[1];

        String command = scanner.nextLine();

        while (initialHealth > 0) {

            matrix[playerRow][playerCol] = '-';

            switch (command) {
                case "up" -> playerRow--;
                case "down" -> playerRow++;
                case "left" -> playerCol--;
                case "right" -> playerCol++;
            }

            if (playerRow < 0) {
                playerRow++;
            } else if (playerRow > matrix.length - 1) {
                playerRow--;
            } else if (playerCol < 0) {
                playerCol++;
            } else if (playerCol > matrix.length - 1) {
                playerCol--;
            }

            if (matrix[playerRow][playerCol] == 'M') {
                if (initialHealth > 40) {
                    initialHealth -= 40;
                } else {
                    initialHealth = 0;
                    matrix[playerRow][playerCol] = 'P';
                    break;
                }
            }

            if (matrix[playerRow][playerCol] == 'H') {
                int healthPotion = 15;
                if (initialHealth + healthPotion > 100) {
                    initialHealth = 100;
                } else {
                    initialHealth += 15;
                }
            }

            if (matrix[playerRow][playerCol] == 'X') {
                matrix[playerRow][playerCol] = 'P';
                break;
            }

            matrix[playerRow][playerCol] = 'P';

            command = scanner.nextLine();
        }

        if (initialHealth > 0) {
            System.out.println("Player escaped the maze. Danger passed!");
        } else {
            System.out.println("Player is dead. Maze over!");
        }
        System.out.printf("Player's health: %d units%n", initialHealth);
        printMatrix(matrix);
    }

    public static int[] getPlayerPosition(char[][] matrix) {
        int[] playerPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                    break;
                }
            }
        }
        return playerPosition;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
