package setsAndMapsAdvancedLab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<Double>> studentsGradesMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsGradesMap.putIfAbsent(name, new ArrayList<>());
            studentsGradesMap.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentsGradesMap.entrySet()) {
            double avg;
            double sum = 0;

            for (double grade : entry.getValue()) {
                sum += grade;
            }
            avg = sum / entry.getValue().size();
            System.out.printf("%s -> ", entry.getKey());
            entry.getValue().forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)%n", avg);
        }

    }
}
