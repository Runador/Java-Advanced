package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        String output;
        if (students.contains(student)) {
            output = "Student is already in the university";
        } else {
            if (capacity > students.size()) {
                students.add(student);
                output = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                output = "No seats in the university";
            }
        }
        return output;
    }

    public String dismissStudent(Student student) {
        if (students.remove(student)) {
            return student.toString() + " dismissed";
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return students.stream().filter(student -> student.getFirstName().equals(firstName)
            && student.getLastName().equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        students.forEach(student -> output.append("==Student: First Name = ")
                .append(student.getFirstName()).append(", Last Name = ")
                .append(student.getLastName()).append(", Best Subject = ")
                .append(student.getBestSubject()).append(System.lineSeparator()));
        return output.toString();
    }
}
