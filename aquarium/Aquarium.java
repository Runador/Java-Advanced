package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFishInPool(List<Fish> fishInPool) {
        this.fishInPool = fishInPool;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (fishInPool.size() < capacity) {
            if (!fishInPool.contains(fish)) {
                fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        return fishInPool.removeIf(fish -> fish.getName().equals(name));
    }

    public Fish findFish(String name) {
        return fishInPool.stream().filter(fish -> fish.getName().equals(name))
                .findFirst().orElse(null);
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append("Aquarium: ").append(getName()).append(" ^ Size: ")
                .append(getSize()).append(System.lineSeparator());
        fishInPool.forEach(fish -> output.append(fish).append(System.lineSeparator()));
        return output.toString();
    }

}
