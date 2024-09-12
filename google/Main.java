package google;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Parent> parents = new ArrayList<>();
        List<Child> children = new ArrayList<>();
        List<Pokemon> pokemons = new ArrayList<>();
        Map<String, Person> personMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            String personName = data[0];

            personMap.putIfAbsent(personName, new Person());

            String type = data[1];
            switch (type) {
                case "company":
                    Company company = new Company(data[2], data[3], Double.parseDouble(data[4]));
                    break;
                case "pokemon":
                    pokemons.add(new Pokemon(data[2], data[3]));
                    break;
                case "parents":
                    parents.add(new Parent((data[2]), data[3]));
                    break;
                case "children":
                    children.add(new Child(data[2], data[3]));
                    break;
                case "car":
                    Car car = new Car(data[2], Integer.parseInt(data[3]));
            }

            input = scanner.nextLine();
        }

    }
}
