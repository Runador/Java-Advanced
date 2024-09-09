package say_hello_extend;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Sergey"));
        persons.add(new European("Sergey"));
        persons.add(new Chinese("Sergey"));

        persons.forEach(Main::print);
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}
