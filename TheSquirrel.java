import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHazelnuts = 0;
        boolean areAllHazelnutsCollected = false;
        boolean isOutOfBounds = false;

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] field = new char[size][size];

        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().toCharArray();
        }

        int[] squirrelPosition = getPosition(field);
        int sqRow = squirrelPosition[0];
        int sqCol = squirrelPosition[1];

        for (String command : commands) {
            field[sqRow][sqCol] = '*';

            switch (command) {
                case "up" -> sqRow--;
                case "down" -> sqRow++;
                case "left" -> sqCol--;
                case "right" -> sqCol++;
            }

            if (sqRow < 0 || sqRow > field.length - 1 ||
                    sqCol < 0 || sqCol > field.length - 1) {
                isOutOfBounds = true;
                break;
            }

            if (field[sqRow][sqCol] == 'h') {
                initialHazelnuts += 1;
                field[sqRow][sqCol] = 's';
                if (initialHazelnuts == 3) {
                    areAllHazelnutsCollected = true;
                    break;
                }
            }

            if (field[sqRow][sqCol] == 't') {
                System.out.printf("Unfortunately, the squirrel stepped on a trap...%nHazelnuts collected: %d", initialHazelnuts);
                return;
            }

            field[sqRow][sqCol] = 's';
        }

        if (areAllHazelnutsCollected) {
            System.out.println("Good job! You have collected all hazelnuts!\n" +
                    "Hazelnuts collected: 3");
        } else if (isOutOfBounds) {
            System.out.printf("The squirrel is out of the field.%nHazelnuts collected: %d", initialHazelnuts);
        } else {
            System.out.printf("There are more hazelnuts to collect.%nHazelnuts collected: %d", initialHazelnuts);
        }

    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }
        return coordinates;
    }
}
