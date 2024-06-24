import java.util.Scanner;

public class Beesy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int beePosition[] = getBeePosition(matrix);
        int beeRow = beePosition[0];
        int beeCol = beePosition[1];

        int initialEnergy = 15;
        int unitsOfNectar = 0;
        int continueCounter = 0;

        boolean isHReached = false;
        boolean energyRestored = false;

        String command = scanner.nextLine();

        while (initialEnergy > 0) {

            matrix[beeRow][beeCol] = '-';

            switch (command) {
                case "up" -> beeRow--;
                case "down" -> beeRow++;
                case "left" -> beeCol--;
                case "right" -> beeCol++;
            }

            if (beeRow < 0) {
                beeRow = matrix.length- 1;
            } else if (beeRow > matrix.length - 1) {
                beeRow--;
            } else if (beeCol < 0) {
                beeCol = matrix.length - 1;
            } else if (beeCol > matrix.length - 1) {
                beeCol--;
            }

            if (Character.isDigit(matrix[beeRow][beeCol])) {
                unitsOfNectar += Integer.parseInt(String.valueOf(matrix[beeRow][beeCol]));
            }
            initialEnergy--;

            if (initialEnergy <= 0) {
                if (unitsOfNectar >= 30 && !energyRestored) {
                    initialEnergy = unitsOfNectar - 30;
                    unitsOfNectar = 30;
                    energyRestored = true;
                    if (initialEnergy > 0) {
                        continue;
                    }
                }
                matrix[beeRow][beeCol] = 'B';
                System.out.println("This is the end! Beesy ran out of energy.");
                printMatrix(matrix);
                return;
            }

            if (matrix[beeRow][beeCol] == 'H') {
                matrix[beeRow][beeCol] = 'B';
                isHReached = true;
                break;
            }

            matrix[beeRow][beeCol] = 'B';

            command = scanner.nextLine();
        }

        if (isHReached){
            if (unitsOfNectar >= 30) {
                System.out.printf("Great job, Beesy! The hive is full. Energy left: %d%n", initialEnergy);
                printMatrix(matrix);
            } else {
                System.out.println("Beesy did not manage to collect enough nectar.");
                printMatrix(matrix);
            }
        }

    }

    public static int[] getBeePosition(char[][] matrix) {
        int[] beePosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    beePosition[0] = row;
                    beePosition[1] = col;
                    break;
                }
            }
        }
        return beePosition;
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
