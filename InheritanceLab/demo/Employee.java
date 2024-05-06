package InheritanceLab.demo;

public class Employee extends Person {

    public Employee(String name) {
        super(name);
    }

    public void fire(String reasons) {
        System.out.println("Employee " + super.getName() + " got fired, because " + reasons + ".");
    }

    @Override
    public void sleep() {
        System.out.println("Employee sleeping");
    }
}
