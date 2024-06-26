package exercisesworkingwithabstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int bagCapacity = Integer.parseInt(scanner.nextLine());
        String[] tokens = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Integer>> bag = new LinkedHashMap<>();
        int goldAmount = 0;
        int gemAmount = 0;
        int cashAmount = 0;

        for (int i = 0; i < tokens.length; i += 2) {

            String name = tokens[i];
            int quantity = Integer.parseInt(tokens[i + 1]);

            String input = "";

            if (name.length() == 3) {
                input = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                input = "Gem";
            } else if (name.equals("goldAmount".toLowerCase())) {
                input = "Gold";
            }

            if (input.equals("")) {
                continue;
            } else if (bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream)
                    .mapToLong(e -> e).sum() + quantity) {
                continue;
            }

            switch (input) {
                case "Gem":
                    if (!bag.containsKey(input)) {
                        if (bag.containsKey("Gold")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(input).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold")
                            .values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(input)) {
                        if (bag.containsKey("Gem")) {
                            if (quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(input).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem")
                            .values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(input)) {
                bag.put((input), new LinkedHashMap<>());
            }

            if (!bag.get(input).containsKey(name)) {
                bag.get(input).put(name, 0);
            }


            bag.get(input).put(name, bag.get(input).get(name) + quantity);

            switch (input) {
                case "Gold" -> goldAmount += quantity;
                case "Gem" -> gemAmount += quantity;
                case "Cash" -> cashAmount += quantity;
            }
        }

        for (var entry : bag.entrySet()) {

            Integer totalAmount = entry.getValue().values().stream().mapToInt(integer -> integer).sum();

            System.out.printf("<%s> $%s\n", entry.getKey(), totalAmount);

            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

}
