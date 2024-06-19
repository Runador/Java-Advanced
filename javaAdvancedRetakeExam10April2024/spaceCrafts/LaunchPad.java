package javaAdvancedRetakeExam10April2024.spaceCrafts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LaunchPad {

    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.spacecrafts = new ArrayList<>();
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

    public List<Spacecraft> getSpacecrafts() {
        return spacecrafts;
    }

    public void setSpacecrafts(List<Spacecraft> spacecrafts) {
        this.spacecrafts = spacecrafts;
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (this.spacecrafts.size() < this.capacity) {
            spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

    public boolean removeSpacecraft(String name) {
        return spacecrafts.removeIf(spacecraft -> spacecraft.getName().equals(name));
    }

    public String getHeaviestSpacecraft() {
        Spacecraft heaviestSpacecraft = Collections.max(spacecrafts, Comparator.comparing(Spacecraft::getWeight));
        return String.format("%s - %skg.", heaviestSpacecraft.getName(), heaviestSpacecraft.getWeight());
    }

    public Spacecraft getSpacecraft(String name) {
       return spacecrafts.stream().filter(spacecraft -> spacecraft.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {

        List<Spacecraft> spacecraftList = this.spacecrafts.stream()
                .filter(spacecraft -> spacecraft.getMissionType().equals(missionType))
                .collect(Collectors.toList());
        if (spacecraftList.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return spacecraftList;
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("Spacecrafts launched from " + getName() + ":" + System.lineSeparator());
        AtomicInteger counter = new AtomicInteger(1);
        spacecrafts.forEach(spacecraft -> output.append(counter.getAndIncrement()).append(". ").append(spacecraft.getName())
                .append(System.lineSeparator()));
        if (spacecrafts.isEmpty()) {
            output.append("none");
        }
        return output.toString();
    }

 }
