import java.util.Scanner;

public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(",");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        char[][] area = new char[rows][cols];

        for (int row = 0; row < area.length; row++) {
            area[row] = scanner.nextLine().toCharArray();
        }

        int[] mousePosition = getMousePosition(area);
        int mouseRow = mousePosition[0];
        int mouseCol = mousePosition[1];
        int cheeseCounter = getCheeseCounter(area);
        boolean isEatenAllCheese = false;
        boolean isFailed = false;

        String command = scanner.nextLine();

        while (!command.equals("Danger")) {

            area[mouseRow][mouseCol] = '*';

            switch (command) {
                case "up" -> mouseRow--;
                case "down" -> mouseRow++;
                case "left" -> mouseCol--;
                case "right" -> mouseCol++;
            }

            if (mouseRow < 0) {
                isFailed = true;
                mouseRow++;
            } else if (mouseRow > area.length - 1) {
                isFailed = true;
                mouseRow--;
            } else if (mouseCol < 0) {
                isFailed = true;
                mouseCol++;
            } else if (mouseCol >= cols) {
                isFailed = true;
                mouseCol--;
            }

            if (isFailed) {
                area[mouseRow][mouseCol] = 'M';
                System.out.println("No more cheese for tonight!");
                break;
            }

            if (area[mouseRow][mouseCol] == 'C') {
                cheeseCounter--;
                if (cheeseCounter == 0) {
                    isEatenAllCheese = true;
                    break;
                }
            }

            if (area[mouseRow][mouseCol] == 'T') {
                System.out.println("Mouse is trapped!");
                break;
            }

            command = scanner.nextLine();
            continue;
        }

        area[mouseRow][mouseCol] = 'M';

        command = scanner.nextLine();

        if (isEatenAllCheese) {
            System.out.println("Happy mouse! All the cheese is eaten, good night!");
        } /*else {
            System.out.println("Mouse will come back later!");
        }*/

        printArea(area);

    }


    public static int[] getMousePosition(char[][] area) {
        int[] mousePosition = new int[2];
        for (int row = 0; row < area.length; row++) {
            for (int col = 0; col < area[row].length; col++) {
                if (area[row][col] == 'M') {
                    mousePosition[0] = row;
                    mousePosition[1] = col;
                    break;
                }
            }
        }
        return mousePosition;
    }

    public static int getCheeseCounter(char[][] area) {
        int cheeseCounter = 0;
        for (int row = 0; row < area.length; row++) {
            for (int col = 0; col < area[row].length; col++) {
                if (area[row][col] == 'C') {
                    cheeseCounter++;
                }
            }
        }
        return cheeseCounter;
    }

    private static void printArea(char[][] area) {
        for (int row = 0; row < area.length; row++) {
            for (int col = 0; col < area[row].length; col++) {
                System.out.print(area[row][col]);
            }
            System.out.println();
        }
    }

}
