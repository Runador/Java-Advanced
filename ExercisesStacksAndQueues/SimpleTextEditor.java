package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        StringBuilder text = new StringBuilder();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1" -> {
                    String textToAdd = tokens[1];
                    text.append(textToAdd);
                    stack.push(text.toString());
                }
                case "2" -> {
                    int countEraseSymbols = Integer.parseInt(tokens[1]);
                    text.delete(text.length() - countEraseSymbols, text.length());
                    stack.push(text.toString());
                }
                case "3" -> {
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index <= text.length() - 1) {
                        char element = text.charAt(index - 1);
                        System.out.println(element);
                    }
                }
                case "4" -> {
                    stack.pop();
                    assert stack.peek() != null;
                    text = new StringBuilder(stack.peek());
                }
            }
        }

    }
}
