package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RepairShop {

    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (capacity > vehicles.size()) {
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        return vehicles.removeIf(vehicle -> vehicle.getVIN().equals(vin));
    }

    public int getCount() {
        return vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return Collections.min(vehicles, Comparator.comparing(Vehicle::getMileage));
    }

    public String report() {

        StringBuilder output = new StringBuilder("Vehicles in the preparatory:").append(System.lineSeparator());
        for (Vehicle vehicle : vehicles) {
            output.append(vehicle).append(System.lineSeparator());
        }
        return output.toString();
    }

}
