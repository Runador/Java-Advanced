package singleinheritance;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog1 = new Dog();
        Dog dog2 = new Dog();

        animal.eat();
        dog1.eat();
        dog2.eat();
        dog2.bark();
    }
}
