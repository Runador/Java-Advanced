package salaryincrease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Person person = new Person(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
            personList.add(person);
        }

        double percent = Double.parseDouble(scanner.nextLine());
        for (Person person : personList) {
            person.increaseSalary(percent);
        }
        personList.forEach(System.out::println);
    }
}
