package examPreparation14June2024;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class WormsAndHoles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> wormsStack = new ArrayDeque<>();
        ArrayDeque<Integer> holesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(wormsStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(holesQueue::offer);

        int counter = 0;

        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()) {
            counter++;
            int worm = wormsStack.pop();
            int hole = holesQueue.poll();

            if (worm != hole) {
                holesQueue.poll();
                worm -= 3;
                if (worm <= 0) {
                    wormsStack.pop();
                }
            }

        }

        if (counter > 0) {
            System.out.println("Matches: " + counter);
        } else {
            System.out.println("There are no matches.");
        }

    }
}
