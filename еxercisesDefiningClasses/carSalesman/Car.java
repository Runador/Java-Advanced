package еxercisesDefiningClasses.carSalesman;

public class Car {

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String toString() {
        /* "{CarModel}:
            {EngineModel}:
            Power: {EnginePower}
            Displacement: {EngineDisplacement}
            Efficiency: {EngineEfficiency}
            Weight: {CarWeight}
            Color: {CarColor}" */

        return getModel() + ":\n" + engine.toString() + "Weight: " + getWeight() +
                "Color: " + getColor();
    }

}
