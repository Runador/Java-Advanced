package exercisesSetsАndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> occurrencesMap = new TreeMap<>();

        String input = scanner.nextLine();

        for (char symbol : input.toCharArray()) {
            occurrencesMap.putIfAbsent(symbol, 0);
            if (occurrencesMap.containsKey(symbol)) {
                occurrencesMap.put(symbol, occurrencesMap.get(symbol) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : occurrencesMap.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
