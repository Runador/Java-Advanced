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

        Predicate<Integer> odd = i -> i % 2 != 0;
        Predicate<Integer> even = i -> i % 2 == 0;

        for (int i = lower; i <= upper; i++) {
            if (command.equals("odd") && odd.test(i)) {
                System.out.print(i + " ");
            } else if (command.equals("even") && even.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
