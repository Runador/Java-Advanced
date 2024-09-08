package sayhello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Bulgarian("Victor"));
        people.add(new European("Runador"));
        people.add(new Chinese("Bruce Lee"));

        for (Person person : people) {
            System.out.println(person.getName());
            System.out.println(person.sayHello());
        }
    }
}
