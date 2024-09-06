package person;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Runador", 32);
        Child child1 = new Child("Ivan", 3);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(child1.getName());
        System.out.println(child1.getAge());
    }
}
