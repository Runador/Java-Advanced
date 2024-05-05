package LabEncapsulation.SalaryIncrease;

import java.text.DecimalFormat;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", getFirstName(), getLastName(),
                new DecimalFormat("#.0####").format(this.getSalary()));
        // 0 – prints a digit if provided, 0 otherwiseю
        // # – prints a digit if provided, nothing otherwise
    }

    public void increaseSalary(double bonus) {

        double modifier;

        if (this.getAge() < 30) {   // въчисляем процент
            modifier = (bonus / 100) / 2;
            this.setSalary(this.salary + this.salary * modifier);
        } else {
            modifier = bonus / 100;
            this.setSalary(this.salary + this.salary * modifier);
        }

        /*double percent = (this.salary * bonus) / 100;
        if (this.getAge() < 30) {
            this.setSalary(this.salary + (percent / 2));    // нужно использовать сеттер
        } else {
            this.setSalary(this.salary += percent);         // нужно использовать сеттер
        }*/
    }

}
