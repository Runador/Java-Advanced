import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] neighborhood = new char[size][size];

        for (int row = 0; row < neighborhood.length; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            neighborhood[row] = line.toCharArray();
        }

        int[] santaPosition = getSantaPosition(neighborhood);
        int santaRow = santaPosition[0];
        int santaCol = santaPosition[1];

        int niceChildrenCounter = getNiceChildrenCount(neighborhood);
        int result = niceChildrenCounter - countOfPresents;
        boolean isRunOutOfPresents = false;

        String command = scanner.nextLine();

        while (!command.equals("Christmas morning")) {

            neighborhood[santaRow][santaCol] = '-';

            switch (command) {
                case "up" -> santaRow--;
                case "down" -> santaRow++;
                case "left" -> santaCol--;
                case "right" -> santaCol++;
            }

            if (neighborhood[santaRow][santaCol] == 'V') {
                countOfPresents--;
                if (countOfPresents < niceChildrenCounter) {
                    isRunOutOfPresents = true;
                    neighborhood[santaRow][santaCol] = 'S';
                    break;
                }
            }

            if (neighborhood[santaRow][santaCol] == 'C') {
                neighborhood[santaRow][santaCol] = 'S';
                if (neighborhood[santaRow--][santaCol] == 'V' || neighborhood[santaRow--][santaCol] == 'X') {
                    countOfPresents--;
                    santaRow++;
                    neighborhood[santaRow][santaCol] = '-';
                    santaRow++;
                }
                if (neighborhood[santaRow++][santaCol] == 'V' || neighborhood[santaRow++][santaCol] == 'X') {
                    countOfPresents--;
                    santaRow--;
                    neighborhood[santaRow][santaCol] = '-';
                    santaRow--;
                }
                if (neighborhood[santaRow][santaCol--] == 'V' || neighborhood[santaRow][santaCol--] == 'X') {
                    countOfPresents--;
                    santaCol++;
                    neighborhood[santaRow][santaCol] = '-';
                    santaCol++;
                }
                if (neighborhood[santaRow][santaCol++] == 'V' || neighborhood[santaRow][santaCol++] == 'X') {
                    countOfPresents--;
                    santaCol--;
                    neighborhood[santaRow][santaCol] = '-';
                    santaCol--;
                }
            }

            neighborhood[santaRow][santaCol] = 'S';

            command = scanner.nextLine();
        }

        if (isRunOutOfPresents) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(neighborhood);
        if (countOfPresents < niceChildrenCounter) {
            System.out.printf("No presents for %d nice kid/s.", result);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", niceChildrenCounter);
        }
    }

    private static int getNiceChildrenCount(char[][] matrix) {
        int counter = 0;
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'V') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int[] getSantaPosition(char[][] matrix) {
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
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
