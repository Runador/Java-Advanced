import java.util.Scanner;

public class MouseInTheKitchen1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] playerCoordinates = getPlayerPosition(matrix);
        int pRow = playerCoordinates[0];
        int pCol = playerCoordinates[1];

        boolean isOutOfBounds = false;
        boolean areAllCheeseCollected = false;
        int counter = getCounter(matrix);

        String command = scanner.nextLine();

        while (!command.equals("danger")) {

            int previousRow = pRow;
            int previousCol = pCol;

            matrix[pRow][pCol] = '*';

            switch (command) {
                case "up" -> pRow--;
                case "down" -> pRow++;
                case "left" -> pCol--;
                case "right" -> pCol++;
            }

            if (pRow < 0 || pRow > matrix.length - 1 ||
                    pCol < 0 || pCol > matrix.length - 1) {
                isOutOfBounds = true;
                break;
            }

            if (matrix[pRow][pCol] == '@') {
                matrix[previousRow][previousCol] = 'M';
                matrix[pRow][pCol] = matrix[previousRow][previousCol];
                command = scanner.nextLine();
                continue;
            }

            if (matrix[pRow][pCol] == 'C') {
                counter--;
                matrix[pRow][pCol] = 'M';
                if (counter == 0) {
                    areAllCheeseCollected = true;
                    break;
                }
            }

            if (matrix[pRow][pCol] == 'T') {
                System.out.println("Mouse is trapped!");
                printMatrix(matrix);
                break;
            }

            matrix[pRow][pCol] = 'M';
            command = scanner.nextLine();
        }

        if (isOutOfBounds) {
            System.out.println("No more cheese for tonight!");
            printMatrix(matrix);
        }

        if (areAllCheeseCollected) {
            System.out.println("Happy mouse! All the cheese is eaten, good night!");
            printMatrix(matrix);
        } else {
            System.out.println("Mouse will come back later!");
            printMatrix(matrix);
        }
    }

    public static int[] getPlayerPosition(char[][] matrix) {
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
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static int getCounter(char[][] matrix) {
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'C') {
                    counter++;
                }
            }
        }
        return counter;
    }
}
