import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isOutOfBounds = false;
        boolean areMoreThenFivePolinatedFlowers = false;
        int pollinatedFlowers = 0;

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int[] bPosition = getPosition(matrix);
        int bRow = bPosition[0];
        int bCol = bPosition[1];

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            matrix[bRow][bCol] = '.';

            switch (command) {
                case "up" -> bRow--;
                case "down" -> bRow++;
                case "left" -> bCol--;
                case "right" -> bCol++;
            }

            if (bRow < 0 || bRow > matrix.length - 1 ||
                    bCol < 0 || bCol > matrix.length - 1) {
                isOutOfBounds = true;
                break;
            }

            if (matrix[bRow][bCol] == 'f') {
                matrix[bRow][bCol] ='.';
                pollinatedFlowers++;
                if (pollinatedFlowers >= 5) {
                    areMoreThenFivePolinatedFlowers = true;
                }
            }

            if (matrix[bRow][bCol] == 'O') {
                matrix[bRow][bCol] ='.';
                switch (command) {
                    case "up" -> bRow--;
                    case "down" -> bRow++;
                    case "left" -> bCol--;
                    case "right" -> bCol++;
                }
                if (bRow < 0 || bRow > matrix.length - 1 ||
                        bCol < 0 || bCol > matrix.length - 1) {
                    isOutOfBounds = true;
                    break;
                }

                if (matrix[bRow][bCol] == 'f') {
                    matrix[bRow][bCol] ='.';
                    pollinatedFlowers++;
                    if (pollinatedFlowers >= 5) {
                        areMoreThenFivePolinatedFlowers = true;
                    }
                }

                matrix[bRow][bCol] = 'B';
            }

            matrix[bRow][bCol] = 'B';

            command = scanner.nextLine();
        }

        if (isOutOfBounds) {
            System.out.println("The bee got lost!");
        }
        if (areMoreThenFivePolinatedFlowers) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }
        printMatrix(matrix);
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

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
