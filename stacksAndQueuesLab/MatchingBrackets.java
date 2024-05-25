package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> indexesStack = new ArrayDeque<>();

        String expression = scanner.nextLine();

        //  1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

        for (int i = 0; i < expression.length(); i++) {

            char symbol = expression.charAt(i);

            if (symbol == '(') {
                int firstIndex = Integer.parseInt(String.valueOf(i));
                indexesStack.push(firstIndex);
            } else if (symbol == ')') {
                int firstIndex = indexesStack.pop();
                int secondIndex = i + 1;
                String substring = expression.substring(firstIndex, secondIndex);
                System.out.println(substring);
            }

        }

    }

}
