package exercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  5 / ( 3 + 2 )
        //  5 3 2 + /

        ArrayDeque<Character> stackNumbers = new ArrayDeque<>();
        ArrayDeque<Character> stackOperators = new ArrayDeque<>();

        char[] input = scanner.nextLine().replaceAll("\\s+", "")
                .toCharArray();

        for (int i = 0; i < input.length; i++) {
            char symbol = input[i];
            if (Character.isDigit(symbol)) {
                stackNumbers.push(symbol);
            }
            if (symbol == '(') {
                char number = (char) (i + 1);
                stackNumbers.push(number);
            } else if (symbol == ')') {
                char number = (char) (i - 1);
                stackNumbers.push(number);
            }

        }

        stackNumbers.forEach(System.out::println);
    }
}
