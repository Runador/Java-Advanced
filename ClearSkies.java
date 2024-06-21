import java.util.Scanner;

public class ClearSkies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] protectedAirspace = new char[n][n];

        for (int row = 0; row < protectedAirspace.length; row++) {
            protectedAirspace[row] = scanner.nextLine().toCharArray();
        }

        int[] jetFighterPosition = getJetFighterPosition(protectedAirspace);
        int jetFighterRow = jetFighterPosition[0];
        int jetFighterCol = jetFighterPosition[1];

        int initialArmor = 300;
        int enemyCounter = 4;

        String command = scanner.nextLine();

        while (enemyCounter > 0) {

            protectedAirspace[jetFighterRow][jetFighterCol] = '-';

            switch (command) {
                case "up" -> jetFighterRow--;
                case "down" -> jetFighterRow++;
                case "left" -> jetFighterCol--;
                case "right" -> jetFighterCol++;
            }

            if (protectedAirspace[jetFighterRow][jetFighterCol] == 'E') {
                initialArmor -= 100;
                protectedAirspace[jetFighterRow][jetFighterCol] = 'J';
                enemyCounter--;
                if (enemyCounter == 0) {
                    System.out.println("Mission accomplished, you neutralized the aerial threat!");
                    break;
                }
                if (initialArmor <= 0) {
                    System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!\n",
                            jetFighterRow, jetFighterCol);
                    break;
                }
            }

            if (protectedAirspace[jetFighterRow][jetFighterCol] == 'R') {
                if (initialArmor < 300) {
                    initialArmor = 300;
                }
            }

            protectedAirspace[jetFighterRow][jetFighterCol] = 'J';

            command = scanner.nextLine();
        }

        printMatrix(protectedAirspace);
    }

    private static void printMatrix(char[][] protectedAirspace) {
        for (int row = 0; row < protectedAirspace.length; row++) {
            for (int col = 0; col < protectedAirspace[row].length; col++) {
                System.out.print(protectedAirspace[row][col]);
            }
            System.out.println();
        }
    }

    public static int[] getJetFighterPosition(char[][] protectedAirspace) {
        int[] jetFighterPosition = new int[2];
        for (int row = 0; row < protectedAirspace.length; row++) {
            for (int col = 0; col < protectedAirspace[row].length; col++) {
                if (protectedAirspace[row][col] == 'J') {
                    jetFighterPosition[0] = row;
                    jetFighterPosition[1] = col;
                    break;
                }
            }
        }
        return jetFighterPosition;
    }

}
