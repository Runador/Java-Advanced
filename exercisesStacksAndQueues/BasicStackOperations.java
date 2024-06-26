package exercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] stackOperations = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int N = stackOperations[0];
        int S = stackOperations[1];
        int X = stackOperations[2];

        Arrays.stream(scanner.nextLine().split("\\s+")).limit(N)
                .mapToInt(Integer::parseInt).forEach(stack::push);

        for (int i = 0; i < S; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(X)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }
        }

    }
}
