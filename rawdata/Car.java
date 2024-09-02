package rawdata;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire>tires = new ArrayList<>(4);

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight,
               String cargoType, double tire1Pressure, int tire1Age,
               double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age,
               double tire4Pressure, int tire4Age) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        Tire tire1 = new Tire(tire1Pressure, tire1Age);
        Tire tire2 = new Tire(tire2Pressure, tire2Age);
        Tire tire3 = new Tire(tire3Pressure, tire3Age);
        Tire tire4 = new Tire(tire4Pressure, tire4Age);
        tires.add(tire1);
        tires.add(tire2);
        tires.add(tire3);
        tires.add(tire4);
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }
}
