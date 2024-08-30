import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FilterByAge {

    private static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            personList.add(person);
        }

        String ageCriteria = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> predicate = getAgeCriteria(ageCriteria, age);

        switch (format) {
            case "name" -> personList.stream().filter(predicate).forEach(p -> System.out.println(p.name));
            case "age" -> personList.stream().filter(predicate).forEach(p -> System.out.println(p.age));
            case "name age" -> personList.stream().filter(predicate).forEach(p -> System.out.printf("%s - %d%n", p.name, p.age));
        }
    }

    private static Predicate<Person> getAgeCriteria(String ageCriteria, int age) {
        return switch (ageCriteria) {
            case "younger" -> person -> person.age <= age;
            case "older" -> person -> person.age >= age;
            default -> throw new IllegalArgumentException("Unsupported input value");
        };
    }
}
