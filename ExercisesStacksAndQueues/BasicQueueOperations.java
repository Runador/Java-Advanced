package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] commandsForQueue = scanner.nextLine().split("\\s+");

        int N = Integer.parseInt(commandsForQueue[0]);
        int S = Integer.parseInt(commandsForQueue[1]);
        int X = Integer.parseInt(commandsForQueue[2]);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(N).mapToInt(Integer::parseInt).forEach(queue::offer);

        /*for (int i = 0; i < N; i++) {
            int element = numbers[i];
            queue.offer(element);
        }*/

        for (int i = 0; i < S; i++) {
            queue.poll();
        }

        if (!queue.isEmpty()) {
            if (queue.contains(X)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        } else {
            System.out.println(0);
        }

    }
}
