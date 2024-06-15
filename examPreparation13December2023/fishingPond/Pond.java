package fishingPond;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pond {

    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (this.capacity > fishes.size()) {
            fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        /*for (Fish fish : data) {
            if (data.contains(fish) && fish.getSpecies().equals(species)) {
                data.remove(fish);
                return true;
            }
        }
        return false;*/
        return fishes.removeIf(fish -> fish.getSpecies().equals(species));
    }

    public Fish getOldestFish() {
        return Collections.max(fishes, Comparator.comparing(Fish::getAge));
    }

    public Fish getFish(String species) {
        /*for (Fish fish : fishes) {
            if (fishes.contains(fish) && fish.getSpecies().equals(species)) {
                return fish;
            }
        }
        return null;*/
        return fishes.stream().filter(fish -> fish.getSpecies().equals(species))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return this.fishes.size();
    }

    public int getVacancies() {
        return this.capacity - fishes.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder("Fishes in the pond:\n");
        for (Fish fish : fishes) {
            output.append(String.format("This %s is %d years old and reproduces through %s.\n",
                    fish.getSpecies(), fish.getAge(), fish.getMatingSeason()));
        }
        return output.toString();
    }

}
