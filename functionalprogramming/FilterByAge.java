package functionalprogramming;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < N; i++) {
            String[] pairs = scanner.nextLine().split(", ");
            String name = pairs[0];
            int age = Integer.parseInt(pairs[1]);

            if (!people.containsKey(name)) {
                people.put(name, age);
            }
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split(" ");

        Predicate<Integer> younger = x -> x <= age;
        Predicate<Integer> older = x -> x >= age;

        for (var entry : people.entrySet()) {
            if (condition.equals("younger") && younger.test(entry.getValue())) {
                if (format.length == 2) {
                    System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                } else if (format[0].equals("name")) {
                    System.out.printf("%s%n", entry.getKey());
                } else if (format[0].equals("age")) {
                    System.out.printf("%d%n", entry.getValue());
                }
            } else if (condition.equals("older") && older.test(entry.getValue())) {
                if (format.length == 2) {
                    System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                } else if (format[0].equals("name")) {
                    System.out.printf("%s%n", entry.getKey());
                } else if (format[0].equals("age")) {
                    System.out.printf("%d%n", entry.getValue());
                }
            }
        }
    }
}
