import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> evens = numbers.stream().sorted().filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> odds = numbers.stream().sorted().filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        int size = evens.size() + odds.size();

        List<Integer> resultingList = new ArrayList<>(size);

        resultingList.addAll(evens);
        resultingList.addAll(odds);

        resultingList.forEach(e -> System.out.print(e + " "));
    }
}
