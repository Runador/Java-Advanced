import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();

        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<String, Integer> foodsMap = new LinkedHashMap<>();
        foodsMap.put("Bread", 25);
        foodsMap.put("Cake", 50);
        foodsMap.put("Pastry", 75);
        foodsMap.put("Fruit Pie", 100);

        Map<String, Integer> finalFoodsMap = new TreeMap<>();
        finalFoodsMap.put("Bread", 0);
        finalFoodsMap.put("Cake", 0);
        finalFoodsMap.put("Pastry", 0);
        finalFoodsMap.put("Fruit Pie", 0);

        boolean isFailed = false;

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();
            int sum = liquid + ingredient;

            for (var entry : foodsMap.entrySet()) {
                int result = entry.getValue();
                if (sum == result) {
                    if (result == 25) {
                        if (finalFoodsMap.containsKey("Bread")) {
                            finalFoodsMap.put("Bread", finalFoodsMap.get("Bread") + 1);
                        } else {
                            finalFoodsMap.put("Bread", 1);
                        }
                    } else if (result == 50) {
                        if (finalFoodsMap.containsKey("Cake")) {
                            finalFoodsMap.put("Cake", finalFoodsMap.get("Cake") + 1);
                        } else {
                            finalFoodsMap.put("Cake", 1);
                        }
                    } else if (result == 75) {
                        if (finalFoodsMap.containsKey("Pastry")) {
                            finalFoodsMap.put("Pastry", finalFoodsMap.get("Pastry") + 1);
                        } else {
                            finalFoodsMap.put("Pastry", 1);
                        }
                    } else if (result == 100) {
                        if (finalFoodsMap.containsKey("Fruit Pie")) {
                            finalFoodsMap.put("Fruit Pie", finalFoodsMap.get("Fruit Pie") + 1);
                        } else {
                            finalFoodsMap.put("Fruit Pie", 1);
                        }
                    }
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                }

                if (!foodsMap.containsValue(liquid + ingredient)) {
                    isFailed = true;
                    break;
                }
            }

            if (isFailed) {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);
            }
        }

        if (liquidsQueue.isEmpty() && ingredientsStack.isEmpty()) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
            System.out.println("Liquids left: none");
            System.out.print("Ingredients left: none");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            System.out.println("Liquids left: none");
            System.out.print("Ingredients left: ");
            System.out.print(String.join(", ", ingredientsStack.toString().replaceAll("[\\[\\]]", "")));
        }
        if (!liquidsQueue.isEmpty() && ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
            System.out.print("Liquids left: ");
            System.out.print(String.join(", ", liquidsQueue.toString().replaceAll("[\\[\\]]", "")));
        }
        System.out.println();
        for (var entry : finalFoodsMap.entrySet()) {
            String foodName = entry.getKey();
            int foodValue = entry.getValue();
            System.out.printf("%s: %d%n", foodName, foodValue);
        }
    }
}
