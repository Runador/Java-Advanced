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

        Map<String, Integer> foodsMap = new TreeMap<>();
        foodsMap.put("Bread", 0);
        foodsMap.put("Cake", 0);
        foodsMap.put("Pastry", 0);
        foodsMap.put("Fruit Pie", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int liquid = liquidsQueue.peek();
            int ingredient = ingredientsStack.peek();
            int sum = liquid + ingredient;

            switch (sum) {
                case 25 -> {
                    foodsMap.put("Bread", foodsMap.get("Bread") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                }
                case 50 -> {
                    foodsMap.put("Cake", foodsMap.get("Cake") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                }
                case 75 -> {
                    foodsMap.put("Pastry", foodsMap.get("Pastry") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                }
                case 100 -> {
                    foodsMap.put("Fruit Pie", foodsMap.get("Fruit Pie") + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                }
                default -> {
                    liquidsQueue.poll();
                    ingredientsStack.push(ingredientsStack.pop() + 3);
                }
            }
        }

        int counter = 0;

        for (var entry : foodsMap.entrySet()) {
            int foodValue = entry.getValue();
            if (foodValue > 0) {
                counter++;
            }
        }
        if (counter >= 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            System.out.println("Liquids left: none");
            System.out.print("Ingredients left: ");
            System.out.print(String.join(", ", ingredientsStack.toString().replaceAll("[\\[\\]]", "")));
        } else if (!liquidsQueue.isEmpty() && ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
            System.out.print("Liquids left: ");
            System.out.print(String.join(", ", liquidsQueue.toString().replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("Liquids left: none");
            System.out.print("Ingredients left: none");
        }
        System.out.println();
        for (var entry : foodsMap.entrySet()) {
            String foodName = entry.getKey();
            int foodValue = entry.getValue();
            System.out.printf("%s: %d%n", foodName, foodValue);
        }
    }
}
