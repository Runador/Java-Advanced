import java.util.*;

public class MaximumElement2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(input[0]);
            switch (command) {
                case 1 -> stack.push(Integer.parseInt(input[1]));
                case 2 -> stack.pop();
                case 3 -> System.out.println(Collections.max(stack));
            }
        }
    }
}
