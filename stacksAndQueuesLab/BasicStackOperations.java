package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split("\\s+");
        int numbersToPush = Integer.parseInt(tokens[0]);
        int numbersToPop = Integer.parseInt(tokens[1]);
        int presentElement = Integer.parseInt(tokens[2]);

        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).limit(numbersToPush).toArray();

        for (int element : elements) {
            stack.push(element);
        }

        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        if (!stack.isEmpty()) {
            if (stack.contains(presentElement)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }
        } else {
            System.out.println(0);
        }
    }
}
