package intPerson;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Method[] declaredMethods = Person.class.getDeclaredMethods();
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Citizen citizen = new Citizen(name, age);
        System.out.println(declaredMethods.length);
        System.out.println(citizen.getName());
        System.out.println(citizen.getAge());
    }
}
