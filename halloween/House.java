package halloween;

import java.util.ArrayList;
import java.util.List;

public class House {

    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Kid> getData() {
        return data;
    }

    public void setData(List<Kid> data) {
        this.data = data;
    }

    public void addKid(Kid kid) {
        if (capacity > data.size()) {
            data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        return data.removeIf(kid -> kid.getName().equals(name));
    }

    public Kid getKid(String street) {
        return data.stream().filter(kid -> kid.getStreet().equals(street)).findFirst().orElse(null);
    }

    public int getAllKids() {
        return data.size();
    }

    public String getStatistics() {

        StringBuilder output = new StringBuilder("Children who visited a house for candy:").append(System.lineSeparator());
        data.forEach(kid -> output.append(kid.getName()).append(" from ")
                .append(kid.getStreet()).append(" street").append(System.lineSeparator()));
        return output.toString();
    }

}
