import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] neighborhoodMatrix = new char[n][n];

        for (int row = 0; row < neighborhoodMatrix.length; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            neighborhoodMatrix[row] = line.toCharArray();
        }

        int[] santaPosition = getSantaPosition(neighborhoodMatrix);
        int santaRow = santaPosition[0];
        int santaCol = santaPosition[1];

        int niceChildrenCounter = getNiceChildrenCount(neighborhoodMatrix);
        int result = niceChildrenCounter - m;
        boolean isRunOutOfPresents = false;

        String command = scanner.nextLine();

        while (!command.equals("Christmas morning")) {

            neighborhoodMatrix[santaRow][santaCol] = '-';

            switch (command) {
                case "up" -> santaRow--;
                case "down" -> santaRow++;
                case "left" -> santaCol--;
                case "right" -> santaCol++;
            }

            if (neighborhoodMatrix[santaRow][santaCol] == 'X') {
                // naughty kid

            }

            if (neighborhoodMatrix[santaRow][santaCol] == 'V') {
                // nice kid
                m--;
                if (m < niceChildrenCounter) {
                    isRunOutOfPresents = true;
                    neighborhoodMatrix[santaRow][santaCol] = 'S';
                    break;
                }
            }

            if (neighborhoodMatrix[santaRow][santaCol] == 'C') {

                neighborhoodMatrix[santaRow][santaCol] = 'S';

                if (neighborhoodMatrix[santaRow--][santaCol] == 'V' || neighborhoodMatrix[santaRow--][santaCol] == 'X') {
                    m--;
                    santaRow++;
                    neighborhoodMatrix[santaRow][santaCol] = '-';
                    santaRow++;
                }
                if (neighborhoodMatrix[santaRow++][santaCol] == 'V' || neighborhoodMatrix[santaRow++][santaCol] == 'X') {
                    m--;
                    santaRow--;
                    neighborhoodMatrix[santaRow][santaCol] = '-';
                    santaRow--;
                }
                if (neighborhoodMatrix[santaRow][santaCol--] == 'V' || neighborhoodMatrix[santaRow][santaCol--] == 'X') {
                    m--;
                    santaCol++;
                    neighborhoodMatrix[santaRow][santaCol] = '-';
                    santaCol++;
                }
                if (neighborhoodMatrix[santaRow][santaCol++] == 'V' || neighborhoodMatrix[santaRow][santaCol++] == 'X') {
                    m--;
                    santaCol--;
                    neighborhoodMatrix[santaRow][santaCol] = '-';
                    santaCol--;
                }
            }

            neighborhoodMatrix[santaRow][santaCol] = 'S';
            command = scanner.nextLine();
        }

        if (isRunOutOfPresents) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(neighborhoodMatrix);

        if (m < niceChildrenCounter) {
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
