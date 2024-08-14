package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        if (numbersList.size() > 0) {
            System.out.println("Count = " + numbersList.size());
        }

        int sum = 0;
        Function<String, Integer> parser = Integer::parseInt;
        for (Integer n : numbersList) {
            sum += parser.apply(String.valueOf(n));
        }
        System.out.println("Sum = " + sum);
    }
}
