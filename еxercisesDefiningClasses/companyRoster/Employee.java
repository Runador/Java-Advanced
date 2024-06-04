package еxercisesDefiningClasses.companyRoster;

public class Employee {
    // name, salary, position, department, email, and age

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        // name, salary, position, and department are mandatory
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public Employee(String name, double salary, String position, String department,
                    String email, int age) {
        // name, salary, position, and department are mandatory
        this(name, salary, position,department);
        this.email = email;
        this.age = -1;
    }

}
