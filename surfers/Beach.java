package surfers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Beach {

    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        surfers = new ArrayList<>();
    }

    public String addSurfer(Surfer surfer) {

        if (!surfer.getOwnsASurfBoard()) {
            if (surfboardsForRent <= 0) {
                return "There are no free surfboards.";
            }
            if (surfer.getMoney() < 50) {
                return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
            }

            surfer.setMoney(surfer.getMoney() - 50);
            surfboardsForRent--;
        }

        surfers.add(surfer);
        return String.format("Surfer %s added.", surfer.getName());
    }

    public boolean removeSurfer(String name) {
        return surfers.removeIf(surfer -> surfer.getName().equals(name));
    }

    public String getMostExperiencedSurfer() {
        Surfer surfer = surfers.stream().max(Comparator.comparing(Surfer::getAge)).orElse(null);
        if (surfer != null) {
            return String.format("%s is most experienced surfer with %d years experience.", surfer.getName(), surfer.getExperience());
        } else {
            return "There are no surfers.";
        }
    }

    public Surfer getSurfer(String name) {
        return surfers.stream().filter(surfer -> surfer.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return surfers.size();
    }

    public String getSurfersWithPersonalSurfboards() {

        if (surfers.isEmpty()) {
            return "There are no surfers.";
        }

        List<String> surfersWithOwnSurfboardsList =
                surfers.stream().filter(Surfer::getOwnsASurfBoard)
                        .map(Surfer::getName).collect(Collectors.toList());

        if (surfersWithOwnSurfboardsList.isEmpty()) {
            return "There are no surfers.";
        }

        return "Surfers who have their own surfboards: " + String.join(", ", surfersWithOwnSurfboardsList);
    }

    public String getReport() {

        if (surfers.isEmpty()) {
            return "There are no surfers on " + this.name + " beach.";
        }

        StringBuilder output = new StringBuilder();
        output.append("Beach ").append(this.name).append(" was visited by the following surfers:\n");

        for (int i = 0; i < surfers.size(); i++) {
            Surfer surfer = surfers.get(i);
            output.append(i + 1).append(". ").append(surfer.getName()).append(" with ");
            if (surfer.getExperience() > 0) {
                output.append(surfer.getExperience()).append(" years experience");
            } else {
                output.append("no experience");
            }
            output.append(".\n");
        }

        return output.toString().trim();
    }
}
