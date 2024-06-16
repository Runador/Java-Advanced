package еxercisesDefiningClasses.opinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        people.sort(Comparator.comparing(Person::getName));
        people.stream().filter(person -> person.getAge() > 30).forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));

    }
}
