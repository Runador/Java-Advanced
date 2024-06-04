package еxercisesDefiningClasses.rawData;

public class Tire {
    // {Tire1Pressure} {Tire1Age}
    private double tirePressure;
    private int tireAge;

    public Tire(double tirePressure, int tireAge) {
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public double getTirePressure() {
        return tirePressure;
    }

}
