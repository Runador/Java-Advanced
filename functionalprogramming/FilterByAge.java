package functionalprogramming;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

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

        for (var entry : people.entrySet()) {
            if (condition.equals("younger")) {
                List<Integer> younger = new ArrayList<>();
                younger.add(entry.getValue());
                Optional<Integer> y = younger.stream().max(Comparator.comparing(Integer::intValue));
                System.out.println(y);
                younger.stream().filter(e -> e % 2 == 0).mapToInt()
            } else if (condition.equals("older")) {

            }

        }


    }
}
