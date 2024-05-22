package setsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> softUniRegularGuests = new TreeSet<>();
        Set<String> softUniVIPGuests = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("PARTY")) {

            String comingGuest = input;

            if (!softUniRegularGuests.contains(comingGuest)
                    && isEightCharsLong(comingGuest) && !isStartWithDigit(comingGuest)) {
                softUniRegularGuests.add(comingGuest);
            }

            if (!softUniVIPGuests.contains(comingGuest)
                    && isEightCharsLong(comingGuest) && isStartWithDigit(comingGuest)) {
                softUniVIPGuests.add(comingGuest);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equalsIgnoreCase("END")) {

            String outgoingGuest = input;

            if (!softUniRegularGuests.isEmpty()) {
                if (softUniRegularGuests.contains(outgoingGuest)) {
                    softUniRegularGuests.remove(outgoingGuest);
                }
            }
            if (!softUniVIPGuests.isEmpty()) {
                if (softUniVIPGuests.contains(outgoingGuest)) {
                    softUniVIPGuests.remove(outgoingGuest);
                }
            }

            input = scanner.nextLine();
        }

        System.out.println(Math.abs(softUniRegularGuests.size() + softUniVIPGuests.size()));
        softUniVIPGuests.forEach(System.out::println);
        softUniRegularGuests.forEach(System.out::println);
    }

    // All reservation numbers will be with 8 chars.
    private static boolean isEightCharsLong(String guest) {
        return guest.length() == 8;
    }

    // All VIP numbers start with a digit.
    private static boolean isStartWithDigit(String guest) {
        return Character.isDigit(guest.charAt(0));
    }

}
