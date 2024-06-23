import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*  20,15,10
            5,15,10,25*/

        ArrayDeque<Integer> monstersArmorQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt)
                .forEach(monstersArmorQueue::offer);

        ArrayDeque<Integer> soldierStrikingImpactStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt)
                .forEach(soldierStrikingImpactStack::push);

        int killedMonstersCounter = 0;

        while (!monstersArmorQueue.isEmpty() && !soldierStrikingImpactStack.isEmpty()) {

            Integer armor = monstersArmorQueue.poll();
            Integer soldierStrike = soldierStrikingImpactStack.pop();

            if (soldierStrike >= armor) {
                killedMonstersCounter++;
                Integer soldier = Math.abs(soldierStrike - armor);
                soldierStrikingImpactStack.push(soldierStrikingImpactStack.pop() + soldier);
            } else {
                armor -= soldierStrike;
                monstersArmorQueue.offer(armor);
            }

        }

        if (!soldierStrikingImpactStack.isEmpty()) {
            System.out.println("All monsters have been killed!");
        }
        if (!monstersArmorQueue.isEmpty()){
            System.out.println("The soldier has been defeated.");
        }

        System.out.printf("Total monsters killed: %d", killedMonstersCounter);

    }

}
