package setsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>();

        for (int i = 1; i <= 20; i++) {
            firstPlayer.add(scanner.nextInt());
        }
        for (int i = 1; i <= 20; i++) {
            secondPlayer.add(scanner.nextInt());
        }
        for (int i = 0; i < 50; i++) {
            int firstPlayerTopNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstPlayerTopNumber);
            int secondPlayerTopNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondPlayerTopNumber);
            if (firstPlayerTopNumber > secondPlayerTopNumber) {
                firstPlayer.add(secondPlayerTopNumber);
            } else {
                secondPlayer.add(firstPlayerTopNumber);
            }
        }
        if (firstPlayer.size() == secondPlayer.size()) {
            System.out.println("Draw!");
        }
        if (!firstPlayer.isEmpty()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}
