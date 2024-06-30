import java.util.Scanner;

public class BookWorm {

    private static int pRow;
    private static int pCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialString = scanner.nextLine();

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] pPosition = getPosition(matrix);
        pRow = pPosition[0];
        pCol = pPosition[1];

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            matrix[pRow][pCol] = '-';

            switch (command) {
                case "up" -> pRow--;
                case "down" -> pRow++;
                case "left" -> pCol--;
                case "right" -> pCol++;
            }

            if (pRow < 0 || pRow > matrix.length - 1 ||
                    pCol < 0 || pCol > matrix.length - 1) {
                initialString = getFormattedString(pRow, pCol, matrix, initialString);
            }

            if (Character.isLetter(matrix[pRow][pCol])) {
                initialString += matrix[pRow][pCol];
                matrix[pRow][pCol] = '-';
            }

            matrix[pRow][pCol] = 'P';
            command = scanner.nextLine();
        }

        System.out.println(initialString);
        printMatrix(matrix);
    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }

    private static String getFormattedString(int pRow, int pCol, char[][] matrix, String initialString) {
        if (pRow < 0) {
            BookWorm.pRow++;
        } else if (pRow > matrix.length - 1) {
            BookWorm.pRow--;
        } else if (pCol < 0) {
            BookWorm.pCol++;
        } else if (pCol > matrix.length - 1) {
            BookWorm.pCol--;
        }
        if (!initialString.isEmpty()) {
            initialString = initialString.substring(0, initialString.length() - 1);
        }
        return initialString;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
