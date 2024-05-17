package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String expression = scanner.nextLine();

        //  1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

        //  (2 + 3)
        //  (3 + 1)
        //  (2 - (2 + 3) * 4 / (3 + 1))

        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < expression.length(); i++) {

            char symbol = expression.charAt(i);

            if (symbol == '(') {
                firstIndex = Integer.parseInt(String.valueOf(i));
            } else if (symbol == ')') {
                secondIndex = Integer.parseInt(String.valueOf(i));
                String substring = expression.substring(firstIndex, secondIndex + 1);
                stack.push(substring);
                firstIndex = 0;
                secondIndex = 0;
            }

        }

    }

}
