package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (capacity > registry.size()) {
            registry.add(child);
            return true;
        }
        return false;
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

    public List<Child> getRegistry() {
        return registry;
    }

    public void setRegistry(List<Child> registry) {
        this.registry = registry;
    }

    public boolean removeChild(String firstName) {
        return registry.removeIf(child -> child.getFirstName().equals(firstName));
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String firstName) {
        return registry.stream().filter(child -> child.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    public String registryReport() {

        StringBuilder output = new StringBuilder();
        Comparator<Child> comparator = Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName);
        output.append("Registered children in ").append(getName()).append(":").append(System.lineSeparator());

        List<Child> sortedChildren = registry.stream().sorted(comparator).toList();
        sortedChildren.forEach(child -> output.append("--").append(System.lineSeparator())
                .append(child).append(System.lineSeparator()));
        return output.toString();
    }
}
