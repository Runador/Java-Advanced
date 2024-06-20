import java.util.Scanner;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }

        int collectedPassages = 0;

        int[] myPosition = getMyPosition(matrix);
        int myRow = myPosition[0];
        int myCol = myPosition[1];

        String input = scanner.nextLine();
        while (!input.equals("collect the nets")) {
            String command = input;

            matrix[myRow][myCol] = '-';

            switch (command) {
                case "up" -> myRow--;
                case "down" -> myRow++;
                case "left" -> myCol--;
                case "right" -> myCol++;
            }

            if (myRow < 0) {
                myRow = matrix.length - 1;
            } else if (myRow > matrix.length - 1) {
                myRow = 0;
            }
            if (myCol < 0) {
                myCol = matrix.length - 1;
            } else if (myCol > matrix.length - 1) {
                myCol = 0;
            }

            if (matrix[myRow][myCol] == 'W') {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                        "Last coordinates of the ship: [%d,%d]", myRow, myCol);
                return;
            } else if (Character.isDigit(matrix[myRow][myCol])) {
                collectedPassages += Integer.parseInt(matrix[myRow][myCol] + "");
                matrix[myRow][myCol] = '-';
            }

            matrix[myRow][myCol] = 'S';

            input = scanner.nextLine();
        }

        if (collectedPassages >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! " +
                    "You need %d tons of fish more.\n", 20 - collectedPassages);
        }
        if (collectedPassages > 0) {
            System.out.printf("Amount of fish caught: %d tons.\n", collectedPassages);
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static int[] getMyPosition(char[][] matrix) {
        int[] myPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char S = 'S';
                if (matrix[row][col] == S) {
                    myPosition[0] = row;
                    myPosition[1] = col;
                    break;
                }
            }
        }
        return myPosition;
    }

}


