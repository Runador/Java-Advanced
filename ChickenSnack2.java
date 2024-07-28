import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ChickenSnack2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer>  amountOfMoneyStack = new ArrayDeque<>();
        ArrayDeque<Integer>  pricesOfFoodsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)	// запихиваем в стек елементъ строки
                .forEach(amountOfMoneyStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)	// запихиваем в стек елементъ строки
                .forEach(pricesOfFoodsQueue::offer);

        int eatenFoods = 0;

        while (!amountOfMoneyStack.isEmpty() && !pricesOfFoodsQueue.isEmpty()) {

            int amountOfMoney = amountOfMoneyStack.peek();
            int priceOfFood = pricesOfFoodsQueue.peek();

            if (amountOfMoney == priceOfFood) {
                eatenFoods++;
                amountOfMoneyStack.pop();
                pricesOfFoodsQueue.poll();
            } else if (amountOfMoney > priceOfFood) {
                eatenFoods++;
                int change = amountOfMoney - priceOfFood;
                amountOfMoneyStack.pop();
                int lastElementValue = amountOfMoneyStack.pop();
                amountOfMoneyStack.push(lastElementValue + change);
                pricesOfFoodsQueue.poll();
            } else {
                amountOfMoneyStack.pop();
                pricesOfFoodsQueue.poll();
            }

        }

        if (eatenFoods >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.", eatenFoods);
        } else if (eatenFoods == 1) {
            System.out.printf("Henry ate: %d food.", eatenFoods);
        } else if (eatenFoods > 1) {
            System.out.printf("Henry ate: %d foods.", eatenFoods);
        } else {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
    }
}
