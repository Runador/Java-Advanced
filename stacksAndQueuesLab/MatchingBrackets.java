package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();

        //  1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

        for (int i = 0; i < expression.length(); i++) {

            char symbol = expression.charAt(i);

            if (symbol == '(') {
                int firstIndex = Integer.parseInt(String.valueOf(i));
                stack.push(firstIndex);
            } else if (symbol == ')') {
                int firstIndex = stack.pop();
                int secondIndex = i;
                String substring = expression.substring(firstIndex, secondIndex + 1);
                System.out.println(substring);
            }

        }

    }

}
