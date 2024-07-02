package inheritanceexercises.person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Sergey", 32);
        Person child = new Child("Ivan", 5);

        System.out.println(person.getAge());
        System.out.println(person.getName());
        System.out.println(child.getAge());
        System.out.println(child.getName());
    }
}
