package birthday_celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> individuals = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            if (data[0].equals("Citizen")) {
                individuals.add(new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]));
            } else if (data[0].equals("Pet")) {
                individuals.add(new Pet(data[1], data[2]));
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable individual : individuals) {
            String[] dateOfBirth = individual.getBirthDate().split("/");
            if (dateOfBirth[2].equals(year)) {
                System.out.printf("%s/%s/%s\n", dateOfBirth[0], dateOfBirth[1], dateOfBirth[2]);
            }
        }
    }
}
