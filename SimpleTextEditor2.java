import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(tokens[0]);
            String lastString;

            switch (command) {
                case 1 -> {
                    lastString. = tokens[1];
                    stack.push(lastString);
                }
                case 2 -> {
                    lastString = stack.peek();
                    String input = stack.pop();
                    stack.push(lastString);
                    int count = Integer.parseInt(tokens[1]);
                    input = input.substring(0, input.length() - count);
                    stack.push(input);
                }
                case 3 -> {
                    if (!stack.isEmpty()) {
                        String input = stack.peek();
                        System.out.println(input.charAt(Integer.parseInt(tokens[1]) - 1));
                    }
                }
                case 4 -> {
                    stack.pop();
                }
            }

        }
    }
}
