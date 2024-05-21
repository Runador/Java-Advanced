package setsAndMapsAdvancedLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

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
            /*if (studentsGradesMap.containsKey(name)) {
                studentsGradesMap.put(name, studentsGradesMap.get(name).add(grade));
            }*/

        }

    }
}
