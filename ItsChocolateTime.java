import java.util.*;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQuantityQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoPowderQuantityStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble)
                .forEach(milkQuantityQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble)
                .forEach(cacaoPowderQuantityStack::push);

        Map<String, Integer> chocolateTypes = new TreeMap<>();
        chocolateTypes.put("Milk Chocolate", 0);
        chocolateTypes.put("Dark Chocolate", 0);
        chocolateTypes.put("Baking Chocolate", 0);

        while (!milkQuantityQueue.isEmpty() && !cacaoPowderQuantityStack.isEmpty()) {

            double milk = milkQuantityQueue.peek();
            double cacao = cacaoPowderQuantityStack.peek();

            double cacaoPercentage = cacao / (milk + cacao) * 100;

            if (cacaoPercentage == 30) {
                if (!chocolateTypes.containsKey("Milk Chocolate")) {
                    chocolateTypes.put("Milk Chocolate", 1);
                } else {
                    chocolateTypes.put("Milk Chocolate", chocolateTypes.get("Milk Chocolate") + 1);
                }
                milkQuantityQueue.poll();
                cacaoPowderQuantityStack.pop();
            } else if (cacaoPercentage == 50) {
                if (!chocolateTypes.containsKey("Dark Chocolate")) {
                    chocolateTypes.put("Dark Chocolate", 1);
                } else {
                    chocolateTypes.put("Dark Chocolate", chocolateTypes.get("Dark Chocolate") + 1);
                }
                milkQuantityQueue.poll();
                cacaoPowderQuantityStack.pop();
            } else if (cacaoPercentage == 100) {
                if (!chocolateTypes.containsKey("Baking Chocolate")) {
                    chocolateTypes.put("Baking Chocolate", 1);
                } else {
                    chocolateTypes.put("Baking Chocolate", chocolateTypes.get("Baking Chocolate") + 1);
                }
                milkQuantityQueue.poll();
                cacaoPowderQuantityStack.pop();
            } else {
                cacaoPowderQuantityStack.pop();
                milk += 10;
                milkQuantityQueue.poll();
                milkQuantityQueue.offer(milk);
            }
        }

        int milkChocolateCounter = 0;
        int darkChocolateCounter = 0;
        int bakingChocolateCounter = 0;

        for (Map.Entry<String, Integer> entry : chocolateTypes.entrySet()) {
            if (entry.getKey().equals("Milk Chocolate") && entry.getValue() > 0) {
                milkChocolateCounter++;
            } else if (entry.getKey().equals("Dark Chocolate") && entry.getValue() > 0) {
                darkChocolateCounter++;
            } else if (entry.getKey().equals("Baking Chocolate") && entry.getValue() > 0) {
                bakingChocolateCounter++;
            }

        }

        int sum = milkChocolateCounter + darkChocolateCounter + bakingChocolateCounter;
        if (sum >= 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (Map.Entry<String, Integer> entry : chocolateTypes.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println("# " + entry.getKey() + " --> " + entry.getValue());
            }
        }
    }
}
