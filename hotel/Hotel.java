package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
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

    public List<Person> getRoster() {
        return roster;
    }

    public void setRoster(List<Person> roster) {
        this.roster = roster;
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream().filter(person -> person.getName().equals(name)
            && person.getHometown().equals(hometown)).findFirst().orElse(null);
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The people in the hotel {name} are:\n");
        roster.forEach(person -> output.append(person).append(System.lineSeparator()));
        return output.toString();
    }
}
