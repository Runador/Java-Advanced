package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("Beast!")) {
            String type = command;
            String[] animalsData = scanner.nextLine().split("\\s+");
            switch (type) {
                case "Cat" -> {
                    Cat cat = new Cat(animalsData[0], Integer.parseInt(animalsData[1]), animalsData[2]);
                    animals.add(cat);
                }
                case "Dog" -> {
                    Dog dog = new Dog(animalsData[0], Integer.parseInt(animalsData[1]), animalsData[2]);
                    animals.add(dog);
                }
                case "Frog" -> {
                    Frog frog = new Frog(animalsData[0], Integer.parseInt(animalsData[1]), animalsData[2]);
                    animals.add(frog);
                }
                case "Kitten" -> {
                    Kitten kitten = new Kitten(animalsData[0], Integer.parseInt(animalsData[1]));
                    animals.add(kitten);
                }
                case "Tomcat" -> {
                    Tomcat tomcat = new Tomcat(animalsData[0], Integer.parseInt(animalsData[1]));
                    animals.add(tomcat);
                }
            }

            command = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.printf("%s%n%s %d %s%n", animal, animal.getName(), animal.getAge(), animal.getGender());
            System.out.println(animal.produceSound());
        }
    }
}
