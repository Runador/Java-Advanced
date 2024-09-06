package hierarchicalinheritance;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        Animal dog1 = new Dog();
        Animal cat1 = new Cat();

        animal.eat();
        System.out.println();
        dog.eat();
        dog.bark();
        System.out.println();
        cat.eat();
        cat.meow();
        System.out.println();
        dog1.eat();
        System.out.println();
        cat1.eat();
        List<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.add(dog);
        animals.add(cat);
    }
}
