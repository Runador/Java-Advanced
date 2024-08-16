package functionalprogramming;

import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int lower = Integer.parseInt(input[0]);
        int upper = Integer.parseInt(input[1]);

        String command = scanner.nextLine();

        for (int i = lower; i <= upper; i++) {
            if (command.equals("even")) {
                if (i % 2 == 0) {
                    System.out.printf("%d ", i);
                }
            } else if (command.equals("odd")) {
                if (i % 2 != 0) {
                    System.out.printf("%d ", i);
                }
            }
        }
        // Predicate<Integer> first =

    }
}
