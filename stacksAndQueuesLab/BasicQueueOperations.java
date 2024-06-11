package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split("\\s+");
        int numbersToOffer = Integer.parseInt(tokens[0]);
        int numbersToPoll = Integer.parseInt(tokens[1]);
        int presentElement = Integer.parseInt(tokens[2]);

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).limit(numbersToOffer).toArray();

        for (int element : elements) {
            queue.offer(element);
        }

        for (int i = 0; i < numbersToPoll; i++) {
            queue.poll();
        }

        if (!queue.isEmpty()) {
            if (queue.contains(presentElement)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        } else {
            System.out.println(0);
        }

    }
}
