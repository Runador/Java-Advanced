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

        int numberOfRegisteredCars = 0;
        int daysCounter = 0;
        int remainingLicensePlates = 0;


        while (!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {

            daysCounter++;
            int licensePlates = licensePlatesQueue.poll();
            int cars = carsStack.pop();

            if (licensePlates - cars <= 0) {
                int requiredAmount = licensePlates / 2;
                cars -= requiredAmount;
                numberOfRegisteredCars += requiredAmount;
                carsStack.addLast(cars);
            } else {
                numberOfRegisteredCars += cars;
                int remindedPlates = Math.abs(licensePlates - (cars * 2));
                remainingLicensePlates += remindedPlates;
                if (remainingLicensePlates != 0) {
                    licensePlatesQueue.addLast(remindedPlates);
                }
            }
        }

        System.out.printf("%d cars were registered for %d days!%n",
                numberOfRegisteredCars, daysCounter);

        if (licensePlatesQueue.isEmpty() && carsStack.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (!licensePlatesQueue.isEmpty()) {
            System.out.printf("%d license plates remain!", remainingLicensePlates);
        } else {
            int carsWithoutLicensePlates = 0;
            while (!carsStack.isEmpty()) {
                carsWithoutLicensePlates += carsStack.pop();
            }
            System.out.printf("%d cars remain without license plates!", carsWithoutLicensePlates);
        }

    }
}
