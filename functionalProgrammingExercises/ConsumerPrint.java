package functionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerPrint {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .collect(Collectors.toList());

        names.forEach(System.out::println);

        //Consumer<String> consumer = name -> System.out.println(name);

        /*for (String name : names) {
            consumer.accept(name);
        }*/

        //names.forEach(consumer);

    }
}

