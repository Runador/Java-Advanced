import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .collect(Collectors.toList());

        Consumer<String> consumer = c -> System.out.printf("Sir %s%n", c);

        for (String name : numbersList) {
            consumer.accept(name);
        }

    }
}
