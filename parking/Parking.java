package parking;

import java.util.ArrayList;
import java.util.Comparator;

public class Parking {

    public ArrayList<Car> data;
    public String type;
    public int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public ArrayList<Car> getData() {
        return data;
    }

    public void setData(ArrayList<Car> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf(car -> car.manufacturer.equals(manufacturer) && car.model.equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(car -> car.manufacturer.equals(manufacturer)
                && car.model.equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The cars are in a car dealership " + this.type).append("\n");
        data.forEach(car -> output.append(car).append("\n"));
        return output.toString().trim();
    }
}
