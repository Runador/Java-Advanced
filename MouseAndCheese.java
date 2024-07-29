import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] mouseCoordinates = getMouseCoordinates(matrix);
        int mouseRow = mouseCoordinates[0];
        int mouseCol = mouseCoordinates[1];

        int cheeseCounter = 0;

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            matrix[mouseRow][mouseCol] = '-';

            switch (command) {
                case "up" -> mouseRow--;
                case "down" -> mouseRow++;
                case "left" -> mouseCol--;
                case "right" -> mouseCol++;
            }

            if (mouseRow < 0 || mouseRow > matrix.length - 1 || mouseCol < 0 || mouseCol > matrix.length - 1) {
                System.out.println("Where is the mouse?");
                break;
            }

            if (matrix[mouseRow][mouseCol] == 'B') {
                matrix[mouseRow][mouseCol] = 'M';
                matrix[mouseRow][mouseCol] = '-';
                switch (command) {
                    case "up" -> mouseRow--;
                    case "down" -> mouseRow++;
                    case "left" -> mouseCol--;
                    case "right" -> mouseCol++;
                }
            }

            if (matrix[mouseRow][mouseCol] == 'c') {
                cheeseCounter++;
            }

            matrix[mouseRow][mouseCol] = 'M';

            command = scanner.nextLine();
        }

        if (cheeseCounter >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseCounter);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseCounter);
        }
        printMatrix(matrix);
    }

    public static int[] getMouseCoordinates(char[][] matrix) {
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

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
