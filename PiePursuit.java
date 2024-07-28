import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> totalCountOfPiecesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> numberOfPiecesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(totalCountOfPiecesQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(numberOfPiecesStack::push);

        while (!totalCountOfPiecesQueue.isEmpty() && !numberOfPiecesStack.isEmpty()) {

            int contestantPieEatingCapacity = totalCountOfPiecesQueue.peek();
            int pieSize = numberOfPiecesStack.peek();

            if (contestantPieEatingCapacity <= pieSize) {
                int reminder = Math.abs(contestantPieEatingCapacity - pieSize);
                totalCountOfPiecesQueue.poll();
                numberOfPiecesStack.pop();
                numberOfPiecesStack.push(reminder);
            }
        }
    }
}
