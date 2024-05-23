package setsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> graduatedStudentsMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .mapToDouble(Double::parseDouble).toArray();
            graduatedStudentsMap.putIfAbsent(name, new ArrayList<>());
            for (double grade : grades) {
                graduatedStudentsMap.get(name).add(grade);
            }
        }

        for (var entry : graduatedStudentsMap.entrySet()) {
            String name = entry.getKey();
            List<Double> grades = entry.getValue();
            double averageGrade;
            double sum = 0;

            for (double grade : grades) {
                sum += grade;
            }
            averageGrade = sum / grades.size();
            DecimalFormat decimalFormat = new DecimalFormat("#.0####");
            System.out.println(name + " is graduated with "
                    + decimalFormat.format(averageGrade));
        }
    }
}
