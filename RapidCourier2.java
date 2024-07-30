import java.util.*;
import java.util.stream.Collectors;

public class RapidCourier2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> packagesStack = new ArrayDeque<>();
        ArrayDeque<Integer> couriersQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(packagesStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(couriersQueue::offer);

        int totalDeliveredWeight = 0;

        while (!packagesStack.isEmpty() && !couriersQueue.isEmpty()) {

            int packageWeight = packagesStack.peek();
            int loadingCapacity = couriersQueue.peek();

            if (loadingCapacity >= packageWeight) {
                packagesStack.pop();
                loadingCapacity -= (packageWeight * 2);
                if (loadingCapacity > 0) {
                    packagesStack.push(loadingCapacity);
                } else {
                    couriersQueue.poll();
                }
                totalDeliveredWeight += packageWeight;
            } else {
                packagesStack.pop();
                packageWeight -= loadingCapacity;
                packagesStack.push(packageWeight);
                couriersQueue.poll();
                totalDeliveredWeight += loadingCapacity;
            }
        }

        System.out.printf("Total weight: %d kg%n", totalDeliveredWeight);
        if (packagesStack.isEmpty() && couriersQueue.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        }
        if (!packagesStack.isEmpty() && couriersQueue.isEmpty()) {
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            List<Integer> packagesList = packagesStack.stream().sorted(Integer::compareTo).collect(Collectors.toList());
            System.out.println(String.join(", ", packagesList.toString().replaceAll("[\\[\\]]", "")));
        }
        if (packagesStack.isEmpty() && !couriersQueue.isEmpty()) {
            List<Integer> couriersList = couriersQueue.stream().sorted(Integer::compareTo).collect(Collectors.toList());
            System.out.print("Couriers are still on duty: ");
            System.out.print(String.join(", ", couriersList.toString().replaceAll("[\\[\\]]", "")));
            System.out.print(" but there are no more packages to deliver.");
        }
    }
}
