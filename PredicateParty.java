import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] data = input.split("\\s");
            if (input.equals("Double")) {
                String command = data[1];
                String subString = data[2];
                Function<List<String>, List<String>> functionDouble = stringList -> stringList.stream()
                        .filter(s -> s.length() == Integer.parseInt(subString))
                        .collect(Collectors.toList());
                switch (command) {
                    case "StartsWith" -> names.stream().filter(e -> e.startsWith(subString))
                    case "EndsWith" -> names.removeIf(e -> e.endsWith(subString));
                    case "Length" -> names.removeIf(e -> e.length() == Integer.parseInt(subString));
                }
            } else if (input.equals("Remove")) {
                String command = data[1];
                String subString = data[2];
                switch (command) {
                    case "StartsWith" -> names.removeIf(e -> e.startsWith(subString));
                    case "EndsWith" -> names.removeIf(e -> e.endsWith(subString));
                    case "Length" -> names.removeIf(e -> e.length() == Integer.parseInt(subString));
                }
            }
            input = scanner.nextLine();
        }

    }
}
