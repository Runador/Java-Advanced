import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write a program that reverses a collection and removes elements that
        // are divisible by a given integer n.
        // 1 2 3 4 5 6
        // 2
        // 5 3 1

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Function<List<Integer>, List<Integer>> function =
                numbersList -> numbersList.reversed().stream()
                        .filter(e -> e % n != 0).collect(Collectors.toList());

        numbers = function.apply(numbers);
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
