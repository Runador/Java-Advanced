package LabEncapsulation.SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new ArrayList<>(); // создаем лист

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+"); // делим строку
            personList.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
            // добавляем в лист елементъ разделенной строки
        }

        Collections.sort(personList, (firstPerson, secondPerson) -> { // сортируем лист

            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (sComp != 0) {
                return sComp;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }

        });

        for (Person person : personList) {
            System.out.println(person.toString());
        }

    }

}
