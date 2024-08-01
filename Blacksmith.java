import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(steelQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(carbonStack::push);

        Map<String, Integer> swordsMap = new LinkedHashMap<>();
        swordsMap.put("Gladius", 70);
        swordsMap.put("Shamshir", 80);
        swordsMap.put("Katana", 90);
        swordsMap.put("Sabre", 110);

        Map<String, Integer> swordsFinalMap = new TreeMap<>();

        boolean isFailed = false;

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {

            int steel = steelQueue.peek();
            int carbon = carbonStack.peek();

            for (var entry : swordsMap.entrySet()) {
                int resources = entry.getValue();
                if (steel + carbon == resources) {
                    if (resources == 70) {
                        if (swordsFinalMap.containsKey("Gladius")) {
                            swordsFinalMap.put("Gladius", swordsFinalMap.get("Gladius") + 1);
                        } else {
                            swordsFinalMap.put("Gladius", 1);
                        }
                        steelQueue.poll();
                        carbonStack.pop();
                    }
                    if (resources == 80) {
                        if (swordsFinalMap.containsKey("Shamshir")) {
                            swordsFinalMap.put("Shamshir", swordsFinalMap.get("Shamshir") + 1);
                        } else {
                            swordsFinalMap.put("Shamshir", 1);
                        }
                        steelQueue.poll();
                        carbonStack.pop();
                    }
                    if (resources == 90) {
                        if (swordsFinalMap.containsKey("Katana")) {
                            swordsFinalMap.put("Katana", swordsFinalMap.get("Katana") + 1);
                        } else {
                            swordsFinalMap.put("Katana", 1);
                        }
                        steelQueue.poll();
                        carbonStack.pop();
                    }
                    if (resources == 110) {
                        if (swordsFinalMap.containsKey("Sabre")) {
                            swordsFinalMap.put("Sabre", swordsFinalMap.get("Sabre") + 1);
                        } else {
                            swordsFinalMap.put("Sabre", 1);
                        }
                        steelQueue.poll();
                        carbonStack.pop();
                    }
                }
                if (!swordsMap.containsValue(steel + carbon)) {
                    isFailed = true;
                    break;
                }
            }

            if (isFailed) {
                steelQueue.poll();
                carbonStack.push(carbonStack.pop() + 5);
            }
        }

        boolean areAnySwordsForged = swordsFinalMap.size() > 0;
        int totalNumberOfSwords = 0;

        for (var entry : swordsFinalMap.entrySet()) {
            totalNumberOfSwords += entry.getValue();
        }

        if (areAnySwordsForged) {
            System.out.printf("You have forged %d swords.%n", totalNumberOfSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            System.out.print(String.join(", ", steelQueue.toString().replaceAll("[\\[\\]]", "")));
        }
        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            System.out.print(String.join(", ", carbonStack.toString().replaceAll("[\\[\\]]", "")));
        }
        System.out.println();
        for (var entry : swordsFinalMap.entrySet()) {
            String swordName = entry.getKey();
            int swordValue = entry.getValue();
            System.out.printf("%s: %d%n", swordName, swordValue);
        }
    }
}
