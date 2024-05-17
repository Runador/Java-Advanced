package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parenthesis = scanner.nextLine();
        ArrayDeque<String> openedParenthesis = new ArrayDeque<>();
        ArrayDeque<String> closingParenthesis = new ArrayDeque<>();
        //  {[()]}
        for (int i = 0; i < parenthesis.length(); i++) {
            char symbol = parenthesis.charAt(i);
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                openedParenthesis.push(String.valueOf(symbol));
            } else if (symbol == ')' || symbol == ']' || symbol == '}') {
                closingParenthesis.offer(String.valueOf(symbol));
            }
        }

        int openedParenthesisSize = openedParenthesis.size();
        int closingParenthesisSize = closingParenthesis.size();
        int counter = 0;

        if (openedParenthesis.isEmpty() || closingParenthesis.isEmpty()) {
            System.out.println("NO");
            return;
        }

        while (!openedParenthesis.isEmpty() && !closingParenthesis.isEmpty()) {
            String first = openedParenthesis.pop();
            String second = closingParenthesis.poll();

            if ((first.equals("(") && second.equals(")")) || (first.equals("[") && second.equals("]"))
                    || (first.equals("{") && second.equals("}"))) {
                counter++;
            }
        }

        if (openedParenthesisSize - counter == 0 || closingParenthesisSize - counter == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}

