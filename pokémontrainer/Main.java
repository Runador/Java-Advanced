package pokémontrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> trainersNames = new LinkedHashSet<>();
        Map<Trainer, List<Pokemon>> trainerMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {

            String[] data = input.split("\\s+");

            String trainerName = data[0];

            trainersNames.add(trainerName);

            Pokemon pokemon = new Pokemon(data[1], data[2], Integer.parseInt(data[3]));

            if (trainerName.equals())


            input = scanner.nextLine();
        }
        System.out.println();
        input = scanner.nextLine();

        /*while (!input.equals("End")) {
            String command = input;
            switch (command) {
                case "Fire" -> {
                    mapOfTrainers.get()
                }
                        case "Electricity" ->
                                case "Water" ->
            }

            input = scanner.nextLine();
        }*/
    }
}
