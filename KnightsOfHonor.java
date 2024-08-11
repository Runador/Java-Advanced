package functionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(name -> System.out.println("Sir " + name));

        Consumer<String> consumer = name -> System.out.println("Sir " + name);

        //names.forEach(name -> System.out.println("Sir " + name));

    }
}
