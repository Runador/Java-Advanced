import java.util.*;
import java.util.stream.Collectors;

public class OffroadChallenge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> initialFuelStack = new ArrayDeque<>();
        ArrayDeque<Integer> additionalConsumptionIndex = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(initialFuelStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(additionalConsumptionIndex::offer);

        List<Integer> necessaryAmountOfFuelNeeded = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<String> altitudesList = new ArrayList<>();

        int counter = 0;
        boolean isFailed = false;
        int allAltitudesCounter = initialFuelStack.size();

        while (!initialFuelStack.isEmpty() && !additionalConsumptionIndex.isEmpty()) {

            int fuelQuantity = initialFuelStack.peek();
            int additionalConsumption = additionalConsumptionIndex.peek();
            int result = Math.abs(fuelQuantity - additionalConsumption);

            for (int i = 0; i < necessaryAmountOfFuelNeeded.size(); i++) {
                int necessaryAmountOfFuel = necessaryAmountOfFuelNeeded.get(i);
                counter++;
                if (result >= necessaryAmountOfFuel) {
                    System.out.printf("John has reached: Altitude %d%n", counter);
                    String altitude = "Altitude " + counter;
                    altitudesList.add(altitude);
                    if (!initialFuelStack.isEmpty()) {
                        initialFuelStack.pop();
                    }
                    if (!additionalConsumptionIndex.isEmpty()){
                        additionalConsumptionIndex.poll();
                    }
                    necessaryAmountOfFuelNeeded.remove(i);
                } else {
                    System.out.printf("John did not reach: Altitude %d%n", counter);
                    System.out.println("John failed to reach the top.");
                    isFailed = true;
                }
                break;
            }
            if (isFailed) {
                break;
            }
        }

        if (allAltitudesCounter == altitudesList.size()) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else if (altitudesList.size() >= 1){
            System.out.print("Reached altitudes: ");
            for (int i = 0; i < altitudesList.size(); i++) {
                if (i == altitudesList.size() - 1) {
                    System.out.print(altitudesList.get(i));
                } else {
                    System.out.print(altitudesList.get(i) + ", ");
                }
            }
        } else {
            System.out.println("John didn't reach any altitude.");
        }
    }
}
