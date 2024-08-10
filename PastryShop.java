import java.util.*;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsStaminaQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(liquidsStaminaQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<String, Integer> foodsMap = new LinkedHashMap<>();
        foodsMap.put("Biscuit", 0);
        foodsMap.put("Cake", 0);
        foodsMap.put("Pie", 0);
        foodsMap.put("Pastry", 0);

        while (!liquidsStaminaQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int liquid = liquidsStaminaQueue.peek();
            int ingredient = ingredientsStack.peek();
            int sum = liquid + ingredient;

            if (sum == 25) {
                if (!foodsMap.containsKey("Biscuit")) {
                    foodsMap.put("Biscuit", 1);
                } else {
                    foodsMap.put("Biscuit", foodsMap.get("Biscuit") + 1);
                }
                liquidsStaminaQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 50) {
                if (!foodsMap.containsKey("Cake")) {
                    foodsMap.put("Cake", 1);
                } else {
                    foodsMap.put("Cake", foodsMap.get("Cake") + 1);
                }
                liquidsStaminaQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 75) {
                if (!foodsMap.containsKey("Pastry")) {
                    foodsMap.put("Pastry", 1);
                } else {
                    foodsMap.put("Pastry", foodsMap.get("Pastry") + 1);
                }
                liquidsStaminaQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 100) {
                if (!foodsMap.containsKey("Pie")) {
                    foodsMap.put("Pie", 1);
                } else {
                    foodsMap.put("Pie", foodsMap.get("Pie") + 1);
                }
                liquidsStaminaQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsStaminaQueue.poll();
                ingredient += 3;
                ingredientsStack.pop();
                ingredientsStack.push(ingredient);
            }
        }

        int counter = 0;

        for (Map.Entry<String, Integer> entry : foodsMap.entrySet()) {
            if (entry.getValue() > 0) {
                counter++;
            }
        }
        if (counter >= 4) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsStaminaQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(String.join(", ", liquidsStaminaQueue.toString().replaceAll("[\\[\\]]", "")));
        }
        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(String.join(", ", ingredientsStack.toString().replaceAll("[\\[\\]]", "")));
        }

        for (var entry : foodsMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
