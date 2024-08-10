package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {

    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        if (capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder("Employees working at Cafe  " + this.name).append(":\n");
        employees.forEach(car -> output.append(car).append("\n"));
        return output.toString().trim();
    }
}
