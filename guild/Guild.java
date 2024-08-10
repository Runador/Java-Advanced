package guild;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
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

    public void addPlayer(Player player) {
        if (capacity > roster.size()) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(player -> player.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Member")) {
                player.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Trial")) {
                player.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> players = new ArrayList<>();
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
                players.add(player);
            }
        }
        roster.removeIf(player -> player.getClazz().equals(clazz));
        Player[] kickedPlayersArray = new Player[players.size()];
        for (int i = 0; i < players.size(); i++) {
            kickedPlayersArray[i] = players.get(i);
        }
        return kickedPlayersArray;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder("Players in the guild: " + this.name).append(":\n");
        roster.forEach(player -> output.append(player).append("\n"));
        return output.toString().trim();
    }
}
