package examPreparation13December2023;

import java.util.*;
import java.util.stream.Collectors;

public class WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> wormsStack = new ArrayDeque<>();
        ArrayDeque<Integer> holesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(wormsStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(holesQueue::offer);

        int counter = 0;
        int initialWormCount = wormsStack.size();

        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()) {

            int worm = wormsStack.peek();
            int hole = holesQueue.peek();

            if (worm != hole) {
                holesQueue.poll();
                wormsStack.pop();
                worm -= 3;
                wormsStack.push(worm);
                if (worm <= 0) {
                    wormsStack.pop();
                }
            } else {
                wormsStack.pop();
                holesQueue.poll();
                counter++;
            }

        }

        if (counter > 0) {
            System.out.println("Matches: " + counter);
        } else {
            System.out.println("There are no matches.");
        }

        if (wormsStack.isEmpty() && initialWormCount == counter) {
            System.out.println("Every worm found a suitable hole!");
        } else if (wormsStack.isEmpty() && initialWormCount > counter) {
            System.out.println("Worms left: none");
        } else {
            List<Integer> wormsList = new ArrayList<>(wormsStack).reversed();
            String output = wormsList.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Worms left: " + output);
        }

        if (holesQueue.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            List<Integer> holesList = new ArrayList<>(holesQueue);
            String output = holesList.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Holes left: " + output);
        }
    }
}
