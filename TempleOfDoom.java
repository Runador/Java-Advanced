import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TempleOfDoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(toolsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(substancesStack::push);

        List<Integer> challengesList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        boolean isFailed = false;

        while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()) {

            int tool = toolsQueue.peek();
            int substance = substancesStack.peek();
            int result = tool * substance;

            for (int i = 0; i < challengesList.size(); i++) {
                if (result == challengesList.get(i)) {
                    toolsQueue.poll();
                    substancesStack.pop();
                    challengesList.remove(i);
                    isFailed = true;
                    break;
                }
            }

            if (!isFailed) {
                toolsQueue.offer(++tool);
                toolsQueue.poll();
                --substance;
                if (substance != 0) {
                    substancesStack.pop();
                    substancesStack.push(substance);
                } else {
                    substancesStack.pop();
                }
            }
        }

        if (!challengesList.isEmpty()) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }

        if (!toolsQueue.isEmpty()) {
            System.out.print("Tools: ");
            System.out.println(String.join(", ", toolsQueue.toString().replaceAll("[\\[\\]]", "")));
        }
        if (!substancesStack.isEmpty()) {
            System.out.print("Substances: ");
            System.out.println(String.join(", ", substancesStack.toString().replaceAll("[\\[\\]]", "")));
        }
        if (!challengesList.isEmpty()) {
            System.out.print("Challenges: ");
            System.out.println(String.join(", ", challengesList.toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
