import java.util.Scanner;
import java.util.function.Predicate;

public class EvensOrOdds {

    private static final Predicate<Integer> evenPredicate = e -> e % 2 == 0;
    private static final Predicate<Integer> oddPredicate = e -> e % 2 != 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int begin = Integer.parseInt(tokens[0]);
        int end = Integer.parseInt(tokens[1]);
        String command = scanner.nextLine();

        if (command.equals("even")) {
            printingPredicate(begin, end, evenPredicate);
        } else if (command.equals("odd")) {
            printingPredicate(begin, end, oddPredicate);
        }

    }

    private static void printingPredicate(int begin, int end, Predicate<Integer> predicate) {
        for (int i = begin; i <= end; i++) {
            if (predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

}
