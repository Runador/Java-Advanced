import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .forEach(tasksStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(threadsQueue::offer);

        int needToKillTask = Integer.parseInt(scanner.nextLine());

        boolean areTaskIsKilled = false;

        while (!tasksStack.isEmpty() && !threadsQueue.isEmpty()) {

            int task = tasksStack.peek();
            int thread = threadsQueue.peek();

            if (task == needToKillTask) {
                tasksStack.pop();
                System.out.printf("Thread with value %d killed task %d%n", thread, needToKillTask);
                areTaskIsKilled = true;
                break;
            }

            if (thread >= task) {
                tasksStack.pop();
            }
            threadsQueue.poll();
        }

        if (areTaskIsKilled) {
            threadsQueue.forEach(thread -> System.out.printf("%d ", thread));
        }
    }
}
