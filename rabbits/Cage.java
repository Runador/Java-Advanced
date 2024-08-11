package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (capacity > data.size()) {
            data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public void removeSpecies(String species) {
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name) && rabbit.isAvailable()) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbits = new ArrayList<>();
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species) && rabbit.isAvailable()) {
                rabbit.setAvailable(false);
                rabbits.add(rabbit);
            }
        }
        return rabbits;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        List<Rabbit> availableRabbits = data.stream()
                .filter(Rabbit::isAvailable).collect(Collectors.toList());

        StringBuilder output = new StringBuilder("Rabbits available at " + this.name + ":").append("\n");
        availableRabbits.forEach(rabbit -> output.append(rabbit).append("\n"));
        return output.toString().trim();
    }
}
