package google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person() {};

    public Person(String name, Company company, Car car) {
        this.name = name;
        this.company = company;
        this.car = car;
        pokemons = new ArrayList<>();
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }
}
