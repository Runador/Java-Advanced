package LabEncapsulation.FirstAndReserveTeam;

import java.text.DecimalFormat;

public class Player {

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

    public Player(String firstName, String lastName, int age, double salary) {
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

}
