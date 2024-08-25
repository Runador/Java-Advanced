import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int counter = 50;

        while (counter-- > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {

            int firstPlayerCard = firstPlayer.getFirst();
            int secondPlayerCard = secondPlayer.getFirst();

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard){
                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }
            firstPlayer.remove(firstPlayerCard);
            secondPlayer.remove(secondPlayerCard);
        }

        if (firstPlayer.size() == secondPlayer.size()) {
            System.out.println("Draw!");
        } else if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }

    private static int getFirstNumber(LinkedHashSet<Integer> firstPlayer) {
        for (int number : firstPlayer) {
            return number;
        }
        return 0;
    }
}
