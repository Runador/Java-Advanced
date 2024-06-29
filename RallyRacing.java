import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kilometersPassed = 0;

        int n = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        int[] sPosition = new int[2];
        int carRow = sPosition[0];
        int carCol = sPosition[0];

        int[] secondTPosition = getSecondTPosition(matrix);
        int tRow = secondTPosition[0];
        int tCol = secondTPosition[1];

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            matrix[carRow][carCol] = '.';

            switch (command) {
                case "up" -> carRow--;
                case "down" -> carRow++;
                case "left" -> carCol--;
                case "right" -> carCol++;
            }

            if (matrix[carRow][carCol] == 'T') {
                matrix[carRow][carCol] = '.';
                kilometersPassed += 30;
                carRow = tRow;
                carCol = tCol;
                matrix[carRow][carCol] = '.';
                command = scanner.nextLine();
                continue;
            }

            kilometersPassed += 10;

            if (matrix[carRow][carCol] == 'F') {
                matrix[carRow][carCol] = 'C';
                System.out.printf("Racing car %s finished the stage!%nDistance covered %d km.\n"
                        , racingNumber, kilometersPassed);
                printMatrix(matrix);
                return;
            }

            matrix[carRow][carCol] = 'C';
            command = scanner.nextLine();
        }

        System.out.printf("Racing car %s DNF.%nDistance covered %d km.\n", racingNumber, kilometersPassed);
        printMatrix(matrix);
    }

    private static int[] getSecondTPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (counter == 2) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
                if (matrix[row][col] == 'T') {
                    counter++;
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
