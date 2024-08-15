package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wordsList = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        Predicate<String> checkerUpperCase = word -> Character.isUpperCase(word.charAt(0));

        ArrayList<String> resultList = new ArrayList<>();

        for (int i = 0; i < wordsList.size(); i++) {
            if (checkerUpperCase.test(wordsList.get(i))) {
                resultList.add(wordsList.get(i));
            }
        }
        System.out.println(resultList.size());
        resultList.forEach(System.out::println);
    }
}
