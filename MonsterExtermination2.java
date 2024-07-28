import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MonsterExtermination2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> monstersArmorQueue = new ArrayDeque<>();
        ArrayDeque<Integer> soldierStrikingImpactStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt)
                .forEach(monstersArmorQueue::offer);

        Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt)
                .forEach(soldierStrikingImpactStack::push);

        int killedMonsters = 0;

        while (!monstersArmorQueue.isEmpty() && !soldierStrikingImpactStack.isEmpty()) {

            int armor = monstersArmorQueue.peek();
            int strike = soldierStrikingImpactStack.peek();

            if (strike >= armor) {
                killedMonsters++;
                monstersArmorQueue.poll();
                soldierStrikingImpactStack.pop();
                strike -= armor;
                if (soldierStrikingImpactStack.peek() != null && soldierStrikingImpactStack.peek() + strike != 0) {
                    soldierStrikingImpactStack.push(soldierStrikingImpactStack.pop() + strike);
                }
            } else {
                armor -= strike;
                monstersArmorQueue.poll();
                monstersArmorQueue.offer(armor);
                soldierStrikingImpactStack.pop();
            }
        }

        if (monstersArmorQueue.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (soldierStrikingImpactStack.isEmpty()) {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d", killedMonsters);
    }
}
