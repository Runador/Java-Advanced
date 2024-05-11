package ExercisesStacksАndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int number : integerList) {
            stack.push(number);
        }
        while (stack.size() > 0) {
            System.out.printf("%d ", stack.pop());
        }
    }
}
