import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[8][8];

        for (int row = 0; row < board.length; row++) {
            board[row] = scanner.nextLine().toCharArray();
        }

        int[] wPosition = getWhitePosition(board);
        int wRow = wPosition[0];
        int wCol = wPosition[1];

        int[] bPosition = getBlackPosition(board);
        int bRow = bPosition[0];
        int bCol = bPosition[1];

        char wLetter = getColumnLetter(wCol);
        char bLetter = getColumnLetter(bCol);

        while (true) {

            if (isInBounds(wRow, wCol, bRow, bCol, board)) {
                if ((board[wRow - 1][wCol - 1] == board[bRow][bCol]) ||
                        (board[wRow - 1][wCol + 1]) == board[bRow][bCol]) {
                    if (!getCloserDistance(wRow, bRow)) {
                        System.out.printf("Game over! White capture on %c%d.",
                                getColumnLetter(bCol), 8 - bRow);
                    } else {
                        System.out.printf("Game over! Black capture on %c%d.",
                                getColumnLetter(bCol), 8 - bRow);
                    }
                    break;
                }
            }

            wRow++;
            bRow++;

            if (wRow != 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %c8.",
                        wLetter);
                break;
            }

            if (bRow != board.length - 1) {
                System.out.printf("Game over! Black pawn is promoted to a queen at %c0.",
                        bLetter);
                break;
            }
        }

    }

    private static boolean getCloserDistance(int wRow, int bRow) {
        return (8 % wRow) - (8 % bRow) == 0;
    }

    private static boolean isInBounds(int wRow, int wCol, int bRow, int bCol, char[][] board) {
        return (wRow >= 0 || wRow < board.length - 1 ||
                wCol >= 0 || wCol < board.length - 1) &&
                (bRow >= 0 || bRow < board.length - 1 ||
                        bCol >= 0 || bCol < board.length - 1);
    }

    private static char getColumnLetter(int col) {
        char letter = '\0';
        col += 1;
        for (int column = 1; column <= 8; column++) {
            switch (col) {
                case 1 -> letter = 'a';
                case 2 -> letter = 'b';
                case 3 -> letter = 'c';
                case 4 -> letter = 'd';
                case 5 -> letter = 'e';
                case 6 -> letter = 'f';
                case 7 -> letter = 'g';
                case 8 -> letter = 'h';
            }
        }
        return letter;
    }

    private static int[] getWhitePosition(char[][] board) {
        int[] coordinates = new int[2];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'w') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }

    private static int[] getBlackPosition(char[][] board) {
        int[] coordinates = new int[2];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'b') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
