package pokémontrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Pokemon> pokemons = new ArrayList<>();
        Map<Trainer, List<Pokemon>> mapOfTrainers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {

            // "{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
            String[] data = input.split("\\s+");
            Trainer trainer = new Trainer(data[0]);
            Pokemon pokemon = new Pokemon(data[1], data[2], Integer.parseInt(data[3]));
            pokemons.add(pokemon);
            mapOfTrainers.putIfAbsent(trainer, pokemons);

            input = scanner.nextLine();
        }

    }
}
