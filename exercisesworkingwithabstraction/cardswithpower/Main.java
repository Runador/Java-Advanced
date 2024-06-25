package exercisesworkingwithabstraction.cardswithpower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        RankPowers rankPower = RankPowers.valueOf(rank);
        SuitPowers suitPower = SuitPowers.valueOf(suit);

        Card card = new Card(rankPower, suitPower);
        // Card name: TWO of CLUBS; Card power: 2
        System.out.printf("Card name: %s of %s; Card power: %d",
                rankPower, suitPower, rankPower.getRank() + suitPower.getSuit());

    }
}
