package exercisesSetsАndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        String[] lengths = scanner.nextLine().split(" ");
        int firstSetLength = Integer.parseInt(lengths[0]);
        int secondSetLength = Integer.parseInt(lengths[1]);

        while (firstSetLength-- > 0) {
            int element = Integer.parseInt(scanner.nextLine());
            firstSet.add(element);
        }
        while (secondSetLength-- > 0) {
            int element = Integer.parseInt(scanner.nextLine());
            secondSet.add(element);
        }
        for (int element : firstSet) {
            if (secondSet.contains(element)) {
                System.out.print(element + " ");
            }
        }

    }
}
