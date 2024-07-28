import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int collectedMoney = 0;
        boolean isOutOfBounds = false;
        int[] playerPosition = getPlayerPosition(matrix);
        int pRow = playerPosition[0];
        int pCol = playerPosition[1];

        int oRow = getSecondPipePosition(matrix)[0];
        int oCol = getSecondPipePosition(matrix)[1];

        String command = scanner.nextLine();

        while (true) {

            matrix[pRow][pCol] = '-';

            if (command.equals("up")) {
                pRow--;
            } else if (command.equals("down")) {
                pRow++;
            } else if (command.equals("left")) {
                pCol--;
            } else if (command.equals("right")) {
                pCol++;
            }

            if (pRow < 0 || pRow > matrix.length - 1 || pCol < 0 || pCol > matrix.length - 1) {
                isOutOfBounds = true;
                break;
            }

            if (matrix[pRow][pCol] == 'O') {
                matrix[pRow][pCol] = '-';
                matrix[oRow][oCol] = matrix[pRow][pCol];
                isOutOfBounds = true;
                break;
            }

            if (Character.isDigit(matrix[pRow][pCol])) {
                matrix[pRow][pCol] = 'S';
                // collectedMoney += Integer.parseInt(matrix[pRow][pCol]);
                if (collectedMoney >= 50) {
                    System.out.println("Good news! You succeeded in collecting enough money!");
                    break;
                }
            }

            matrix[pRow][pCol] = 'S';
            command = scanner.nextLine();
        }

        if (isOutOfBounds) {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.printf("Money: %d\n", collectedMoney);
        printMatrix(matrix);
    }

    public static int[] getPlayerPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
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

    public static int[] getSecondPipePosition(char[][] matrix) {
        int[] oCoordinates = new int[2];
        int counter = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'O') {
                    counter++;
                }
                if (counter == 2) {
                    oCoordinates[0] = row;
                    oCoordinates[1] = col;
                }
            }
        }
        return oCoordinates;
    }
}
