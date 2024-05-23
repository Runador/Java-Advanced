package exercisesSetsАndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailsMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("stop")) {

            String name = input;
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsMap.put(name, email);
            }

            input = scanner.nextLine();
        }

        for (var entry : emailsMap.entrySet()) {
            System.out.printf("%s – > %s%n", entry.getKey(), entry.getValue());
        }
    }
}
