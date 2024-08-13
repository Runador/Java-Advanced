import java.util.Scanner;

public class CollectingStarsGame2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Read the size of the field
        int N = Integer.parseInt(scanner.nextLine());

        // Initialize the field
        char[][] field = new char[N][N];
        int playerRow = 0;
        int playerCol = 0;

        for (int i = 0; i < N; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = row[j].charAt(0);
                if (field[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        // Player's initial state
        int stars = 2; // Initial stars
        int collectedStars = 0; // Collected stars
        boolean gameOver = false;

        // Process commands
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (command.isEmpty()) break;

            // Store the player's current position
            field[playerRow][playerCol] = '.';

            // Move player based on command
            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            // Check if the player is out of bounds
            if (playerRow < 0 || playerRow >= N || playerCol < 0 || playerCol >= N) {
                playerRow = 0;
                playerCol = 0;
            }

            // Handle the current position
            char currentCell = field[playerRow][playerCol];
            if (currentCell == '*') {
                collectedStars++;
                stars++;
                field[playerRow][playerCol] = '.';
            } else if (currentCell == '#') {
                stars--;
                if (stars < 0) {
                    gameOver = true;
                }
            }

            if (collectedStars >= 10) {
                break;
            }
        }

        System.out.println("The final battle is over!");

        if (collectedStars >= 10) {
            System.out.println("You won! You have collected 10 stars.");
        } else if (stars < 0) {
            System.out.println("Game over! You are out of any stars.");
        }

        System.out.printf("Your final position is [%d, %d]%n", playerRow, playerCol);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == playerRow && j == playerCol) {
                    System.out.print("P ");
                } else {
                    System.out.print(field[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
