package exercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesis {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stack = new ArrayDeque<>();

        String parentheses = scanner.nextLine();

        for (char parenthesis : parentheses.toCharArray()) {
            if (parenthesis == '{' || parenthesis == '(' || parenthesis == '[') {
                stack.push(parenthesis);
            } else {
                    if (stack.isEmpty() || !areBalanced(stack.pop(), parenthesis)) {
                        System.out.println("NO");
                        return;
                    }
                }
            }

        System.out.println("YES");
    }

    private static boolean areBalanced(char openParenthesis, char closeParenthesis) {
        if (openParenthesis == '(') {
            return closeParenthesis == ')';
        } else if (openParenthesis == '[') {
            return closeParenthesis == ']';
        } else {
            return closeParenthesis == '}';
        }
    }
}
