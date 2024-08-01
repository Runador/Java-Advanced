import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(malesStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(femalesQueue::offer);

        int matchesCounter = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {

            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (male <= 0) {
                malesStack.pop();
                continue;
            }
            if (female <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }
            if (female % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            if (male == female) {
                matchesCounter++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                femalesQueue.poll();
                male -= 2;
                malesStack.pop();
                malesStack.push(male);
                if (male < 0) {
                    malesStack.pop();
                }
            }
        }

        System.out.printf("Matches: %d%n", matchesCounter);
        if (malesStack.isEmpty()) {
            System.out.print("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.print(String.join(", ", malesStack.toString().replaceAll("[\\[\\]]", "")));
        }
        System.out.println();
        if (femalesQueue.isEmpty()) {
            System.out.print("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.print(String.join(", ", femalesQueue.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
