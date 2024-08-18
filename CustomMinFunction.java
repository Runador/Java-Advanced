import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        /*Function<List<Integer>, Integer> minFunction =
                numbersList -> numbersList.stream().min(Integer::compareTo).orElse(null);
        */

        Function<List<Integer>, Integer> minFunction = Collections::min;
        System.out.println(minFunction.apply(numbers));
    }
}
