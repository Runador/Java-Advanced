package inheritancelab.singleinheritance;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Dog(); // IS-A создается новъй объект
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }
}
