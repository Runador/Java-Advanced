package CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String departmentName = data[3];
            String email = "n/a";
            int age = -1;
            if (data.length == 6) {
                email = data[4];
                age = Integer.parseInt(data[5]);
            } else if (data.length == 5) {
                if (data[4].contains("@")) {
                    email = data[4];
                } else {
                    age = Integer.parseInt(data[4]);
                }
            }

            Employee employee = new Employee(name, salary, position, departmentName, email, age);
            /*Department department = getDepartmentByName(departments, departmentName);*/

        }

        // calculates the department with the highest average salary, and prints for each employee in that department
        // his name, salary, email, and age - sorted by salary in descending order.

       employees.stream().max(Comparator.comparing(Employee::getSalary));

    }
}
