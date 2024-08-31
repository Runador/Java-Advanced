import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .collect(Collectors.toList());

        ArrayDeque<String> namesStack = new ArrayDeque<>();

        long count = 0;

        String input = scanner.nextLine();

        while (!input.equals("Print")) {
            String[] data = input.split(";");
            String command = data[0];
            String secondCommand = data[1];
            if (command.equals("Add filter")) {
                switch (secondCommand) {
                    case "Starts with" -> {
                        String filterWord = data[2];
                        String name = names.stream().filter(e -> e.startsWith(filterWord)).findFirst().orElse(null);
                        long counter = names.stream().filter(e -> e.startsWith(filterWord)).count();
                        if (name != null) {
                            namesStack.push(name);
                        }
                        count = counter;
                        for (int i = 0; i < counter; i++) {
                            names.remove(name);
                        }
                    }
                    case "Ends with" -> {
                        String filterWord = data[2];
                        String name = names.stream().filter(e -> e.endsWith(filterWord)).findFirst().orElse(null);
                        long counter = names.stream().filter(e -> e.endsWith(filterWord)).count();
                        if (name != null) {
                            namesStack.push(name);
                        }
                        count = counter;
                        for (int i = 0; i < counter; i++) {
                            names.remove(name);
                        }
                    }
                    case "Length" -> {
                        int length = Integer.parseInt(data[2]);
                        String name = names.stream().filter(e -> e.length() == length).findFirst().orElse(null);
                        long counter = names.stream().filter(e -> e.length() == length).count();
                        if (name != null) {
                            namesStack.push(name);
                        }
                        count = counter;
                        for (int i = 0; i < counter; i++) {
                            names.remove(name);
                        }
                    }
                    case "Contains" -> {
                        String containsKey = data[2];
                        String name = names.stream().filter(e -> e.contains(containsKey)).findFirst().orElse(null);
                        long counter = names.stream().filter(e -> e.contains(containsKey)).count();
                        if (name != null) {
                            namesStack.push(name);
                        }
                        count = counter;
                        for (int i = 0; i < counter; i++) {
                            names.remove(name);
                        }
                    }
                }
            } else if (command.equals("Remove filter")) {
                switch (secondCommand) {
                    case "Starts with" -> {
                        String filterWord = data[2];
                        String name = names.stream().filter(e -> e.startsWith(filterWord)).findFirst().orElse(null);
                        if (name == null) {
                            if (!namesStack.isEmpty()) {
                                String lastName = namesStack.pop();
                                for (int i = 0; i < count; i++) {
                                    names.addFirst(lastName);
                                }
                            }
                        }
                    }
                    case "Ends with" -> {
                        String filterWord = data[2];
                        String name = names.stream().filter(e -> e.endsWith(filterWord)).findFirst().orElse(null);
                        if (name == null) {
                            if (!namesStack.isEmpty()) {
                                String lastName = namesStack.pop();
                                for (int i = 0; i < count; i++) {
                                    names.addFirst(lastName);
                                }
                            }
                        }
                    }
                    case "Length" -> {
                        int length = Integer.parseInt(data[2]);
                        String name = names.stream().filter(e -> e.length() == length).findFirst().orElse(null);
                        if (name == null) {
                            if (!namesStack.isEmpty()) {
                                String lastName = namesStack.pop();
                                for (int i = 0; i < count; i++) {
                                    names.addFirst(lastName);
                                }
                            }
                        }
                    }
                    case "Contains" -> {
                        String containsKey = data[2];
                        String name = names.stream().filter(e -> e.contains(containsKey)).findFirst().orElse(null);
                        if (name == null) {
                            if (!namesStack.isEmpty()) {
                                String lastName = namesStack.pop();
                                    for (int i = 0; i < count; i++) {
                                        names.addFirst(lastName);
                                    }
                                }
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        if (!names.isEmpty()) {
            names.forEach(e -> System.out.print(e + " "));
        }
    }
}
