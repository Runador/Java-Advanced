package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        numbersList.removeIf(integer -> integer % 2 != 0);

        System.out.println(String.join(", ", numbersList.toString().replaceAll("[\\[\\]]", "")));

        // numbersList.sort((a, b) -> a.compareTo(b));
        numbersList.sort(Integer::compareTo);

        System.out.println(String.join(", ", numbersList.toString().replaceAll("[\\[\\]]", "")));
    }
}
