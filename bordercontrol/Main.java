package bordercontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> individuals = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            if (data.length == 2) {
                individuals.add(new Robot(data[0], data[1]));
            } else if (data.length == 3) {
                individuals.add(new Citizen(data[0], Integer.parseInt(data[1]), data[2]));
            }

            input = scanner.nextLine();
        }

        String number = scanner.nextLine();

        /*individuals.stream()
                .filter(individual -> individual.getId().endsWith(number))
                .forEach(individual -> System.out.println(individual.getId()));*/

        for (Identifiable individual : individuals) {
            if (individual.getId().endsWith(number)) {
                System.out.println(individual.getId());
            }
        }
    }
}
