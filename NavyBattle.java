import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int damageCounter = 0;
        int cruiserCounter = 0;

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        int[] sPosition = getPosition(matrix);
        int sRow = sPosition[0];
        int sCol = sPosition[1];

        String command = scanner.nextLine();

        while (true) {

            matrix[sRow][sCol] = '-';

            switch (command) {
                case "up" -> sRow--;
                case "down" -> sRow++;
                case "left" -> sCol--;
                case "right" -> sCol++;
            }

            if (matrix[sRow][sCol] == '*') {
                matrix[sRow][sCol] = '-';
                damageCounter++;
                if (damageCounter == 3) {
                    matrix[sRow][sCol] = 'S';
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n",
                            sRow, sCol);
                    printMatrix(matrix);
                    break;
                }
            }

            if (matrix[sRow][sCol] == 'C') {
                matrix[sRow][sCol] = '-';
                cruiserCounter++;
                if (cruiserCounter == 3) {
                    matrix[sRow][sCol] = 'S';
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    printMatrix(matrix);
                    break;
                }
            }

            matrix[sRow][sCol] = 'S';
            command = scanner.nextLine();
        }

    }

    private static int[] getPosition(char[][] matrix) {
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

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
