package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "1" -> {
                    int element = Integer.parseInt(tokens[1]);
                    stack.push(element);
                }
                case "2" -> stack.pop();
                case "3" -> System.out.println(Collections.max(stack));
            }

        }

    }
}

