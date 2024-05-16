package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numberOfCommands = (Integer.parseInt(scanner.nextLine()));

        for (int i = 0; i < numberOfCommands; i++) {

            int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            // с mapToInt направо парсваме към int без после да се налага да правя различни променливи
            switch (tokens[0]) {
                case 1 -> {
                    int element = tokens[1];
                    stack.push(element);
                }
                case 2 -> stack.pop();
                case 3 -> System.out.println(Collections.max(stack));
            }

        }

    }
}
