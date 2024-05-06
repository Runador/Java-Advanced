package InheritanceLab.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Employee employee = new Employee("Sergey");
        employee.fire("he was the most cool employee in the office");
        Person person = new Person("Ivan");
        person.sleep();
        employee.sleep();
    }
}
