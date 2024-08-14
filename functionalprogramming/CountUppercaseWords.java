package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split("\\s+")).toList();
        List<String> savedWords = new ArrayList<>();
        int counter = 0;
        for (String word : wordsList) {
            if (Character.isUpperCase(word.charAt(0))) {
                counter++;
                savedWords.add(word);
            }
        }
        System.out.println(counter);
        savedWords.forEach(System.out::println);
    }
}
