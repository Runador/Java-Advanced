package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (data.size() < capacity) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(present -> present.getName().equals(name));
    }

    public Present heaviestPresent() {
        return data.stream().max(Comparator.comparing(Present::getWeight)).orElse(null);
    }

    public Present getPresent(String name) {
        return data.stream().filter(present -> present.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder output = new StringBuilder(color + " bag contains:\n");
        data.forEach(car -> output.append(car).append("\n"));
        return output.toString().trim();
    }
}
