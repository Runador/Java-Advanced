import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        List<String> path = new ArrayList<>();

        boolean isFinished = false;

        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            matrix[r] = line.toCharArray();
            if (line.contains("Y")) {
                rows = r;
                cols = line.indexOf("Y");
            }
        }

        int[] initialPosition = new int[2];
        initialPosition[0] = rows;
        initialPosition[1] = cols;

        String command = scanner.nextLine();

        while (!command.equals("Finish")) {

            matrix[rows][cols] = '-';

            switch (command) {
                case "up" -> rows--;
                case "down" -> rows++;
                case "left" -> cols--;
                case "right" -> cols++;
            }

            if (rows < 0) {
                rows++;
            } else if (rows > matrix.length - 1) {
                rows--;
            } else if (cols < 0) {
                cols++;
            } else if (cols > matrix.length - 1) {
                cols--;
            } else {
                path.add(command);
            }

            if (matrix[rows][cols] == 'T') {
                switch (command) {
                    case "up" -> rows++;
                    case "down" -> rows--;
                    case "left" -> cols++;
                    case "right" -> cols--;
                }
            }

            if (matrix[rows][cols] == 'X') {
                isFinished = true;
                break;
            }

            command = scanner.nextLine();
        }

        if (isFinished) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            String commaDelimited = String.join(", ", path);
            System.out.println(commaDelimited);
        } else {
            System.out.println("The map is fake!");
        }
    }
}
