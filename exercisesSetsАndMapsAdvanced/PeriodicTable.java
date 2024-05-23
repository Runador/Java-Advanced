package exercisesSetsАndMapsAdvanced;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> periodicElements = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] elements = scanner.nextLine().split(" ");
            periodicElements.addAll(Arrays.asList(elements));
        }

        periodicElements.forEach(e -> System.out.print(e + " "));
    }
}
