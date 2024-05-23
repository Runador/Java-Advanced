package exercisesSetsАndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> strings = new LinkedHashSet<>();

        while (n-- > 0) {
            String input = scanner.nextLine();
            strings.add(input);
        }

        strings.forEach(System.out::println);
    }
}
