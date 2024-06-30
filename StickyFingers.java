import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialMoney = 0;
        int sumMoney = 0;

        int size = Integer.parseInt(scanner.nextLine());

        char[][] townArea = new char[size][size];

        String[] commands = scanner.nextLine().split(",");
        int movementCommandsLength = commands.length;

        for (int r = 0; r < townArea.length; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            townArea[r] = line.toCharArray();
        }

        int[] dPosition = getPosition(townArea);
        int rows = dPosition[0];
        int cols = dPosition[1];

        for (String command : commands) {

            townArea[rows][cols] = '+';

            switch (command) {
                case "up" -> rows--;
                case "down" -> rows++;
                case "left" -> cols--;
                case "right" -> cols++;
            }

            if (rows < 0) {
                rows++;
                System.out.println("You cannot leave the town, there is police outside!");
            } else if (rows > townArea.length - 1) {
                rows--;
                System.out.println("You cannot leave the town, there is police outside!");
            } else if (cols < 0) {
                cols++;
                System.out.println("You cannot leave the town, there is police outside!");
            } else if (cols > townArea.length - 1) {
                cols--;
                System.out.println("You cannot leave the town, there is police outside!");
            }

            if (townArea[rows][cols] == '$') {
                townArea[rows][cols] = '+';
                initialMoney = rows * cols;
                sumMoney += initialMoney;
                System.out.printf("You successfully stole %d$.%n", initialMoney);
            }

            if (townArea[rows][cols] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", sumMoney);
                townArea[rows][cols] = '#';
                printMatrix(townArea);
                return;
            }

            townArea[rows][cols] = 'D';
        }

        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",
                sumMoney);
        printMatrix(townArea);
    }

    private static int[] getPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'D') {
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
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
