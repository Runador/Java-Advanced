import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> textilesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> medicamentsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(textilesQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(medicamentsStack::push);

        Map<String, Integer> healingItemsMap = new TreeMap<>();
        healingItemsMap.put("Patch", 0);
        healingItemsMap.put("Bandage", 0);
        healingItemsMap.put("MedKit", 0);

        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {

            int textile = textilesQueue.peek();
            int medicament = medicamentsStack.peek();
            int sum = textile + medicament;

            if (sum == 30) {
                if (!healingItemsMap.containsKey("Patch")) {
                    healingItemsMap.put("Patch", 1);
                } else {
                    healingItemsMap.put("Patch", healingItemsMap.get("Patch") + 1);
                }
                textilesQueue.poll();
                medicamentsStack.pop();
            } else if (sum == 40) {
                if (!healingItemsMap.containsKey("Bandage")) {
                    healingItemsMap.put("Bandage", 1);
                } else {
                    healingItemsMap.put("Bandage", healingItemsMap.get("Bandage") + 1);
                }
                textilesQueue.poll();
                medicamentsStack.pop();
            } else if (sum == 100) {
                if (!healingItemsMap.containsKey("MedKit")) {
                    healingItemsMap.put("MedKit", 1);
                } else {
                    healingItemsMap.put("MedKit", healingItemsMap.get("MedKit") + 1);
                }
                textilesQueue.poll();
                medicamentsStack.pop();
            } else if (sum > 100) {
                if (!healingItemsMap.containsKey("MedKit")) {
                    healingItemsMap.put("MedKit", 1);
                } else {
                    healingItemsMap.put("MedKit", healingItemsMap.get("MedKit") + 1);
                }
                /*remove both values, and add the remaining resources(of the sum) to the next value in the
                medicament collection (Take the element from the collection, add the remaining sum to it,
                and put the element back to its place). */
                textilesQueue.poll();
                medicamentsStack.pop();
                medicamentsStack.push( medicamentsStack.pop() + sum - 100);
            } else {
                /* remove the textile value, add 10 to the medicament value, and return the medicament
                 back to its place, into its collection. */
                textilesQueue.poll();
                medicament += 10;
                medicamentsStack.pop();
                medicamentsStack.push(medicament);
            }
        }

        if (textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {
            System.out.println("Textiles are empty.");
        }
        if (medicamentsStack.isEmpty() && !textilesQueue.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }
        if (textilesQueue.isEmpty() && medicamentsStack.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        }

        List<Map.Entry<String, Integer>> itemList = new ArrayList<>(healingItemsMap.entrySet());

        itemList.sort((entry1, entry2) -> {
            int amountComparison = entry2.getValue().compareTo(entry1.getValue());
            if (amountComparison != 0) {
                return amountComparison;
            } else {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });
        for (Map.Entry<String, Integer> entry : itemList) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        if (!medicamentsStack.isEmpty()) {
            System.out.print("Medicaments left: ");
            System.out.println(String.join(", ", medicamentsStack.toString().replaceAll("[\\[\\]]", "")));
        }
        if (!textilesQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            System.out.println(String.join(", ", textilesQueue.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
