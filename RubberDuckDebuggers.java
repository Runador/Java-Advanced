import java.util.*;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> timeForTasksQueue = new ArrayDeque<>();
        ArrayDeque<Integer> numberOfTasksStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(timeForTasksQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(numberOfTasksStack::push);

        int darthVaderCounter = 0;
        int thorCounter = 0;
        int bigBlueRubberDuckyCounter = 0;
        int smallYellowRubberDucky = 0;

        while (!timeForTasksQueue.isEmpty() && !numberOfTasksStack.isEmpty()) {

            int timeForTask = timeForTasksQueue.peek();
            int numberOfTasks = numberOfTasksStack.peek();
            int result = timeForTask * numberOfTasks;

            if (result >= 0 && result <= 60) {
                darthVaderCounter++;
                timeForTasksQueue.poll();
                numberOfTasksStack.pop();
            } else if (result > 60 && result <= 120) {
                thorCounter++;
                timeForTasksQueue.poll();
                numberOfTasksStack.pop();
            } else if (result > 120 && result <= 180) {
                bigBlueRubberDuckyCounter++;
                timeForTasksQueue.poll();
                numberOfTasksStack.pop();
            } else if (result > 180 && result <= 240) {
                smallYellowRubberDucky++;
                timeForTasksQueue.poll();
                numberOfTasksStack.pop();
            } else {
                numberOfTasksStack.push(numberOfTasksStack.pop() - 2);
                timeForTasksQueue.poll();
                timeForTasksQueue.offer(timeForTask);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.println("Darth Vader Ducky: " + darthVaderCounter);
        System.out.println("Thor Ducky: " + thorCounter);
        System.out.println("Big Blue Rubber Ducky: " + bigBlueRubberDuckyCounter);
        System.out.println("Small Yellow Rubber Ducky: " + smallYellowRubberDucky);
    }
}

