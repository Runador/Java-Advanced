package LabEncapsulation.ValidationData;

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
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
            // тут нельзя использовать sout, нужно использовать exception handler
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
            // тут нельзя использовать sout, нужно использовать exception handler
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
            // тут нельзя использовать sout, нужно использовать exception handler
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460.0) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
            // тут нельзя использовать sout, нужно использовать exception handler
        }
        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);   // валидация происходит через setter
        this.setLastName(lastName);     // валидация происходит через setter
        this.setAge(age);               // валидация происходит через setter
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this(firstName, lastName, age); // инициализируем даннъе черес передъдущий конструктор
        this.setSalary(salary);
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
