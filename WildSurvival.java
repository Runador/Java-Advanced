import java.util.*;

public class WildSurvival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> beeGroupsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> beeEatersGroupsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(beeGroupsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(beeEatersGroupsQueue::offer);

        while (!beeGroupsQueue.isEmpty() && !beeEatersGroupsQueue.isEmpty()) {

            int beeGroup = beeGroupsQueue.pollFirst();
            int beeEatersGroup = beeEatersGroupsQueue.pollLast();

            while (beeGroup > 0 && beeEatersGroup > 0) {
                if (beeEatersGroup * 7 >= beeGroup) {
                    beeEatersGroup = (beeGroup + 6) / 7;
                    beeGroup = 0;
                } else {
                    beeGroup -= beeEatersGroup * 7;
                    beeEatersGroup = 0;
                }
            }

            if (beeGroup > 0) {
                beeGroupsQueue.offer(beeGroup);
            } else if (beeEatersGroup > 0) {
                beeEatersGroupsQueue.offer(beeEatersGroup);
            }
        }

        System.out.println("The final battle is over!");

        if (beeGroupsQueue.isEmpty() && beeEatersGroupsQueue.isEmpty()) {
            System.out.println("But no one made it out alive!");
        } else if (!beeGroupsQueue.isEmpty()) {
            System.out.print("Bee groups left: ");
            List<Integer> listRS = new ArrayList<>(beeGroupsQueue);
            Collections.sort(listRS);
            Set<Integer> hashSet = new LinkedHashSet(listRS);
            ArrayList<Integer> removedDuplicates = new ArrayList(hashSet);
            System.out.println(String.join(", ", removedDuplicates.toString().replaceAll("[\\[\\]]", "")));
        } else if (!beeEatersGroupsQueue.isEmpty()) {
            System.out.print("Bee-eater groups left: ");
            List<Integer> listRS = new ArrayList<>(beeEatersGroupsQueue);
            Collections.sort(listRS);
            Set<Integer> hashSet = new LinkedHashSet(listRS);
            ArrayList<Integer> removedDuplicates = new ArrayList(hashSet);
            System.out.println(String.join(", ", removedDuplicates.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
