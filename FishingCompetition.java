package examPreparation13December2023;

import java.util.Scanner;

public class FishingCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] fishingArea = new char[n][n];
        fillTheMatrix(fishingArea, scanner);

        int collectedFish = 0;
        int[] shipCoordinates = new int[1];

        String input = scanner.nextLine();

        while (!input.equals("collect the nets")) {

            String command = input;

            if (command.equals("up")) {

            } else if (command.equals("down")) {

            } else if (command.equals("left")) {

            } else if (command.equals("right")) {

            }

            input = scanner.nextLine();
        }

    }

    public static void fillTheMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }

}


