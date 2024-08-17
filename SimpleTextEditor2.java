import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.function.BiFunction;

public class SimpleTextEditor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        BiFunction<Integer, Integer, Integer> function = (x, y) -> x + y;
        System.out.println(function.apply(2, 4));

        int n = Integer.parseInt(scanner.nextLine());


        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(tokens[0]);
            String input = tokens[1];

            switch (command) {
                case 1 -> {
                    stack.push(input);
                }
                case 2 -> {
                    stack.push(input);
                    int count = Integer.parseInt(tokens[1]);
                    input = input.substring(0, input.length() - count);
                    stack.push(input);
                }
                case 3 -> {
                    if (!stack.isEmpty()) {
                        input = stack.peek();
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
