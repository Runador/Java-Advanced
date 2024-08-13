import java.util.*;

public class WildSurvival2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> beeGroupsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> beeEatersGroupsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(beeGroupsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(beeEatersGroupsStack::push);

        while (!beeGroupsQueue.isEmpty() && !beeEatersGroupsStack.isEmpty()) {

            int beeGroup = beeGroupsQueue.peek();
            int beeEatersGroup = beeEatersGroupsStack.peek();

            // 1 bee eater = 7 bees
            // 32 6

            int diedBeeEaters = beeGroup / 7;
            int aliveBeeEaters = beeEatersGroup - diedBeeEaters;

            if (aliveBeeEaters > 0) {
                beeGroupsQueue.poll();
                beeEatersGroupsStack.pop();
                beeEatersGroupsStack.push(aliveBeeEaters);
            } else if (beeGroup > 0) {
                int remainingBees = beeGroup - beeEatersGroup * 7;
                beeGroupsQueue.poll();
                if (remainingBees > 0) {
                    beeGroupsQueue.offer(remainingBees);
                }
                beeEatersGroupsStack.pop();
            } else {
                beeGroupsQueue.poll();
                beeEatersGroupsStack.pop();
            }
        }

        System.out.println("The final battle is over!");

        if (beeGroupsQueue.isEmpty() && beeEatersGroupsStack.isEmpty()) {
            System.out.println("But no one made it out alive!");
        }
        if (!beeGroupsQueue.isEmpty()) {
            List<Integer> listRS = new ArrayList<>(beeGroupsQueue);
            Collections.sort(listRS);
            System.out.print("Bee groups left: ");
            System.out.println(String.join(", ", listRS.toString().replaceAll("[\\[\\]]", "")));
        }
        if (!beeEatersGroupsStack.isEmpty()) {
            List<Integer> listRS = new ArrayList<>(beeEatersGroupsStack);
            Collections.sort(listRS);
            System.out.print("Bee-eater groups left: ");
            System.out.println(String.join(", ", listRS.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
