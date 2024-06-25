package exercisesworkingwithabstraction.cardsuit;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        CardSuit[] cardSuits = CardSuit.values();

        for (CardSuit cardSuit : cardSuits) {
            int ordinal = cardSuit.ordinal();
            System.out.printf("Ordinal value: %d; Name value: %s\n",
                    ordinal, cardSuit);
        }

    }
}
