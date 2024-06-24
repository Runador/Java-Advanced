import java.util.Scanner;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("B")) {
                rows = r;
                cols = line.indexOf("B");
            }
        }

        int[] initialPosition = new int[2];
        initialPosition[0] = rows;
        initialPosition[1] = cols;
        boolean isOutOfBounds = false;

        int[] rPosition = new int[2];

        String command = scanner.nextLine();

        while (isInBounds(rows, cols, matrix)) {

            matrix[rows][cols] = '.';

            int previousRows = rows;
            int previousCols = cols;

            switch (command) {
                case "up" -> rows--;
                case "down" -> rows++;
                case "left" -> cols--;
                case "right" -> cols++;
            }

            if (matrix[rows][cols] == 'P') {
                matrix[rows][cols] = 'R';
                rPosition[0] = rows;
                rPosition[1] = cols;
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            }

            if (matrix[rows][cols] == '*') {
                rows = previousRows;
                cols = previousCols;
                matrix[rows][cols] = 'B';
                command = scanner.nextLine();
                continue;
            }

            if (matrix[rows][cols] == 'A') {
                matrix[rows][cols] = 'P';
                System.out.println("Pizza is delivered on time! Next order...");
                printFullMatrix(initialPosition[0], initialPosition[1], rPosition[0], rPosition[1], matrix);
                break;
            }

            matrix[rows][cols] = 'B';

            command = scanner.nextLine();
        }

        System.out.println("The delivery is late. Order is canceled.");
        printSpotMatrix(initialPosition[0], initialPosition[1], rPosition[0], rPosition[1], matrix);

    }

    public static void printFullMatrix(int bRows, int bCols, int rRows, int rCols, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[bRows][bCols] = 'B';
                matrix[rRows][rCols] = 'R';
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void printSpotMatrix(int bRows, int bCols, int rRows, int rCols, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[bRows][bCols] = ' ';
                matrix[rRows][rCols] = 'R';
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static boolean isInBounds(int r, int c, char[][] matrix) {
        return r >= 0 && r <= matrix.length && c >= 0 && c <= matrix.length;
    }

}
