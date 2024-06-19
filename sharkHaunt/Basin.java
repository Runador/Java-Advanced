package sharkHaunt;

import java.util.*;

public class Basin {

    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        sharks = new ArrayList<>();
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

    public List<Shark> getSharks() {
        return sharks;
    }

    public void setSharks(List<Shark> sharks) {
        this.sharks = sharks;
    }

    public void addShark(Shark shark) {
        if (sharks.size() < capacity) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        return sharks.removeIf(shark -> shark.getKind().equals(kind));
    }

    public Shark getLargestShark() {
        return Collections.max(sharks, Comparator.comparing(Shark::getLength));
    }

    public Shark getShark(String kind) {
        return sharks.stream().filter(shark -> shark.getKind().equals(kind))
                .findFirst().orElse(null);
    }

    public int getCount() {
        return sharks.size();
    }

    public int getAverageLength() {
        return sharks.stream().mapToInt(Shark::getLength)
                .sum() / sharks.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append("Sharks in ").append(getName()).append(":").append(System.lineSeparator());

        sharks.forEach(shark -> output.append("The ").append(shark.getKind()).append(" is ")
                .append(shark.getLength()).append(" centimeters long, eats ")
                .append(shark.getFood()).append(" and inhabits ")
                .append(shark.getHabitation()).append(".").append(System.lineSeparator()));
        return output.toString();
    }

}

