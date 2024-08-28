import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[row] = line.toCharArray();
        }

        int[] bombPosition = getBombPosition(matrix);
        int bRow = bombPosition[0];
        int bCol = bombPosition[1];

        String[] input = scanner.nextLine().split(",");

        for (int i = 0; i < input.length; i++) {

            String command = input[i];

            matrix[bRow][bCol] = '+';

            if (matrix[bRow][bCol] == '+') {

            }

            if (matrix[bRow][bCol] == 'e') {

            }
            if (matrix[bRow][bCol] == 's') {

            }

            matrix[bRow][bCol] = 'B';
        }


    }

    public static int[] getBombPosition(char[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    row = position[0];
                    col = position[1];
                }
            }
        }
        return position;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
        }
    }
}