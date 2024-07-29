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

        Map<String, Integer> healingItems = new LinkedHashMap<>();
        healingItems.put("Patch", 30);
        healingItems.put("Bandage", 40);
        healingItems.put("Medkit", 100);

        Map<String, Integer> healingItemsCountsMap = new TreeMap<>();

        List<Integer> countersList = new ArrayList<>();

        int patchCounter = 0;
        int bandageCounter = 0;
        int medkitCounter = 0;

        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {

            int textile = textilesQueue.peek();
            int medicament = medicamentsStack.peek();

            for (Map.Entry<String, Integer> entry : healingItems.entrySet()) {
                if (textile + medicament == entry.getValue()) {
                    if (textile + medicament == 30) {
                        if (healingItems.containsKey("Patch")) {
                            healingItemsCountsMap.putIfAbsent("Patch", patchCounter++);
                        } else {
                            healingItemsCountsMap.putIfAbsent("Patch", 1);
                        }
                    } else if (textile + medicament == 40) {
                        if (healingItems.containsKey("Bandage")) {
                            healingItemsCountsMap.putIfAbsent("Bandage", bandageCounter++);
                        } else {
                            healingItemsCountsMap.putIfAbsent("Bandage", 1);
                        }
                    } else {
                        if (healingItems.containsKey("Medkit")) {
                            healingItemsCountsMap.putIfAbsent("Medkit", medkitCounter++);
                        } else {
                            healingItemsCountsMap.putIfAbsent("Medkit", 1);
                        }
                    }
                    textilesQueue.poll();
                    medicamentsStack.pop();
                    break;
                } else if (textile + medicament > 100){
                    medkitCounter++;
                    countersList.add(medkitCounter);
                    textilesQueue.poll();
                    medicamentsStack.pop();
                    medicamentsStack.push(medicamentsStack.pop() + Math.abs(100 - (textile + medicament)));
                } else {
                    textilesQueue.poll();
                    medicament += 10;
                    medicamentsStack.push(medicament);
                }
            }
        }

        if (medicamentsStack.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }
        if (textilesQueue.isEmpty()) {
            System.out.println("Textiles are empty.");
        }
        if (medicamentsStack.isEmpty() && textilesQueue.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        }

        for (var entry : healingItemsCountsMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

    }
}
