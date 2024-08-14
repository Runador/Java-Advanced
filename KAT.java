import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlatesQueue  = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .forEach(licensePlatesQueue::offer);

        ArrayDeque<Integer> carsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .forEach(carsStack::push);

        int daysCount = 0;
        int sum = 0;

        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {

            int licensePlates = licensePlatesQueue.peek();
            int cars = carsStack.peek();
            int remainingLicensePlates = licensePlates % cars / 2;
            int numberOfRegisteredCars = Math.abs(licensePlates - (cars * 2));
            daysCount++;

            if (remainingLicensePlates == 0) {
                licensePlatesQueue.poll();
                carsStack.pop();
            } else if (remainingLicensePlates > 0) {
                licensePlatesQueue.poll();
                cars -= numberOfRegisteredCars;
                carsStack.pop();
                carsStack.push(cars);
            } else {
                licensePlatesQueue.poll();
                licensePlatesQueue.offer(remainingLicensePlates);
            }

            sum += remainingLicensePlates;
        }

        System.out.printf("%d cars were registered for %d days!%n", sum, daysCount);
        if (licensePlatesQueue.isEmpty() && carsStack.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
