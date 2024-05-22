package setsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        printNumbers(numbers);
    }

    private static void printNumbers(List<Integer> numbers) {
        if (numbers.size() > 3) {
            for (int i = 0; i < 3; i++) {
                System.out.print(numbers.get(i) + " ");
            }
        } else {
            numbers.forEach(number -> System.out.print(number + " "));
        }
    }

}
