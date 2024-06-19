package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
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

    public List<Parrot> getData() {
        return data;
    }

    public void setData(List<Parrot> data) {
        this.data = data;
    }

    public void add(Parrot parrot) {
        if(data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : data) {
            if (data.contains(parrot)) {
                if (parrot.getName().equals(name)) {
                    parrot.setAvailable(false);
                    data.remove(parrot);
                    return parrot;
                }
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = new ArrayList<>();
        this.data.forEach(parrot -> {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                parrots.add(parrot);
            }
        });
        return parrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append("Parrots available at ").append(getName()).append(":").append(System.lineSeparator());
        data.forEach(parrot -> {
            if (parrot.isAvailable()) {
                output.append(parrot).append(System.lineSeparator());
            }
        });
        return output.toString().trim();
    }

}
