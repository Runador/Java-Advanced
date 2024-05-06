package LabEncapsulation.FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Team(String name) {
        this.setName(name);
        firstTeam = new ArrayList<>();
        reserveTeam = new ArrayList<>();
    }

    public void addPlayer(Person player) {  // добавляем игрока в зависимости от его возраста
        if (player.getAge() < 40) {
            firstTeam.add(player);
        } else {
            reserveTeam.add(player);
        }
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
         /*запрещаем модификации листа, так как если просто вернуть лист, то к его функциям
         откръвается доступ, и спокойно можно изменить сам лист, например с .add()
         так как List - mutable object, и так нельзя будет его использовать, например .clear()
         immutable object - String например, которъй нужно создать как другую инстанцию*/
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

}
