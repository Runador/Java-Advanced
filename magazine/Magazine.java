package magazine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Magazine {

    private int capacity;
    private String type;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.capacity = capacity;
        this.type = type;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Cloth> getData() {
        return data;
    }

    public void setData(List<Cloth> data) {
        this.data = data;
    }

    public void addCloth(Cloth cloth) {
        if (capacity > data.size()) {
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        return data.removeIf(cloth -> cloth.getColor().equals(color));
    }

    /*public boolean removeCloth(String color) {
        Cloth cloth = this.getCloth(color);
        data.remove(cloth);
        return cloth != null;
    }*/

    public Cloth getSmallestCloth() {
        return Collections.min(data, Comparator.comparing(Cloth::getSize));
    }

    public Cloth getCloth(String color) {
        return data.stream().filter(cloth -> cloth.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(getType()).append(" magazine contains:").append(System.lineSeparator());
        data.forEach(cloth -> output.append(cloth).append(System.lineSeparator()));
        return output.toString().trim();
    }

}
