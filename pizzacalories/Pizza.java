package pizzacalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, Dough dough) {
        this.name = name;
        this.dough = dough;
        toppings = new ArrayList<>();
    }

    private void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {

    }

    /*public double getOverallCalories() {

    }*/
}
