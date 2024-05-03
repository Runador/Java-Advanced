package LabEncapsulation.FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> firstTeam;
    private List<Player> reverseTeam;

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Team(String name) {
        this.name = name;
        firstTeam = new ArrayList<>();
        reverseTeam = new ArrayList<>();
    }

    public void addPlayer(Player player) {  // добавляем игрока в зависимости от его возраста
        if (player.getAge() < 40) {
            firstTeam.add(player);
        } else {
            reverseTeam.add(player);
        }
    }

    public List<Player> getFirstTeam() {
        return firstTeam;
    }

    public List<Player> getReverseTeam() {
        return reverseTeam;
    }

}
