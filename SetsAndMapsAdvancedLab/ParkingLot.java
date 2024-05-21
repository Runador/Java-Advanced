package setsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> carNumbers = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("END")) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String carNumber = tokens[1];

            if (command.equalsIgnoreCase("IN")) {
                carNumbers.add(carNumber);
            } else {
                carNumbers.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (!carNumbers.isEmpty()) {
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }

    }
}
