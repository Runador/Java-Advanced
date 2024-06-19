package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {
        String output;
        if (capacity > data.size()) {
            data.add(student);
            output = String.format("Added student %s %s.",
                    student.getFirstName(), student.getLastName());
        } else if (data.contains(student)) {
            output = "Student is already in the hall.";
        } else {
            output = "The hall is full.";
        }
        return output;
    }

    public String remove(Student student) {
        String output;
        if (data.contains(student)) {
            data.remove(student);
            output = String.format("Removed student %s %s.",
                    student.getFirstName(), student.getLastName());
        } else {
            output = "Student not found.";
        }
        return output;
    }

    public Student getStudent(String firstName, String lastName) {
        return data.stream().filter(student -> student.getFirstName()
                .equals(firstName)).filter(student -> student.getLastName()
                .equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics() {

        StringBuilder output = new StringBuilder();
        output.append("Hall size: ").append(getCount()).append(System.lineSeparator());
        data.forEach(student -> output.append("Student: ")
                .append(student.getFirstName()).append(" ")
                .append(student.getLastName()).append(", Best Course = ")
                .append(student.getBestCourse()).append(System.lineSeparator()));
        return output.toString();
    }
}
