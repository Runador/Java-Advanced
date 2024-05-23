package exercisesSetsАndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBookMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("search")) {

            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phoneBookMap.putIfAbsent(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equalsIgnoreCase("stop")) {
            String name = input;

            if (phoneBookMap.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phoneBookMap.get(name));
            } else {
                System.out.printf("Contact %s does not exist.%n", name);
            }

            input = scanner.nextLine();
        }

    }
}
