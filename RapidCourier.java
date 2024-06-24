import java.util.ArrayDeque;
import java.util.Scanner;

public class RapidCourier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] packageWeightsInput = scanner.nextLine().split(" ");
        ArrayDeque<Integer> packages = new ArrayDeque<>();
        for (String weight : packageWeightsInput) {
            packages.offer(Integer.parseInt(weight));
        }

        String[] courierCapacities = scanner.nextLine().split(" ");
        ArrayDeque<Integer> couriers = new ArrayDeque<>();
        for (String capacity : courierCapacities) {
            couriers.offer(Integer.parseInt(capacity));
        }

        int totalDeliveredWeight = 0;

        while (!packages.isEmpty() && !couriers.isEmpty()) {
            int packageWeight = packages.peek();
            int courierCapacity = couriers.poll();

            if (courierCapacity >= packageWeight) {
                totalDeliveredWeight += packageWeight;
                packages.poll();

                if (courierCapacity > packageWeight) {
                    courierCapacity -= 2 * packageWeight;
                    if (courierCapacity > 0) {
                        couriers.offer(courierCapacity);
                    }
                }
            } else {
                totalDeliveredWeight += courierCapacity;
                packageWeight -= courierCapacity;
                packages.poll();
                packages.offer(packageWeight);
            }
        }

        System.out.println("Total weight: " + totalDeliveredWeight + " kg");

        if (packages.isEmpty() && couriers.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        } else if (!packages.isEmpty() && couriers.isEmpty()) {
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            while (!packages.isEmpty()) {
                System.out.print(packages.poll() + (packages.isEmpty() ? "" : ", "));
            }
            System.out.println();
        } else if (packages.isEmpty() && !couriers.isEmpty()) {
            System.out.print("Couriers are still on duty: ");
            while (!couriers.isEmpty()) {
                System.out.print(couriers.poll() + (couriers.isEmpty() ? "" : ", "));
            }
            System.out.println(" but there are no more packages to deliver.");

        }

    }
}
