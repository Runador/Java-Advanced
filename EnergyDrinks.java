import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentCoffeineTaken = 0;
        int totalCaffeinePerNight = 0;

        ArrayDeque<Integer> milligramsOfCaffeineStack = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinksQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .forEach(milligramsOfCaffeineStack::push);

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .forEach(energyDrinksQueue::offer);

        while (!milligramsOfCaffeineStack.isEmpty() && !energyDrinksQueue.isEmpty()) {

            int milligramsOfCaffeine = milligramsOfCaffeineStack.peek();
            int energyDrink = energyDrinksQueue.peek();
            int finalCaffeineInTheDrink = milligramsOfCaffeine * energyDrink;

            currentCoffeineTaken += finalCaffeineInTheDrink;

            if (currentCoffeineTaken < 300) {
                totalCaffeinePerNight += currentCoffeineTaken;
                milligramsOfCaffeineStack.pop();
                energyDrinksQueue.poll();
            } else {
                milligramsOfCaffeineStack.pop();
                energyDrinksQueue.poll();
                energyDrinksQueue.offer(energyDrink);
                if (totalCaffeinePerNight > 0) {
                    totalCaffeinePerNight -= 30;
                }
            }
        }

        if (!energyDrinksQueue.isEmpty()) {
            System.out.print("Drinks left: ");
            System.out.print(String.join(", ", energyDrinksQueue.toString().replaceAll("[\\[\\]]", "")));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("\nStamat is going to sleep with %d mg caffeine.", totalCaffeinePerNight);
    }
}
