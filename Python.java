import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pythonLength = 1;

        boolean isGameFinished = false;

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] screen = new char[size][size];

        for (int row = 0; row < screen.length; row++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            screen[row] = line.toCharArray();
        }

        int foodsAmount = getFoodsAmount(screen);
        int[] bPosition = getPosition(screen);
        int pRow = bPosition[0];
        int pCol = bPosition[1];

        for (String command : commands) {

            screen[pRow][pCol] = '*';

            switch (command) {
                case "up" -> pRow--;
                case "down" -> pRow++;
                case "left" -> pCol--;
                case "right" -> pCol++;
            }

            if (pRow < 0) {
                pRow = screen.length - 1;
            } else if (pRow > screen.length - 1) {
                pRow = 0;
            } else if (pCol < 0) {
                pCol = screen.length - 1;
            } else if (pCol > screen.length - 1) {
                pCol = 0;
            }

            if (screen[pRow][pCol] == 'f') {
                pythonLength++;
                foodsAmount--;
                if (foodsAmount == 0) {
                    System.out.printf("You win! Final python length is %d", pythonLength);
                    isGameFinished = true;
                    break;
                }
            }

            if (screen[pRow][pCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                isGameFinished = true;
                break;
            }
        }

        if (!isGameFinished) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodsAmount);
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

    private static int getFoodsAmount(char[][] matrix) {
        int foodsAmount = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'f') {
                    foodsAmount++;
                }
            }
        }
        return foodsAmount;
    }
}

