package setsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList()).stream()
                .sorted(Collections.reverseOrder()).toList();

        printNumbers(numbers);
    }

    private static void printNumbers(List<Integer> numbers) {
        int size = numbers.size();
        if (size > 3) {
            for (int number : numbers) {
                if (size == 3) {
                    break;
                }
                System.out.print(number + " ");
                size--;
            }
        } else {
            numbers.forEach(number -> System.out.print(number + " "));
        }
    }
}
