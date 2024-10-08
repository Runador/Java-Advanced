package carsalesman;

public class Car {

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s:\nPower: %d\nDisplacement: %s\n" +
                        "Efficiency: %s\nWeight: %s\nColor: %s",
                model, getEngine().getModel(), getEngine().getPower(),
                getEngine().getDisplacement(), getEngine().getEfficiency(),
                weight, color);
    }
}
