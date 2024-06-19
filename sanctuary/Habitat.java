package sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Elephant> getData() {
        return data;
    }

    public void setData(List<Elephant> data) {
        this.data = data;
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(elephant -> elephant.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream().filter(elephant -> elephant.getRetiredFrom()
                .equals(retiredFrom)).findFirst().orElse(null);
    }

    public Elephant getOldestElephant() {
        return Collections.max(data, Comparator.comparing(Elephant::getAge));
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder output = new StringBuilder();
        output.append("Saved elephants in the park:").append(System.lineSeparator());

        data.forEach(elephant -> output.append(elephant.getName())
                .append(" came from: ").append(elephant.getRetiredFrom())
                .append(System.lineSeparator()));
        return output.toString();
    }

}
