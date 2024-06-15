package examPreparation13December2023.fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {

    private int capacity;
    private List<Fish> data;

    public Pond(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (this.capacity > data.size()) {
            data.add(fish);
        }
    }

    public boolean removeFish(String species) {
        for (Fish fish : data) {
            if (data.contains(fish)) {
                if (fish.getSpecies().equals(species)) {
                    data.remove(fish);
                    return true;
                }
            }
        }
        return false;
    }

    public Fish getOldestFish() {
        Fish oldestFish = null;
        int oldest = 0;
        for (Fish fish : data) {
            if (fish.getAge() > oldest) {
                oldestFish = fish;
            }
        }
        return oldestFish;
    }

    public Fish getFish(String species) {
        for (Fish fish : data) {
            if (data.contains(fish) && fish.getSpecies().equals(species)) {
                return fish;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public int getVacancies() {
        return this.capacity - data.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder("Fishes in the pond:\n");
        for (Fish fish : data) {
            output.append(String.format("This %s is %d years old and reproduces through %s.\n",
                    fish.getSpecies(), fish.getAge(), fish.getMatingSeason()));
        }
        return output.toString();
    }

}
