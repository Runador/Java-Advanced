import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int N = Integer.parseInt(dimensions[0]);
        int M = Integer.parseInt(dimensions[1]);

        char[][] matrix = new char[N][M];
        int touchedOpponents = 0;
        int myMovesMade = 0;

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        int[] bPosition = getPosition(matrix);
        int bRow = bPosition[0];
        int bCol = bPosition[1];

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {

            matrix[bRow][bCol] = '-';

            if (matrix[bRow][bCol] == '-') {
                myMovesMade++;
            }

            switch (command) {
                case "up" -> bRow--;
                case "down" -> bRow++;
                case "left" -> bCol--;
                case "right" -> bCol++;
            }

            if (bRow < 0 || bRow > matrix.length - 1 ||
                    bCol < 0 || bCol > matrix.length - 1) {
                switch (command) {
                    case "up" -> bRow++;
                    case "down" -> bRow--;
                    case "left" -> bCol++;
                    case "right" -> bCol--;
                }
                myMovesMade--;
            }

            if (matrix[bRow][bCol] == 'O') {
                switch (command) {
                    case "up" -> bRow++;
                    case "down" -> bRow--;
                    case "left" -> bCol++;
                    case "right" -> bCol--;
                }
                myMovesMade--;
            }

            if (matrix[bRow][bCol] == 'P') {
                touchedOpponents++;
                if (touchedOpponents == 3) {
                    break;
                }
            }

            matrix[bRow][bCol] = 'B';
            command = scanner.nextLine();
        }

        System.out.printf("Game over!%nTouched opponents: %d Moves made: %d",
                touchedOpponents, myMovesMade);
    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
