import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] armory = new char[n][n];

        for (int row = 0; row < armory.length; row++) {
            armory[row] = scanner.nextLine().toCharArray();
        }

        int[] aPosition = getPosition(armory);
        int aRow = aPosition[0];
        int aCol = aPosition[1];

        int[] secondMirrorPosition = getSecondMirrorPosition(armory);
        int secondMirrorPositionRow = secondMirrorPosition[0];
        int secondMirrorPositionCol = secondMirrorPosition[1];

        int boughtSwords = 0;

        String command = scanner.nextLine();

        while (true) {

            armory[aRow][aCol] = '-';

            switch (command) {
                case "up" -> aRow--;
                case "down" -> aRow++;
                case "left" -> aCol--;
                case "right" -> aCol++;
            }

            if (aRow < 0 || aRow > armory.length - 1 ||
                    aCol < 0 || aCol > armory.length - 1) {
                System.out.println("I do not need more swords!");
                System.out.printf("The king paid %d gold coins.\n", boughtSwords);
                printMatrix(armory);
                break;
            }

            if (Character.isDigit(armory[aRow][aCol])) {
                boughtSwords += Integer.parseInt(String.valueOf(armory[aRow][aCol]));
                if (boughtSwords >= 65) {
                    armory[aRow][aCol] = 'A';
                    System.out.println("Very nice swords, I will come back for more!");
                    System.out.printf("The king paid %d gold coins.\n", boughtSwords);
                    printMatrix(armory);
                    break;
                }
            }

            if (armory[aRow][aCol] == 'M') {
                armory[aRow][aCol] = '-';
                aRow = secondMirrorPositionRow;
                aCol = secondMirrorPositionCol;
                armory[aRow][aCol] = 'A';
                command = scanner.nextLine();
                continue;
            }

            armory[aRow][aCol] = 'A';
            command = scanner.nextLine();
        }
    }

    private static int[] getSecondMirrorPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (counter == 2) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
                if (matrix[row][col] == 'M') {
                    counter++;
                }
            }
        }
        return coordinates;
    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'A') {
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
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
