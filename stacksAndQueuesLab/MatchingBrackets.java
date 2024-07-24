package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> indexesStack = new ArrayDeque<>();

        String expression = scanner.nextLine();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == '(') {
                indexesStack.push(i);
            }
            if (symbol == ')') {
                String subExpression = expression.substring(indexesStack.pop(), i + 1);
                System.out.println(subExpression);
            }

        }
    }
}
