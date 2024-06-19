package vendingSystem;

import java.util.*;

public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return drinks.size();
    }

    public void addDrink(Drink drink) {
        if (buttonCapacity > drinks.size()) {
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        return drinks.removeIf(drink -> drink.getName().equals(name));
    }

    public Drink getLongest() {
        return Collections.max(drinks, Comparator.comparingInt(Drink::getVolume));
    }

    /*public Drink getLongest() {
        return this.drinks.stream().max(Comparator.comparingInt(Drink::getVolume)).orElse(null);
    }*/

    public Drink getCheapest() {
        return Collections.min(drinks, Comparator.comparing(Drink::getPrice));
    }

    /*public Drink getCheapest() {
        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }*/

    /*public String buyDrink(String name) {
        //return drinks.stream().filter(drink -> drink.getName().equals(name)).findFirst().orElse(null).toString();
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                return drink.toString();
            }
        }
        return null;
    }*/

    public String buyDrink(String name) {
        Optional<Drink> drink = this.drinks.stream().filter(d -> d.getName().equals(name)).findFirst();
        return drink.map(value -> value.toString().trim()).orElse("");
    }

    /*public String buyDrink(String name) {
        Optional<Drink> drink = this.drinks.stream().filter(d -> d.getName().equals(name)).findFirst();
        return drink.map(value -> value.toString().trim()).orElse("");
    }*/

    public String report() {
        StringBuilder output = new StringBuilder("Drinks available:").append(System.lineSeparator());
        drinks.forEach(drink -> output.append(drink).append(System.lineSeparator()));
        return output.toString().trim();
    }

}
