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

        Map<String, Integer> swordsMap = new TreeMap<>();
        swordsMap.put("Gladius", 0);
        swordsMap.put("Shamshir", 0);
        swordsMap.put("Katana", 0);
        swordsMap.put("Sabre", 0);

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {

            int steel = steelQueue.peek();
            int carbon = carbonStack.peek();

            if (steel + carbon == 70) {
                swordsMap.put("Gladius", swordsMap.get("Gladius") + 1);
                steelQueue.poll();
                carbonStack.pop();
            } else if (steel + carbon == 80) {
                swordsMap.put("Shamshir", swordsMap.get("Shamshir") + 1);
                steelQueue.poll();
                carbonStack.pop();
            } else if (steel + carbon == 90) {
                swordsMap.put("Katana", swordsMap.get("Katana") + 1);
                steelQueue.poll();
                carbonStack.pop();
            } else if (steel + carbon == 110) {
                swordsMap.put("Sabre", swordsMap.get("Sabre") + 1);
                steelQueue.poll();
                carbonStack.pop();
            } else {
                steelQueue.poll();
                carbonStack.push(carbonStack.pop() + 5);
            }
        }

        int totalNumberOfSwords = 0;

        for (var entry : swordsMap.entrySet()) {
            totalNumberOfSwords += entry.getValue();
        }

        if (totalNumberOfSwords > 0) {
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
        for (var entry : swordsMap.entrySet()) {
            String swordName = entry.getKey();
            int swordValue = entry.getValue();
            if (swordValue != 0) {
                System.out.printf("%s: %d%n", swordName, swordValue);
            }
        }
    }
}
