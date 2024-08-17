import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> add = listOfNumbers -> listOfNumbers.stream().map(e -> e + 1)
                .collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = listOfNumbers -> listOfNumbers.stream().map(e -> e - 1)
                .collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = listOfNumbers -> listOfNumbers.stream().map(e -> e * 2)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add" -> numbers = add.apply(numbers);
                case "subtract" -> numbers = subtract.apply(numbers);
                case "multiply" -> numbers = multiply.apply(numbers);
                case "print" -> numbers.forEach(e -> System.out.print(e + " "));
            }

            command = scanner.nextLine();
        }
    }
}
