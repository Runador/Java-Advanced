package vendingMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {

    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        drinks = new ArrayList<>();
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
        return Collections.max(drinks, Comparator.comparing(Drink::getVolume));
    }

    public Drink getCheapest() {
        return Collections.min(drinks, Comparator.comparing(Drink::getPrice));
    }

    public String buyDrink(String name) {
        for (Drink drink : drinks) {
            if (drink.getName().equals(name)) {
                System.out.println(drink);
            }
        }

        return drinks.stream().filter(drink -> drink.getName().equals(name)).findFirst().toString();

    }
    public String report() {
        StringBuilder output = new StringBuilder("Drinks available:").append(System.lineSeparator());
        drinks.forEach(output::append);
        return output.toString();
    }
}
