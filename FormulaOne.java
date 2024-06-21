import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerRow = 0;
        int playerCol = 0;

        int rows = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());
        int counter = commands;
        boolean isReachedFirstPlace = false;

        char[][] matrix = new char[rows][rows];

        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("P")) {
                playerRow = r;
                playerCol = line.indexOf("P");
            }
        }

        for (int i = 0; i < commands; i++) {
            counter--;

            matrix[playerRow][playerCol] = '.';

            String command = scanner.nextLine();

            switch (command) {
                case "up" -> playerRow--;
                case "down" -> playerRow++;
                case "left" -> playerCol--;
                case "right" -> playerCol++;
            }

            if (playerRow < 0) {
                playerRow = matrix.length - 1;
            } else if (playerRow > matrix.length - 1) {
                playerRow = 0;
            }

            if (playerCol < 0) {
                playerCol = matrix.length - 1;
            } else if (playerCol > matrix.length - 1) {
                playerCol = 0;
            }

            if (matrix[playerRow][playerCol] == 'F') {
                System.out.println("Well done, the player won first place!");
                matrix[playerRow][playerCol] = 'P';
                printMatrix(matrix);
                isReachedFirstPlace = true;
                break;
            }

            if (matrix[playerRow][playerCol] == 'B') {
                // If the player steps on a bonus, he should move another step forward
                // in the direction he is going.
                switch (command) {
                    case "up" -> playerRow--;
                    case "down" -> playerRow++;
                    case "left" -> playerCol--;
                    case "right" -> playerCol++;
                }
                if (playerRow < 0) {
                    playerRow = matrix.length - 1;
                } else if (playerRow > matrix.length - 1) {
                    playerRow = 0;
                }
                if (playerCol < 0) {
                    playerCol = matrix.length - 1;
                } else if (playerCol > matrix.length - 1) {
                    playerCol = 0;
                }
                matrix[playerRow][playerCol] = 'P';
            }

            if (matrix[playerRow][playerCol] == 'T') {
                // If the player steps on a trap, he should move a step backward.
                switch (command) {
                    case "up" -> playerRow++;
                    case "down" -> playerRow--;
                    case "left" -> playerCol++;
                    case "right" -> playerCol--;
                }
                if (playerRow < 0) {
                    playerRow = matrix.length - 1;
                } else if (playerRow > matrix.length - 1) {
                    playerRow = 0;
                }
                if (playerCol < 0) {
                    playerCol = matrix.length - 1;
                } else if (playerCol > matrix.length - 1) {
                    playerCol = 0;
                }
                matrix[playerRow][playerCol] = 'P';
            }

            matrix[playerRow][playerCol] = 'P';
        }

        if (counter == 0 && !isReachedFirstPlace) {
            System.out.println("Oh no, the player got lost on the track!");
            printMatrix(matrix);
        }

    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public String currentCommand(String command) {
        String output = "";
        switch (command) {
            case "up" -> output = "up";
            case "down" -> output = "down";
            case "left" -> output = "left";
            case "right" -> output = "right";
        }
        return output;
    }

}

