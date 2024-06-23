package vintageLocos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TrainStation {

    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        locomotives = new ArrayList<>();
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

    public int getRailGauge() {
        return railGauge;
    }

    public void setRailGauge(int railGauge) {
        this.railGauge = railGauge;
    }

    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    public void setLocomotives(List<Locomotive> locomotives) {
        this.locomotives = locomotives;
    }

    public void addLocomotive(Locomotive locomotive) {
        if (capacity > locomotives.size()) {
            if (this.railGauge == locomotive.getGauge()) {
                locomotives.add(locomotive);
            } else {
                int diff = Math.abs(railGauge - locomotive.getGauge());
                System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %d mm.%n", diff);
            }
        } else {
            System.out.println("This train station is full!");
        }
    }

    public boolean removeLocomotive(String name) {
        return locomotives.removeIf(locomotive -> locomotive.getName().equals(name));
    }

    public String getFastestLocomotive() {
        String output;
        if (!locomotives.isEmpty()) {
            Locomotive fastestLocomotive = Collections.max(locomotives, Comparator.comparingInt(Locomotive::getMaxSpeed));
            output = String.format("%s is the fastest locomotive with a maximum speed of %d km/h.",
                    fastestLocomotive.getName(), fastestLocomotive.getMaxSpeed());
        } else {
            output = "There are no locomotives.";
        }
        return output;
    }

    public Locomotive getLocomotive(String name) {
        return locomotives.stream().filter(locomotive -> locomotive.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.locomotives.size();
    }

    public String getOldestLocomotive() {
        String output;
        if (!locomotives.isEmpty()) {
            Locomotive oldest = Collections.min(locomotives, Comparator.comparing(Locomotive::getBuildDate));
            output = oldest.getName();
        } else {
            output = "There are no locomotives.";
        }
        return output;
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        if (locomotives.isEmpty()) {
            output.append("There are no locomotives departing from ").append(getName()).append(" station.");
        } else {
            AtomicInteger atomicInteger = new AtomicInteger(1);
            output.append("Locomotives departed from ").append(getName()).append(":").append(System.lineSeparator());
            locomotives.forEach(locomotive -> output.append(atomicInteger.getAndIncrement())
                    .append(". ").append(locomotive.getName()).append(System.lineSeparator()));
        }
        return output.toString();
    }

}
