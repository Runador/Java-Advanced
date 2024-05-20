package ExercisesMultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];

        int asciiA = 97;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char firstLetter = (char) (asciiA + row);
                char secondLetter = (char) (firstLetter + col);
                char thirdLetter = (char) (asciiA + row);
                matrix[row][col] = "" + firstLetter + secondLetter + thirdLetter;
                System.out.printf("%c%c%c ", firstLetter, secondLetter, thirdLetter);
            }
            System.out.println();
        }

    }
}
