import java.util.*;

public class PiePursuit2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> contestantCanConsumeQueue = new ArrayDeque<>();
        ArrayDeque<Integer> piePiecesContainsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(contestantCanConsumeQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(piePiecesContainsStack::push);

        while (!contestantCanConsumeQueue.isEmpty() &&
                !piePiecesContainsStack.isEmpty()) {

            int contestant = contestantCanConsumeQueue.peek();
            int pie = piePiecesContainsStack.peek();

            if (contestant >= pie) {
                contestant -= pie;
                piePiecesContainsStack.pop();
                if (contestant <= 0) {
                    contestantCanConsumeQueue.poll();
                } else {
                    contestantCanConsumeQueue.poll();
                    contestantCanConsumeQueue.offer(contestant);
                }
            } else {
                pie -= contestant;
                piePiecesContainsStack.pop();
                if (pie == 1) {
                    if (!piePiecesContainsStack.isEmpty()) {
                        piePiecesContainsStack.push(piePiecesContainsStack.pop() + pie);
                    }
                } else {
                    piePiecesContainsStack.push(pie);
                }
                contestantCanConsumeQueue.poll();
            }
        }

        if (piePiecesContainsStack.isEmpty() && !contestantCanConsumeQueue.isEmpty()) {
            List<Integer> pL = new ArrayList<>(contestantCanConsumeQueue);
            Collections.sort(pL);
            System.out.printf("We will have to wait for more pies to be baked!%nContestants left: ");
            System.out.print(pL.toString().replaceAll("[\\[\\]]", ""));
        }
        if (piePiecesContainsStack.isEmpty() && contestantCanConsumeQueue.isEmpty()) {
            System.out.println("We have a champion!");
        }
        if (!piePiecesContainsStack.isEmpty() && contestantCanConsumeQueue.isEmpty()) {
            List<Integer> pL = new ArrayList<>(piePiecesContainsStack);
            Collections.sort(pL);
            System.out.printf("Our contestants need to rest!%nPies left: ");
            System.out.println(pL.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
