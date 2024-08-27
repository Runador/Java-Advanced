import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(getMinIndex(numbers));

    }

    public static int getMinIndex(List<Integer> numbers) {
        int index = 0;
        int counter = 1;
        int rightMost = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (number < min) {
                min = number;
                index = i;
            } else if (number == min) {
                counter++;
                rightMost = i;
            }
        }
        if (counter > 1) {
            return rightMost;
        } else {
            return index;
        }
    }

}
