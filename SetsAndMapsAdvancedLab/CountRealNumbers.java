package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        String[] numbers = scanner.nextLine().split(" ");

        for (String s : numbers) {
            double number = Double.parseDouble(s);
            /*if (!numbersMap.containsKey(number)) {
                numbersMap.put(number, 1);
            } else {
                numbersMap.put(number, numbersMap.get(number) + 1);
            }*/
            numbersMap.putIfAbsent(number, 0);
            if (numbersMap.containsKey(number)) {
                numbersMap.put(number, numbersMap.get(number) + 1);
            }
        }

        for (var entry : numbersMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
