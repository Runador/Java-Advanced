import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] data = input.split("\\s");
            String command1 = data[0];
            if (command1.equals("Double")) {
                String command2 = data[1];
                String subString = data[2];
                switch (command2) {
                    case "StartsWith" -> {
                        String name = names.stream().filter(e -> e.startsWith(subString)).findFirst().orElse(null);
                        long counter = names.stream().filter(e -> e.startsWith(subString)).count();
                        for (int i = 0; i < counter; i++) {
                            names.add(name);
                        }
                    }
                    case "EndsWith" -> {
                        String name = names.stream().filter(e -> e.endsWith(subString)).findFirst().orElse(null);
                        long counter = names.stream().filter(e -> e.endsWith(subString)).count();
                        for (int i = 0; i < counter; i++) {
                            names.add(name);
                        }
                    }
                    case "Length" -> {
                        String name = names.stream().filter(e -> e.length() == Integer.parseInt(data[2])).findFirst().orElse(null);
                        long counter = names.stream().filter(e -> e.length() == Integer.parseInt(data[2])).count();
                        for (int i = 0; i < counter; i++) {
                            names.add(name);
                        }
                    }
                }
            } else if (command1.equals("Remove")) {
                String command = data[1];
                String subString = data[2];
                if (!names.isEmpty()) {
                    switch (command) {
                        case "StartsWith" -> names.removeIf(name -> name.startsWith(subString));
                        case "EndsWith" -> names.removeIf(e -> e.endsWith(subString));
                        case "Length" -> names.removeIf(e -> e.length() == Integer.parseInt(subString));
                    }
                }
            }
            input = scanner.nextLine();
        }
        Collections.sort(names);
        if (!names.isEmpty()) {
            System.out.print(String.join(", ", names));
            System.out.println(" are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
