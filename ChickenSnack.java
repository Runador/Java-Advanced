import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ChickenSnack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> amountOfMoneyStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .forEach(amountOfMoneyStack::push);

        ArrayDeque<Integer> pricesOfFoodsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .forEach(pricesOfFoodsQueue::offer);

        int foodCounter = 0;

        while (!amountOfMoneyStack.isEmpty() && !pricesOfFoodsQueue.isEmpty()) {

            if (Objects.equals(amountOfMoneyStack.peek(), pricesOfFoodsQueue.peek())) {
                foodCounter++;
                amountOfMoneyStack.pop();
                pricesOfFoodsQueue.poll();
            } else if (amountOfMoneyStack.peek() > pricesOfFoodsQueue.peek()) {
                foodCounter++;
                int change = Math.abs(amountOfMoneyStack.peek() - pricesOfFoodsQueue.peek());
                amountOfMoneyStack.pop();
                if (!amountOfMoneyStack.isEmpty()) {
                    amountOfMoneyStack.push(amountOfMoneyStack.pop() + change);
                }
                pricesOfFoodsQueue.poll();
            } else {
                amountOfMoneyStack.pop();
                pricesOfFoodsQueue.poll();
            }

        }

        if (foodCounter >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.", foodCounter);
        } else if (foodCounter > 0) {
            if (foodCounter == 1) {
                System.out.printf("Henry ate: %d food.", foodCounter);
            } else {
                System.out.printf("Henry ate: %d foods.", foodCounter);
            }
        } else {
            System.out.print("Henry remained hungry. He will try next weekend again.");
        }

    }
}
