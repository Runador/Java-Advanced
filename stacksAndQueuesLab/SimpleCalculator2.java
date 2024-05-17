package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 2 + 3 - 1

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = scanner.nextLine().split("\\s+");
        Collections.addAll(stack, tokens);

        int result;

        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());
            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else {
                result = firstNumber - secondNumber;
            }
            stack.push(String.valueOf(result));
        }

        System.out.println(stack.peek());
    }
}
