import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootBoxQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondLootBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(firstLootBoxQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(secondLootBoxStack::push);

        int claimedItems = 0;

        while (!firstLootBoxQueue.isEmpty() && !secondLootBoxStack.isEmpty()) {

            int firstLootBox = firstLootBoxQueue.peek();
            int secondLootBox= secondLootBoxStack.peek();
            int sum = firstLootBox + secondLootBox;

            if (sum % 2 == 0) {
                claimedItems += sum;
                firstLootBoxQueue.poll();
                secondLootBoxStack.pop();
            } else {
                secondLootBoxStack.pop();
                firstLootBoxQueue.addLast(secondLootBox);
            }
        }

        if (firstLootBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secondLootBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }
        if (claimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d", claimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", claimedItems);
        }
    }
}
