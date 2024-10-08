import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .collect(Collectors.toList());

        names = names.stream().
                filter(name -> name.length() <= n).collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}
