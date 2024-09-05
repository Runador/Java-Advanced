package firstandreserveteam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Team team = new Team("Team");

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Person person = new Person(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
            team.addPlayer(person);
        }

        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players", team.getReserveTeam().size());
    }
}
