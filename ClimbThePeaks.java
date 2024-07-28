import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> foodPortionsStack = new ArrayDeque<>();
        ArrayDeque<Integer> dailyStaminaQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .forEach(foodPortionsStack::push);

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .forEach(dailyStaminaQueue::offer);

        List<String> conqueredPeaks = new ArrayList<>();

        Map<String, Integer> mountainsPeaks = new LinkedHashMap<>();
        mountainsPeaks.put("Vihren", 80);
        mountainsPeaks.put("Kutelo", 90);
        mountainsPeaks.put("Banski Suhodol", 100);
        mountainsPeaks.put("Polezhan", 60);
        mountainsPeaks.put("Kamenitza", 70);

        boolean areAllPeaksConquered = false;

        while (!foodPortionsStack.isEmpty() && !dailyStaminaQueue.isEmpty()) {

            int dailyPortion = foodPortionsStack.peek();
            int dailyStamina = dailyStaminaQueue.peek();

            for (Map.Entry<String, Integer> entry : mountainsPeaks.entrySet()) {
                String peak = entry.getKey();
                if (dailyPortion + dailyStamina >= entry.getValue()) {
                    conqueredPeaks.add(peak);
                    mountainsPeaks.remove(peak);
                }
                foodPortionsStack.pop();
                dailyStaminaQueue.poll();
                break;
            }

            if (conqueredPeaks.size() == 5) {
                areAllPeaksConquered = true;
                break;
            }
        }

        if (areAllPeaksConquered) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");
            conqueredPeaks.forEach(System.out::println);
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
    }
}
