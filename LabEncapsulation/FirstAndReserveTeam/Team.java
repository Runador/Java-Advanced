package LabEncapsulation.FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reverseTeam;

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Team(String name) {
        this.setName(name);
        firstTeam = new ArrayList<>();
        reverseTeam = new ArrayList<>();
    }

    public void addPlayer(Person player) {  // добавляем игрока в зависимости от его возраста
        if (player.getAge() < 40) {
            firstTeam.add(player);
        } else {
            reverseTeam.add(player);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReverseTeam() {
        return Collections.unmodifiableList(this.reverseTeam);
    }

}
