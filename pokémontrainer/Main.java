package pokémontrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainers = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {

            String[] data = input.split("\\s+");
            String trainerName = data[0];

            Trainer trainer = getTrainerByName(trainers, trainerName);
            trainer.addPokemon(new Pokemon(data[1], data[2], Integer.parseInt(data[3])));

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            String element = input;
            switch (element) {
                case "Fire":
                    for (Trainer trainer : trainers) {
                        if (getNumberOfPokemonsByElement(trainers, element) >= 1) {
                            trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
                        } else {
                            losingHealthPokemon(trainers);
                        }
                    }
                    break;
                    case "Water":
                    break;
                case "Electricity":
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static int getNumberOfPokemonsByElement(List<Trainer> trainers, String element) {
        int number = 0;
        for (Trainer trainer : trainers) {
            List<Pokemon> pokemons = trainer.getPokemons();
            for (Pokemon pokemon : pokemons) {
                if (pokemon.getElement().equals(element)) {
                    number += 1;
                }
            }
        }
        return number;
    }

    public static void losingHealthPokemon(List<Trainer> trainers) {
        for (Trainer trainer : trainers) {
            List<Pokemon> pokemons = trainer.getPokemons();
            for (Pokemon pokemon : pokemons) {
                pokemon.loseHealth();
                if (pokemon.getHealth() <= 0) {
                    trainer.getPokemons().remove(pokemon);
                }
            }
        }
    }

    private static Trainer getTrainerByName(List<Trainer> trainers, String trainerName) {
        for (Trainer trainer : trainers) {
            if (trainer.getName().equals(trainerName)) {
                return trainer;
            }
        }
        Trainer trainer = new Trainer(trainerName);
        trainers.add(trainer);
        return trainer;
    }
}
