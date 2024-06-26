package еxercisesDefiningClasses.rawData;

import java.util.List;

public class Car {
    // model, engine, cargo, and a collection of exactly 4 tires
    private String model;
    private Engine engine;
    private Cargo cargo;
    private final List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
