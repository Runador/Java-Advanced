import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(ingredientsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(freshnessLevelStack::push);

        Map<String, Integer> cocktailsMap = new TreeMap<>();
        cocktailsMap.put("Pear Sour", 0);
        cocktailsMap.put("The Harvest", 0);
        cocktailsMap.put("Apple Hinny", 0);
        cocktailsMap.put("High Fashion", 0);

        int pearSourCounter = 0;
        int theHarvestCounter = 0;
        int appleHinnyCounter = 0;
        int highFashionCounter = 0;

        while (!ingredientsQueue.isEmpty() && !freshnessLevelStack.isEmpty()) {

            int ingredient = ingredientsQueue.peek();
            int freshnessLevel = freshnessLevelStack.peek();
            int totalFreshnessLevel = ingredient * freshnessLevel;

            if (totalFreshnessLevel == 150) {
                if (!cocktailsMap.containsKey("Pear Sour")) {
                    cocktailsMap.put("Pear Sour", 1);
                } else {
                    cocktailsMap.put("Pear Sour", cocktailsMap.get("Pear Sour") + 1);
                }
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
                pearSourCounter++;
            } else if (totalFreshnessLevel == 250) {
                if (!cocktailsMap.containsKey("The Harvest")) {
                    cocktailsMap.put("The Harvest", 1);
                } else {
                    cocktailsMap.put("The Harvest", cocktailsMap.get("The Harvest") + 1);
                }
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
                theHarvestCounter++;
            } else if (totalFreshnessLevel == 300) {
                if (!cocktailsMap.containsKey("Apple Hinny")) {
                    cocktailsMap.put("Apple Hinny", 1);
                } else {
                    cocktailsMap.put("Apple Hinny", cocktailsMap.get("Apple Hinny") + 1);
                }
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
                appleHinnyCounter++;
            } else if (totalFreshnessLevel == 400) {
                if (!cocktailsMap.containsKey("High Fashion")) {
                    cocktailsMap.put("High Fashion", 1);
                } else {
                    cocktailsMap.put("High Fashion", cocktailsMap.get("High Fashion") + 1);
                }
                ingredientsQueue.poll();
                freshnessLevelStack.pop();
                highFashionCounter++;
            } else {
                freshnessLevelStack.pop();
                ingredient += 5;
                ingredientsQueue.poll();
                if (ingredient > 0) {
                    ingredientsQueue.addLast(ingredient);
                }
            }
        }

        boolean areHaveFromAllCocktailsOne = pearSourCounter != 0 && theHarvestCounter != 0 && appleHinnyCounter != 0 && highFashionCounter != 0;

        if (areHaveFromAllCocktailsOne) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int remainingIngredientsSum = ingredientsQueue.stream().mapToInt(Integer::intValue).sum();
        
        System.out.printf("Ingredients left: %d%n", remainingIngredientsSum);

        if (!cocktailsMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : cocktailsMap.entrySet()) {
                if (entry.getValue() > 0) {
                    System.out.printf(" # %s --> %d%n", entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
